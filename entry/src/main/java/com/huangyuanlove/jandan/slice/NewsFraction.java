package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.NewResult;
import com.huangyuanlove.jandan.net.NewsInterface;
import com.huangyuanlove.jandan.provider.NewsListProvider;
import io.reactivex.rxjava3.annotations.Nullable;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class NewsFraction extends Fraction {

    private Component component;
    private NewsListProvider newsListProvider;
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
                    setDataList(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewResult> call, Throwable t) {

            }
        });
        return component;
    }

    private void initView(){
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_news_list);
        List<NewResult.Posts> list = new ArrayList<>();
        newsListProvider = new NewsListProvider(list);
        listContainer.setItemProvider(newsListProvider);
    }
    private void setDataList(NewResult newResult){
        newsListProvider.setData(newResult.posts);
        newsListProvider.notifyDataChanged();
    }


}
