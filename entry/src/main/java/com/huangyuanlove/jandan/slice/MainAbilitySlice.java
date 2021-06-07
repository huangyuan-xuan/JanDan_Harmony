package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.NewsVO;
import com.huangyuanlove.jandan.data.RequestResultBean;
import com.huangyuanlove.jandan.net.NewsInterface;
import io.reactivex.rxjava3.annotations.Nullable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
    }

    @Override
    public void onActive() {
        super.onActive();
       Text info = (Text) findComponentById(ResourceTable.Id_text_helloworld);
        NewsInterface   newsService = MyApplication.retrofit.create(NewsInterface.class);
        Call<RequestResultBean<NewsVO>> call = newsService.getNews(1);
        call.enqueue(new Callback<RequestResultBean<NewsVO>>() {
            @Override
            public void onResponse(@Nullable Call<RequestResultBean<NewsVO>> call, @Nullable Response<RequestResultBean<NewsVO>> response) {
                if(response.body()!=null &&"ok".equals(response.body().getStatus()) ){
                    info.setText(response.body().getPosts().toString());
                }
            }

            @Override
            public void onFailure(Call<RequestResultBean<NewsVO>> call, Throwable t) {
                info.setText("请求出错");
            }
        });

    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
