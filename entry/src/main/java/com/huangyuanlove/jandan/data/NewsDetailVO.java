package com.huangyuanlove.jandan.data;


import java.io.Serializable;

/**
 * Created by HuangYuan on 2017/8/22.
 */

public class NewsDetailVO implements Serializable {
    private int id;
    private String content;
    private String date;
    private String modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "NewsDetailVO{" +
                "content='" + content + '\'' +
                '}';
    }
}
