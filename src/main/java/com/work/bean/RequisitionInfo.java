package com.work.bean;

/**
 * 用于存储领料单的具体内容
 */
public class RequisitionInfo {
    private Integer id;//主键
    private Integer requisition;//对应的领料单的id
    private Integer type;//材料编号
    private Integer company;
    private Integer plan_number;
    private Integer number;
    private String remark;

    @Override
    public String toString() {
        return "RequisitionInfo{" +
                "id=" + id +
                ", requisition=" + requisition +
                ", type=" + type +
                ", company=" + company +
                ", plan_number=" + plan_number +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequisition() {
        return requisition;
    }

    public void setRequisition(Integer requisition) {
        this.requisition = requisition;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getPlan_number() {
        return plan_number;
    }

    public void setPlan_number(Integer plan_number) {
        this.plan_number = plan_number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
