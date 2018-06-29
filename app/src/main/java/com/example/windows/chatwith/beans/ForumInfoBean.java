package com.example.windows.chatwith.beans;

import java.util.ArrayList;

/**
 * Created by Windows on 2018/6/29.
 * 每一篇文章都应该有其独一的Id
 * 然后评论根据其Id再去生成第一无二的id
 */

public class ForumInfoBean {
    private String articleId;//此处不用
    private String articleTitle;
    private String articleContent;
    private String publisherName;
    private String publisherHp;
    private long publishTime;

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherHp() {
        return publisherHp;
    }

    public void setPublisherHp(String publisherHp) {
        this.publisherHp = publisherHp;
    }

    private ArrayList<String> publishImage;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public ArrayList<String> getPublishImage() {
        return publishImage;
    }

    public void setPublishImage(ArrayList<String> publishImage) {
        this.publishImage = publishImage;
    }
}
