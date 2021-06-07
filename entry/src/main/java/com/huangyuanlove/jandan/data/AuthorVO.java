package com.huangyuanlove.jandan.data;



import java.io.Serializable;

/**
 * Created by HuangYuan on 2017/8/15.
 */

public class AuthorVO implements Serializable {


    /**
     * id : 676
     * slug : tommygun977
     * name : Tommygun977
     * first_name : 段
     * last_name : 启宴
     * nickname : Tommygun977
     * url :
     * description :
     */

    private int id;
    private String slug;
    private String name;
    private String first_name;
    private String last_name;
    private String nickname;
    private String url;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public AuthorVO() {
    }

}
