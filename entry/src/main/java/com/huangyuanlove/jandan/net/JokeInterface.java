package com.huangyuanlove.jandan.net;



import com.huangyuanlove.jandan.data.JokeVO;
import com.huangyuanlove.jandan.data.RequestResultBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface JokeInterface {
    @GET("?oxwlxojflwblxbsapi=jandan.get_duan_comments")
    Call<RequestResultBean<JokeVO>> getJokes(@Query("page") int pageNumber);

}
