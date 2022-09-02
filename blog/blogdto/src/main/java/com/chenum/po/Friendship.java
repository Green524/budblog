package com.chenum.po;

import java.io.Serializable;
import java.util.Date;

public class Friendship implements Serializable {
    private String id;

    private String friendshipName;

    private Byte avatarMethod;

    private String thirdParty;

    private String avatarUrl;

    private String signature;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private Date lastReviewer;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFriendshipName() {
        return friendshipName;
    }

    public void setFriendshipName(String friendshipName) {
        this.friendshipName = friendshipName == null ? null : friendshipName.trim();
    }

    public Byte getAvatarMethod() {
        return avatarMethod;
    }

    public void setAvatarMethod(Byte avatarMethod) {
        this.avatarMethod = avatarMethod;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty == null ? null : thirdParty.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
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

    public Date getLastReviewer() {
        return lastReviewer;
    }

    public void setLastReviewer(Date lastReviewer) {
        this.lastReviewer = lastReviewer;
    }
}