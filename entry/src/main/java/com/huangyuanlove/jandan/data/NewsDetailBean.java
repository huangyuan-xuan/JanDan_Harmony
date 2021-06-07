package com.huangyuanlove.jandan.data;


import java.io.Serializable;

/**
 * Created by HuangYuan on 2017/8/22.
 */

public class NewsDetailBean implements Serializable {
    private String status;
    private NewsDetailVO post;
    private String previous_url;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NewsDetailVO getPost() {
        return post;
    }

    public void setPost(NewsDetailVO post) {
        this.post = post;
    }

    public String getPrevious_url() {
        return previous_url;
    }

    public void setPrevious_url(String previous_url) {
        this.previous_url = previous_url;
    }

}
