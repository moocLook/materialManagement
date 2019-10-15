package com.work.bean;

import java.security.KeyStore;

/**
 * 保存审核顺序的
 */
public class AuditManageBean {

    private String id1;
    private String id2;
    private String id3;
    private String id4;
    private Integer purchaseId;

    @Override
    public String toString() {
        return "AuditManageBean{" +
                "id1=" + id1 +
                ", id2=" + id2 +
                ", id3=" + id3 +
                ", id4=" + id4 +
                ", purchaseId=" + purchaseId +
                '}';
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getId4() {
        return id4;
    }

    public void setId4(String id4) {
        this.id4 = id4;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }
}
