package com.huangyuanlove.jandan.data;


import java.io.Serializable;

public class NewsVO implements Serializable {
    private int id;
    private String title;
    private String excerpt;
    private AuthorVO author;
    private CustomFields_Thumb_cVO custom_fields;
    private int comment_count;
    private String  date;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public AuthorVO getAuthor() {
        return author;
    }

    public void setAuthorVO(AuthorVO author) {
        this.author = author;
    }

    public CustomFields_Thumb_cVO getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(CustomFields_Thumb_cVO custom_fields) {
        this.custom_fields = custom_fields;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NewsVO{" +
                "title='" + title + '\'' +
                ", excerpt='" + excerpt + '\'' +
                '}';
    }
}
