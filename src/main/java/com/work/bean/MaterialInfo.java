package com.work.bean;

import java.util.Date;

public class MaterialInfo {
    private  Integer id;
    private Integer type;
    private Integer purchase;
    private Date time;
    private Integer company;
    private Integer number;
    private Integer state;
    private Integer requisition;

    @Override
    public String toString() {
        return "MaterialInfo{" +
                "id=" + id +
                ", type=" + type +
                ", purchase=" + purchase +
                ", time=" + time +
                ", company=" + company +
                ", number=" + number +
                ", state=" + state +
                ", requisition=" + requisition +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRequisition() {
        return requisition;
    }

    public void setRequisition(Integer requisition) {
        this.requisition = requisition;
    }
}
