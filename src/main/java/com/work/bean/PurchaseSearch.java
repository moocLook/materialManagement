package com.work.bean;

/**
 * 该类用于保存查询订单时的查询条件.
 */
public class PurchaseSearch {
    private String creator;//创建者
    private String purcher;//采购员
    private String name;//采购单的名称
    private String userId;//创建者的id

    @Override
    public String toString() {
        return "PurchaseSearch{" +
                "creator='" + creator + '\'' +
                ", purcher='" + purcher + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPurcher() {
        return purcher;
    }

    public void setPurcher(String purcher) {
        this.purcher = purcher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
