package com.huangyuanlove.jandan.net;

import com.huangyuanlove.jandan.data.NewResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {


    //https://i.jandan.net/?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields&page=1&custom_fields=thumb_c,views&dev=1

    @GET("https://i.jandan.net/?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields&custom_fields=thumb_c,views&dev=1")
    Call<NewResult> getNews(@Query("page") int pageNumber);


}
