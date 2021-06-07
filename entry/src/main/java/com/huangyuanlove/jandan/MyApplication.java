package com.huangyuanlove.jandan;

import ohos.aafwk.ability.AbilityPackage;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends AbilityPackage {

    public static Retrofit retrofit;

    @Override
    public void onInitialize() {
        super.onInitialize();
        retrofit = new Retrofit.Builder().baseUrl("https://i.jandan.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
