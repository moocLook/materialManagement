package com.work.bean;

public class RequisitionSearch {


    private String name;//领料单名字
    private String creatorId;//创建者id

    @Override
    public String toString() {
        return "RequisitionSearch{" +
                "name='" + name + '\'' +
                ", creator='" + creatorId + '\'' +
                '}';
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
