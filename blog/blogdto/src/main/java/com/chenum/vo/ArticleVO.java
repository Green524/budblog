package com.chenum.vo;

import java.io.Serializable;
import java.util.Date;

public class ArticleVO implements Serializable {
    private String id;

    private String title;

    private String content;

    private String author;

    private String contentTag;

    private Boolean isLike;

    private Boolean isComment;

    private Boolean isAdmiration;

    private String creator;

    private String contribution;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContentTag() {
        return contentTag;
    }

    public void setContentTag(String contentTag) {
        this.contentTag = contentTag == null ? null : contentTag.trim();
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public Boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(Boolean isComment) {
        this.isComment = isComment;
    }

    public Boolean getIsAdmiration() {
        return isAdmiration;
    }

    public void setIsAdmiration(Boolean isAdmiration) {
        this.isAdmiration = isAdmiration;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution == null ? null : contribution.trim();
    }
}