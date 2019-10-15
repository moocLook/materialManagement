package com.work.dao;

import com.work.bean.Company;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 公司查询持久层接口
 */
@Repository
public interface CompanyDao {


    /**
     * 查询所有的公司
     * @return
     */
    @Select("select * from tb_company")
    public List<Company> findAllCompany();

    /**
     * 通过物资的类型查询有哪些供货商
     * @param Type
     * @return
     */
    @Select("select c.* FROM tb_company c,tb_company_info ci where c.id=ci.company_id and ci.type=#{type}")
    public List<Company> findCompanyByType(Integer Type);

}
