package com.chenum.po;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private String id;

    private String parentId;

    private Byte status;

    private String articleId;

    private String commenter;

    private String commenterEmail;

    private String personalizedUrl;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private String lastReviewer;

    private String comment;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter == null ? null : commenter.trim();
    }

    public String getCommenterEmail() {
        return commenterEmail;
    }

    public void setCommenterEmail(String commenterEmail) {
        this.commenterEmail = commenterEmail == null ? null : commenterEmail.trim();
    }

    public String getPersonalizedUrl() {
        return personalizedUrl;
    }

    public void setPersonalizedUrl(String personalizedUrl) {
        this.personalizedUrl = personalizedUrl == null ? null : personalizedUrl.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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

    public String getLastReviewer() {
        return lastReviewer;
    }

    public void setLastReviewer(String lastReviewer) {
        this.lastReviewer = lastReviewer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}