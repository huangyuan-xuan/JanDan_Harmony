package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.NewsDetailAbility;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.NewResult;
import com.huangyuanlove.jandan.net.NewsInterface;
import com.huangyuanlove.jandan.provider.NewsListProvider;
import io.reactivex.rxjava3.annotations.Nullable;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class NewsFraction extends Fraction {

    private Component component;
    private NewsListProvider newsListProvider;
    private ArrayList<NewResult.Posts> data;
    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {

         component = scatter.parse(ResourceTable.Layout_fraction_news,container,false);
        initView();
        NewsInterface newsService = MyApplication.retrofit.create(NewsInterface.class);
        Call<NewResult> call = newsService.getNews(1);
        call.enqueue(new Callback<NewResult>() {
            @Override
            public void onResponse(@Nullable Call<NewResult> call, @Nullable Response<NewResult> response) {
                if(response.body()!=null &&"ok".equals(response.body().status) ){
                    data.addAll(response.body().posts);
                    update();
                }
            }

            @Override
            public void onFailure(Call<NewResult> call, Throwable t) {
                HiLog.debug(MainAbilitySlice.LABEL,"request for news failure" + t.toString());
                new ToastDialog(container.getContext())
                        .setText("请求出错")
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
            }
        });
        return component;
    }

    private void initView(){
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_news_list);
        data = new ArrayList<>();
        newsListProvider = new NewsListProvider(data);
        listContainer.setItemProvider(newsListProvider);
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                NewResult.Posts post = data.get(i);

                Intent intent = new Intent();
                Operation operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withAbilityName(NewsDetailAbility.class)
                        .build();
                intent.setOperation(operation);
                String imageUrl = null;
                if(post.customFields!=null && post.customFields.thumbC!=null && post.customFields.thumbC.size()>0){
                    imageUrl =post.customFields.thumbC.get(0);
                }
                intent.setParam("id",post.id);
                intent.setParam("image",imageUrl);
                intent.setParam("url",post.url);
                getFractionAbility().startAbility(intent);
            }
        });
        listContainer.setItemLongClickedListener(new ListContainer.ItemLongClickedListener() {
            @Override
            public boolean onItemLongClicked(ListContainer listContainer, Component component, int i, long l) {
                return true;
            }
        });
    }
    private void update(){
        newsListProvider.setData(data);
        newsListProvider.notifyDataChanged();
    }


}
