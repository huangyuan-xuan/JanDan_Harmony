package com.huangyuanlove.jandan.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewResult {


    @SerializedName("status")
    public String status;
    @SerializedName("count")
    public int count;
    @SerializedName("count_total")
    public int countTotal;
    @SerializedName("pages")
    public int pages;
    @SerializedName("posts")
    public List<Posts> posts;

    public static class Posts {
        @SerializedName("id")
        public int id;
        @SerializedName("url")
        public String url;
        @SerializedName("title")
        public String title;
        @SerializedName("excerpt")
        public String excerpt;
        @SerializedName("date")
        public String date;
        @SerializedName("tags")
        public List<Tags> tags;
        @SerializedName("author")
        public Author author;
        @SerializedName("comment_count")
        public int commentCount;
        @SerializedName("comment_status")
        public String commentStatus;
        @SerializedName("custom_fields")
        public CustomFields customFields;






    }
    public static class CustomFields {
        @SerializedName("thumb_c")
        public List<String> thumbC;
    }
    public static class Tags {
        @SerializedName("id")
        public int id;
        @SerializedName("slug")
        public String slug;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        @SerializedName("post_count")
        public int postCount;
    }
    public static class Author {
        @SerializedName("id")
        public int id;
        @SerializedName("slug")
        public String slug;
        @SerializedName("name")
        public String name;
        @SerializedName("first_name")
        public String firstName;
        @SerializedName("last_name")
        public String lastName;
        @SerializedName("nickname")
        public String nickname;
        @SerializedName("url")
        public String url;
        @SerializedName("description")
        public String description;
    }

    @Override
    public String toString() {
        return "NewResult{" +
                "status='" + status + '\'' +
                ", count=" + count +
                ", countTotal=" + countTotal +
                ", pages=" + pages +
                ", posts=" + posts +
                '}';
    }
}
