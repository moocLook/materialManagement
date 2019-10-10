package com.work.bean;

import org.apache.ibatis.type.IntegerTypeHandler;

/**
 * 这个类主要是保存哪些公司生产哪些材料
 */
public class CompanyInfo {
    private Integer id;
    private Integer company_id;//公司编号
    private Integer type;//供货材料编号

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", type=" + type +
                '}';
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
