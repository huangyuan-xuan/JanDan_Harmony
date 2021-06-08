package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.NewsVO;
import com.huangyuanlove.jandan.data.RequestResultBean;
import com.huangyuanlove.jandan.net.NewsInterface;
import io.reactivex.rxjava3.annotations.Nullable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.PageSlider;
import ohos.agp.components.TabList;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.Console;
import java.util.ArrayList;

public class MainAbilitySlice extends AbilitySlice {
    private static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");
    private TabList tabList;
    private PageSlider pageSlider;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
    }

    @Override
    public void onActive() {
        super.onActive();
        initView();

        NewsInterface   newsService = MyApplication.retrofit.create(NewsInterface.class);
        Call<RequestResultBean<NewsVO>> call = newsService.getNews(1);
        call.enqueue(new Callback<RequestResultBean<NewsVO>>() {
            @Override
            public void onResponse(@Nullable Call<RequestResultBean<NewsVO>> call, @Nullable Response<RequestResultBean<NewsVO>> response) {
                if(response.body()!=null &&"ok".equals(response.body().getStatus()) ){
                    HiLog.info(LABEL, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<RequestResultBean<NewsVO>> call, Throwable t) {
            }
        });

    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    private void initView(){

        initTabList();
        initPageSlide();


    }
    private void initTabList(){
        tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        TabList.Tab tab = tabList.new Tab(getContext());
        tab.setText("新鲜事");
        tabList.addTab(tab);

        tab = tabList.new Tab(getContext());
        tab.setText("无聊图");
        tabList.addTab(tab);

        tab = tabList.new Tab(getContext());
        tab.setText("随手拍");
        tabList.addTab(tab);

        tab = tabList.new Tab(getContext());
        tab.setText("树洞");
        tabList.addTab(tab);
        tabList.setFixedMode(true);
        tabList.selectTabAt(0);
        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {
                int position = tab.getPosition();
                HiLog.info(LABEL, "onSelected tabPosition:" + position);
                pageSlider.setCurrentPage(position,true);
            }

            @Override
            public void onUnselected(TabList.Tab tab) {
                HiLog.info(LABEL, "onUnselected tabPosition:" + tab.getPosition());
            }

            @Override
            public void onReselected(TabList.Tab tab) {
                HiLog.info(LABEL, "onReselected tabPosition:" + tab.getPosition());
            }
        });


    }
    private void initPageSlide(){
        pageSlider = (PageSlider) findComponentById(ResourceTable.Id_page_slider);
        ArrayList<String> pageData = new ArrayList<>();
        pageData.add("新鲜事");
        pageData.add("无聊图");
        pageData.add("随手拍");
        pageData.add("树洞");
        pageSlider.setProvider(new MainPageSlideProvider(pageData));
        pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) {
                HiLog.info(LABEL, "onPageSliding: i->" +i+",v->"+v +",i1->" +i1 );
                tabList.doFlingX(i1);

            }

            @Override
            public void onPageSlideStateChanged(int i) {
                HiLog.info(LABEL, "onPageSlideStateChanged: i->" +i);
            }

            @Override
            public void onPageChosen(int i) {
                HiLog.info(LABEL, "onPageChosen: i->" +i);
                tabList.selectTabAt(i);
            }
        });
    }
}
