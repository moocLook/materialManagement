package com.work.dao;

import com.work.bean.Material;
import com.work.bean.ShowedMaterialInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 材料管理持久层接口
 */
@Repository
public interface MaterialDao {



    /**查询所有物资的分类信息
     *
     * @return
     */
    @Select("select * from tb_material")
    public List<Material> findAllCompany();



    /**
     * 添加一个物资
     * @param material
     */
    @Update("insert into tb_material(name,unit) values(#{name},#{unit})")
    public void addMaterial(Material material);




    /**
     * 向company_info中添加数据
     * @param companyId
     */
    @Update("insert into tb_company_info(type,company_id) values(@@IDENTITY,#{companyId})")
    public void addCompanyInfo(Integer companyId);




    /**
     * 根据条件查询材料库存信息
     * @param companyId 查询条件
     * @param typeId 查询条件
     * @return
     */
    @Select("select m.`name` name,c.`name` company,mi.number number,m.unit " +
            "unit from tb_material m,tb_company c,tb_material_info mi where " +
            "mi.type=m.type and c.id=mi.company and (mi.company=#{companyId} " +
            "or #{companyId}='' or ISNULL(#{companyId})" +
            ") and (mi.type=#{typeId} or #{typeId}='' or ISNULL(#{typeId}));")
    public List<ShowedMaterialInfo> findMeterialInfo(@Param("companyId") Integer companyId, @Param("typeId") Integer typeId);
}
