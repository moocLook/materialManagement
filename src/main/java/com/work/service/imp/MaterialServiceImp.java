package com.work.service.imp;

import com.work.bean.Material;
import com.work.bean.ShowedMaterialInfo;
import com.work.dao.MaterialDao;
import com.work.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 物资管理模块业务层接口
 */
@Service("materialService")
public class MaterialServiceImp implements MaterialService {
    @Autowired
    MaterialDao materialDao;


    /**
     * 查询所有物资分类信息
     * @return
     */
    @Override
    public List<Material> findAllMeterial() {
        return materialDao.findAllCompany();
    }


    /**
     * 新建物资信息
     * @param material
     * @param companyId
     */
    @Override
    public void addMaterial(Material material, Integer companyId) {
        materialDao.addMaterial(material);
        materialDao.addCompanyInfo(companyId);
    }

    /**
     * 根据条件查询物资的息
     * @param companyId
     * @param typeId
     * @return
     */
    @Override
    public List<ShowedMaterialInfo> findMeterialInfo(
            Integer companyId, Integer typeId) {
        return materialDao.findMeterialInfo(companyId,typeId);
    }
}
