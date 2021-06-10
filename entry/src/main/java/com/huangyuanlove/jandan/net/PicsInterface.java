package com.huangyuanlove.jandan.net;
import com.huangyuanlove.jandan.data.PicsVO;
import com.huangyuanlove.jandan.data.RequestResultBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by HuangYuan on 2017/8/15.
 */

public interface PicsInterface {
//    https://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_pic_comments&page=1
    @GET("?oxwlxojflwblxbsapi=jandan.get_pic_comments")
    Call<RequestResultBean<PicsVO>> getPics(@Query("page") int page);

    @POST("index.php?acv_ajax=true")
    Call<ResponseBody> votePic(@Query("option") int option, @Field("ID") String id);

}
