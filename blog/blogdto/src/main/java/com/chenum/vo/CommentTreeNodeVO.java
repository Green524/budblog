package com.chenum.vo;

import com.chenum.po.TreeNode;

import java.util.Date;

public class CommentTreeNodeVO extends TreeNode {
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getCommenterEmail() {
        return commenterEmail;
    }

    public void setCommenterEmail(String commenterEmail) {
        this.commenterEmail = commenterEmail;
    }

    public String getPersonalizedUrl() {
        return personalizedUrl;
    }

    public void setPersonalizedUrl(String personalizedUrl) {
        this.personalizedUrl = personalizedUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CommentTreeNodeVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", parentId='").append(parentId).append('\'');
        sb.append(", status=").append(status);
        sb.append(", articleId='").append(articleId).append('\'');
        sb.append(", commenter='").append(commenter).append('\'');
        sb.append(", commenterEmail='").append(commenterEmail).append('\'');
        sb.append(", personalizedUrl='").append(personalizedUrl).append('\'');
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", lastReviewer='").append(lastReviewer).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
