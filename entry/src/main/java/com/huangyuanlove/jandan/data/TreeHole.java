package com.huangyuanlove.jandan.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TreeHole {

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
    public List<?> images;
    @SerializedName("sub_comment_count")
    public int subCommentCount;


    @Override
    public String toString() {
        return "TreeHole{" +
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
                ", subCommentCount=" + subCommentCount +
                '}';
    }
}
