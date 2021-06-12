package com.huangyuanlove.jandan.net;
import com.huangyuanlove.jandan.data.CommonRequestResult;

import com.huangyuanlove.jandan.data.Pictures;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;


public interface PicsInterface {
    /**
     * https://api.jandan.net/api/v1/comment/list/26402?start_id=4939848
     * “start_id” 开始的id， start_id不传默认取最近的
     */
    @GET("https://api.jandan.net/api/v1/comment/list/26402?start_id=4939848")
    Call<CommonRequestResult<Pictures>> getPics(@QueryMap Map<String,Integer> queryMap);
}
