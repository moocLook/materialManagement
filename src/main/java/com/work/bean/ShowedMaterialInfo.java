package com.work.bean;

/**
 * 用于保存物资查询需要显示的信息.
 * 分别是材料名称,公司名称,库存数量,计量单位.
 */
public class ShowedMaterialInfo {
    private String name;
    private String company;
    private String number;
    private String unit;

    @Override
    public String toString() {
        return "ShowedMaterialInfo{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", number='" + number + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
