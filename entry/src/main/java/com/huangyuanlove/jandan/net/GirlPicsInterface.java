package com.huangyuanlove.jandan.net;


import com.huangyuanlove.jandan.data.CommonRequestResult;
import com.huangyuanlove.jandan.data.Girls;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Created by huangyuan on 2017/8/15.
 */

public interface GirlPicsInterface {
    /**
     * https://api.jandan.net/api/v1/comment/list/108629?start_id=4939860
     *  start_id 开始的id，不传默认取最近的
     */
    @GET("https://api.jandan.net/api/v1/comment/list/108629")
    Call<CommonRequestResult<Girls>> getGirlPics(@QueryMap Map<String,Integer> queryMap);
}
