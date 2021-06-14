package com.huangyuanlove.jandan.net;

import com.huangyuanlove.jandan.data.CommonRequestResult;
import com.huangyuanlove.jandan.data.TreeHole;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface TreeHoleInterface {

    //https://api.jandan.net/api/v1/comment/list/102312
    @GET("https://api.jandan.net/api/v1/comment/list/102312")
    Call<CommonRequestResult<TreeHole>> getTreeHolePost(@QueryMap Map<String,Integer> queryMap);
}
