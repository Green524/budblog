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

    private Integer readTime;

    private String contribution;

    private Boolean isLike;

    private Boolean isComment;

    private Boolean isAdmiration;

    private Byte status;

    private Date publishTime;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private String lastReviewer;

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Article{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", markdown='").append(markdown).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", contentTag='").append(contentTag).append('\'');
        sb.append(", wordCount=").append(wordCount);
        sb.append(", readTime=").append(readTime);
        sb.append(", isLike=").append(isLike);
        sb.append(", isComment=").append(isComment);
        sb.append(", isAdmiration=").append(isAdmiration);
        sb.append(", status=").append(status);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", lastReviewer='").append(lastReviewer).append('\'');
        sb.append(", contribution='").append(contribution).append('\'');
        sb.append('}');
        return sb.toString();
    }
}