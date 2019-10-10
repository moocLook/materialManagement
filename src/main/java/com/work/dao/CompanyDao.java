package com.work.dao;

import com.work.bean.Company;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface CompanyDao {

    //查询所有的公司
    @Select("select * from tb_company")
    public List<Company> findAllCompany();

}
