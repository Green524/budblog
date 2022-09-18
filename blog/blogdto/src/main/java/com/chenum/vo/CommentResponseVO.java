package com.chenum.vo;

import java.util.Date;
import java.util.List;

public class CommentResponseVO {
    private Integer id;

    private User commentUser;

    private User targetUser;

    private String content;

    private Date createDate;

    private List<CommentResponseVO> childrenList;

    public record User(Integer id,String nickName,boolean isAuthor,String avatar){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CommentResponseVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", commentUser=").append(commentUser);
        sb.append(", targetUser=").append(targetUser);
        sb.append(", content='").append(content).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", childrenList=").append(childrenList);
        sb.append('}');
        return sb.toString();
    }
}
