package com.example.windows.chatwith.beans;

/**
 * Created by Windows on 2018/6/29.
 */

public class ForumCommentBean {
    private Object reviewId;
    private String reviewerHp;
    private String reviewerName;
    private long reviewTime;
    private String reviewContent;
    private String replyName;
    private int replyId;


    //下面这个图片为待实现，懒得实现，急着回家
    //private ArrayList<String> reviewImage;

    public Object getReviewId() {
        return reviewId;
    }

    public void setReviewId(Object reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewerHp() {
        return reviewerHp;
    }

    public void setReviewerHp(String reviewerHp) {
        this.reviewerHp = reviewerHp;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public long getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(long reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }
}
