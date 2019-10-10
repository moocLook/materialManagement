package com.work.service.imp;

import com.work.bean.Material;
import com.work.bean.ShowedMaterialInfo;
import com.work.dao.MaterialDao;
import com.work.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("materialService")
public class MaterialServiceImp implements MaterialService {
    @Autowired
    MaterialDao materialDao;
    //查询所有物资分类信息
    @Override
    public List<Material> findAllMeterial() {
        return materialDao.findAllCompany();
    }
    //新建物资信息
    @Override
    public void addMaterial(Material material, Integer companyId) {
        materialDao.addMaterial(material);
        materialDao.addCompanyInfo(companyId);
    }

    @Override
    public List<ShowedMaterialInfo> findMeterialInfo(
            Integer companyId, Integer typeId) {
        return materialDao.findMeterialInfo(companyId,typeId);
    }
}
