package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.CommonRequestResult;
import com.huangyuanlove.jandan.data.Pictures;
import com.huangyuanlove.jandan.net.PicsInterface;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.Text;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

public class FunnyPicturesFraction extends Fraction {

    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {
      Component component=  scatter.parse(ResourceTable.Layout_fraction_funny_picture,container,false);
        Text text = (Text) component.findComponentById(ResourceTable.Id_info);
        PicsInterface picsService =    MyApplication.retrofit.create(PicsInterface.class);
        Call<CommonRequestResult<Pictures>> call =   picsService.getPics(new HashMap<>());
        call.enqueue(new Callback<CommonRequestResult<Pictures>>() {
            @Override
            public void onResponse(Call<CommonRequestResult<Pictures>> call, Response<CommonRequestResult<Pictures>> response) {
                assert response.body() != null;
                if(response.body().code ==0){
                   text.setText(response.body().data.toString());
               }
            }

            @Override
            public void onFailure(Call<CommonRequestResult<Pictures>> call, Throwable throwable) {
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
