package com.chenum.vo;

import com.chenum.entity.BaseVO;

import java.util.Date;
import java.util.List;

public class ArticleVO extends BaseVO {
    private String id;

    private String title;

    private String content;

    private List<Object> author;

    private String contentTag;

    private Boolean isLike;

    private Boolean isComment;

    private Boolean isAdmiration;

    private Boolean isPublish;

    private String creator;

    private List<Object> contribution;

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

    public List<Object> getContribution() {
        return contribution;
    }

    public void setContribution(List<Object> contribution) {
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

    public Boolean getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Boolean publish) {
        isPublish = publish;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArticleVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", author=").append(author);
        sb.append(", contentTag='").append(contentTag).append('\'');
        sb.append(", isLike=").append(isLike);
        sb.append(", isComment=").append(isComment);
        sb.append(", isAdmiration=").append(isAdmiration);
        sb.append(", isPublish=").append(isPublish);
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", contribution=").append(contribution);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}