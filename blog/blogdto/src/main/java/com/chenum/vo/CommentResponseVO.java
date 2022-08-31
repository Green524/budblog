package com.chenum.vo;

import java.util.Date;
import java.util.List;

public class CommentResponseVO {
    private String id;

    private User commentUser;

    private User targetUser;

    private String content;

    private Date createDate;

    private List<CommentResponseVO> childrenList;

    public record User(String id,String nickName,String avatar){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<CommentResponseVO> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<CommentResponseVO> childrenList) {
        this.childrenList = childrenList;
    }
}
