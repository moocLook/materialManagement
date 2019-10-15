package com.work.bean;

import java.util.Date;

/**
 * 查询我的领料单的条件封装的对象.
 */
public class MyRequisitionSearch {


    private String name;//领料单名字.
    private Date startTime;//开始时间.
    private Date endTime;//结束时间.
    private String creatorId;//创建者id

    @Override
    public String toString() {
        return "MyRequisitionSearch{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creatorId='" + creatorId + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
}
