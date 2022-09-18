package com.chenum.vo;

import com.chenum.entity.BaseVO;

import java.util.Date;

public class CommentVO extends BaseVO {

    private Integer id;

    private Integer parentId;

    private String articleId;

    private String commenter;

    private String commenterEmail;

    private String avatarUrl;

    private String creator;

    private Date lastReviewer;

    private String comment;

    private Date createTime;

    private Date updateTime;

    private Boolean isAuthor;

    public Integer getId() {
        return id;
    }

    public CommentVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public CommentVO setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getArticleId() {
        return articleId;
    }

    public CommentVO setArticleId(String articleId) {
        this.articleId = articleId;
        return this;
    }

    public String getCommenter() {
        return commenter;
    }

    public CommentVO setCommenter(String commenter) {
        this.commenter = commenter;
        return this;
    }

    public String getCommenterEmail() {
        return commenterEmail;
    }

    public CommentVO setCommenterEmail(String commenterEmail) {
        this.commenterEmail = commenterEmail;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public CommentVO setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public CommentVO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public Date getLastReviewer() {
        return lastReviewer;
    }

    public CommentVO setLastReviewer(Date lastReviewer) {
        this.lastReviewer = lastReviewer;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CommentVO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public CommentVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public CommentVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Boolean getIsAuthor() {
        return isAuthor;
    }

    public CommentVO setIsAuthor(Boolean author) {
        isAuthor = author;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CommentVO{");
        sb.append("id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", articleId='").append(articleId).append('\'');
        sb.append(", commenter='").append(commenter).append('\'');
        sb.append(", commenterEmail='").append(commenterEmail).append('\'');
        sb.append(", avatarUrl='").append(avatarUrl).append('\'');
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", lastReviewer=").append(lastReviewer);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isAuthor=").append(isAuthor);
        sb.append('}');
        return sb.toString();
    }
}
