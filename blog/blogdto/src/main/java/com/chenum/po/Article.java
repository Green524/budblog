package com.chenum.po;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private String id;

    private String title;

    private String content;

    private String markdown;

    private String author;

    private String contentTag;

    private Long wordCount;

    private Boolean isLike;

    private Boolean isComment;

    private Boolean isAdmiration;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private String lastReviewer;

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

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown == null ? null : markdown.trim();
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

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
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

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution == null ? null : contribution.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", markdown='" + markdown + '\'' +
                ", author='" + author + '\'' +
                ", contentTag='" + contentTag + '\'' +
                ", wordCount=" + wordCount +
                ", isLike=" + isLike +
                ", isComment=" + isComment +
                ", isAdmiration=" + isAdmiration +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastReviewer=" + lastReviewer +
                ", contribution='" + contribution + '\'' +
                '}';
    }
}