package com.huangyuanlove.jandan.data;

import java.util.List;

/**
 * Created by huangyuan on 2017/8/15.
 */

public class GirlPicsVO {


    /**
     * comment_ID : 3536015
     * comment_post_ID : 21183
     * comment_author : 考据党
     * comment_author_email : pphn@yeah.net
     * comment_author_url :
     * comment_author_IP : 113.46.78.252
     * comment_date : 2017-08-15 20:56:53
     * comment_date_gmt : 2017-08-15 12:56:53
     * comment_content : <img src="http://wx3.sinaimg.cn/mw600/005VghJvly1fikpelf85yj30go0m8wg6.jpg" />
     * comment_karma : 0
     * comment_approved : 1
     * comment_agent : Jandan Android App V4.3.1.1;eyJzaWduIjoiZDg5ZmQzOTI3MDUxZDY3MzdkOGMxNjUyMmVhNDc2ZWIifQ==
     * comment_type :
     * comment_parent : 0
     * user_id : 0
     * comment_subscribe : N
     * comment_reply_ID : 0
     * vote_positive : 14
     * vote_negative : 3
     * vote_ip_pool :
     * sub_comment_count : 1
     * text_content :
     * pics : ["http://wx3.sinaimg.cn/mw600/005VghJvly1fikpelf85yj30go0m8wg6.jpg"]
     */

    private String comment_author;
    private String comment_date_gmt;
    private String vote_positive;
    private String vote_negative;
    private String sub_comment_count;
    private String text_content;
    private List<String> pics;

    public String getComment_author() {
        return comment_author;
    }

    public void setComment_author(String comment_author) {
        this.comment_author = comment_author;
    }

    public String getComment_date_gmt() {
        return comment_date_gmt;
    }

    public void setComment_date_gmt(String comment_date_gmt) {
        this.comment_date_gmt = comment_date_gmt;
    }

    public String getVote_positive() {
        return vote_positive;
    }

    public void setVote_positive(String vote_positive) {
        this.vote_positive = vote_positive;
    }

    public String getVote_negative() {
        return vote_negative;
    }

    public void setVote_negative(String vote_negative) {
        this.vote_negative = vote_negative;
    }

    public String getSub_comment_count() {
        return sub_comment_count;
    }

    public void setSub_comment_count(String sub_comment_count) {
        this.sub_comment_count = sub_comment_count;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }
}
