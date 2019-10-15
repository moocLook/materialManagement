package com.work.bean;

/**
 * 采购物资信息类,用于保存需要采购的具体的物资的信息
 */
public class PurchaseInfo {
    private Integer id;
    private Integer purchase;//对应的采购单
    private Integer type;//类型编号
    private Integer company;//供货商id.
    private Integer plan_number;//计划采购数量
    private Integer number;//实际采购数量

    @Override
    public String toString() {
        return "PurchaseInfo{" +
                "id=" + id +
                ", purchase=" + purchase +
                ", type=" + type +
                ", company=" + company +
                ", plan_number=" + plan_number +
                ", number=" + number +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
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
}
