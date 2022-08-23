package com.chenum.entity;

import java.util.Date;

public class BaseVO{

    private int pageNum = 1;

    private int  pageSize = 10;

    private Date beginTime;

    private Date endTime;

    public BaseVO() {
    }

    public BaseVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public BaseVO(Date beginTime, Date endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public BaseVO(int pageNum, int pageSize, Date beginTime, Date endTime) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
