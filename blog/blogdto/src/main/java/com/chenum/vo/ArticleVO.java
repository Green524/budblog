package com.chenum.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ArticleVO{
    private String id;

    private String title;

    private String content;

    private List<Object> author;

    private String contentTag;

    private Boolean isLike;

    private Boolean isComment;

    private Boolean isAdmiration;

    private String creator;

    private String contribution;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Object> getAuthor() {
        return author;
    }

    public void setAuthor(List<Object> author) {
        this.author = author;
    }

    public String getContentTag() {
        return contentTag;
    }

    public void setContentTag(String contentTag) {
        this.contentTag = contentTag;
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean like) {
        isLike = like;
    }

    public Boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(Boolean comment) {
        isComment = comment;
    }

    public Boolean getIsAdmiration() {
        return isAdmiration;
    }

    public void setIsAdmiration(Boolean admiration) {
        isAdmiration = admiration;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", contentTag='" + contentTag + '\'' +
                ", isLike=" + isLike +
                ", isComment=" + isComment +
                ", isAdmiration=" + isAdmiration +
                ", creator='" + creator + '\'' +
                ", contribution='" + contribution + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}