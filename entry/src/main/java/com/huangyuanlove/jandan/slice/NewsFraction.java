package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.NewsVO;
import com.huangyuanlove.jandan.data.RequestResultBean;
import com.huangyuanlove.jandan.net.NewsInterface;
import io.reactivex.rxjava3.annotations.Nullable;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFraction extends Fraction {

    private Component component;

    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {
         component = scatter.parse(ResourceTable.Layout_fraction_news,container,false);
        Text text = (Text) component.findComponentById(ResourceTable.Id_info);
        NewsInterface newsService = MyApplication.retrofit.create(NewsInterface.class);
        Call<RequestResultBean<NewsVO>> call = newsService.getNews(1);
        call.enqueue(new Callback<RequestResultBean<NewsVO>>() {
            @Override
            public void onResponse(@Nullable Call<RequestResultBean<NewsVO>> call, @Nullable Response<RequestResultBean<NewsVO>> response) {
                if(response.body()!=null &&"ok".equals(response.body().getStatus()) ){
                    text.setText(response.body().getPosts().toString());
                }
            }

            @Override
            public void onFailure(Call<RequestResultBean<NewsVO>> call, Throwable t) {
                text.setText("请求出错");
            }
        });
        return component;
    }


    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
    }
}
