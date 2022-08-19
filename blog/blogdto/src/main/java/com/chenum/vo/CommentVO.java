package com.chenum.vo;

import com.chenum.entity.BaseVO;

import java.util.Date;

public class CommentVO extends BaseVO {

    private String id;

    private String parentId;

    private String articleId;

    private String commenter;

    private String commenterEmail;

    private String personalizedUrl;

    private String creator;

    private Date lastReviewer;

    private String comment;

    private Date createTime;

    private Date updateTime;

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

    public Date getLastReviewer() {
        return lastReviewer;
    }

    public void setLastReviewer(Date lastReviewer) {
        this.lastReviewer = lastReviewer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        final StringBuffer sb = new StringBuffer("CommentVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", parentId='").append(parentId).append('\'');
        sb.append(", articleId='").append(articleId).append('\'');
        sb.append(", commenter='").append(commenter).append('\'');
        sb.append(", commenterEmail='").append(commenterEmail).append('\'');
        sb.append(", personalizedUrl='").append(personalizedUrl).append('\'');
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", lastReviewer=").append(lastReviewer);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}
