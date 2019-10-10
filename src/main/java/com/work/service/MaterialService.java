package com.work.service;

import com.work.bean.Material;
import com.work.bean.ShowedMaterialInfo;

import java.util.List;

public interface MaterialService {
    //查询所有物资信息
    public List<Material> findAllMeterial();
    //新建物资信息
    public void addMaterial(Material material,Integer companyId);

    //根据条件查询物资信息.需要返回材料名称,供货商名称,库存数量,单位.
    public List<ShowedMaterialInfo> findMeterialInfo(Integer companyId, Integer typeId);
}
