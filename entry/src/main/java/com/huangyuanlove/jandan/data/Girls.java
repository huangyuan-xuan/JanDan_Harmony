package com.huangyuanlove.jandan.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Girls {


    @SerializedName("id")
    public int id;
    @SerializedName("post_id")
    public int postId;
    @SerializedName("author")
    public String author;
    @SerializedName("author_type")
    public int authorType;
    @SerializedName("date")
    public String date;
    @SerializedName("date_unix")
    public int dateUnix;
    @SerializedName("post_title")
    public String postTitle;
    @SerializedName("content")
    public String content;
    @SerializedName("user_id")
    public int userId;
    @SerializedName("vote_positive")
    public int votePositive;
    @SerializedName("vote_negative")
    public int voteNegative;
    @SerializedName("images")
    public List<Images> images;

    public static class Images {
        @SerializedName("url")
        public String url;
        @SerializedName("full_url")
        public String fullUrl;
        @SerializedName("host")
        public String host;
        @SerializedName("thumb_size")
        public String thumbSize;
        @SerializedName("ext")
        public String ext;
        @SerializedName("file_name")
        public String fileName;
    }

    @Override
    public String toString() {
        return "Girls{" +
                "id=" + id +
                ", postId=" + postId +
                ", author='" + author + '\'' +
                ", authorType=" + authorType +
                ", date='" + date + '\'' +
                ", dateUnix=" + dateUnix +
                ", postTitle='" + postTitle + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", votePositive=" + votePositive +
                ", voteNegative=" + voteNegative +
                ", images=" + images +
                '}';
    }
}
