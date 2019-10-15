package com.work.bean;

import javax.persistence.Id;
import java.util.Date;

public class Requisition {
    private Integer id;//领料单编号
    private String user_id;//创建者id
    private Date create_time;//创建时间
    private String creator;//创建者名字
    private String requester;//领料人
    private Integer requisition_state;//状态
    private String excutor;//发料人
    private Date end_time;//完成时间
    private String remark;//备注.

    @Override
    public String toString() {
        return "Requisition{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", create_time=" + create_time +
                ", creator='" + creator + '\'' +
                ", requester='" + requester + '\'' +
                ", requisition_state=" + requisition_state +
                ", excutor='" + excutor + '\'' +
                ", end_time=" + end_time +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public Integer getRequisition_state() {
        return requisition_state;
    }

    public void setRequisition_state(Integer requisition_state) {
        this.requisition_state = requisition_state;
    }

    public String getExcutor() {
        return excutor;
    }

    public void setExcutor(String excutor) {
        this.excutor = excutor;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
