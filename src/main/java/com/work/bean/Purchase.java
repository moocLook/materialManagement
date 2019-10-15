package com.work.bean;

import java.util.Date;

/**
 * 采购单的bean类,用于保存创建采购单的信息.
 */
public class Purchase {
    private  Integer id;
    private  String user_id;//创建者
    private  String name;  //采购单名称
    private Date create_tima;
    private String creator;//创建者名字
    private String purchaser;//采购员名字
    private Integer audit_order;//审核顺序
    private Integer audit_state;//审核状态,0为未审核,1为审核通过,2为审核不通过
    private Integer purchase_state;//采购状态.
    private Date end_time;
    private String remark;//备注

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", create_tima=" + create_tima +
                ", creator='" + creator + '\'' +
                ", purchaser='" + purchaser + '\'' +
                ", audit_order=" + audit_order +
                ", audit_state=" + audit_state +
                ", purchase_state=" + purchase_state +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_tima() {
        return create_tima;
    }

    public void setCreate_tima(Date create_tima) {
        this.create_tima = create_tima;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Integer getAudit_order() {
        return audit_order;
    }

    public void setAudit_order(Integer audit_order) {
        this.audit_order = audit_order;
    }

    public Integer getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(Integer audit_state) {
        this.audit_state = audit_state;
    }

    public Integer getPurchase_state() {
        return purchase_state;
    }

    public void setPurchase_state(Integer purchase_state) {
        this.purchase_state = purchase_state;
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
