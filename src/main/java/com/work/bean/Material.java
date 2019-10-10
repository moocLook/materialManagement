package com.work.bean;

public class Material {

    private Integer type;//物资种类编号
    private String name;//名字
    private  String unit;//计量单位

    @Override
    public String toString() {
        return "Material{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
