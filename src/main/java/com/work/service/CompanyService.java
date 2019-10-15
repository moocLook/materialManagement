package com.work.service;

import com.work.bean.Company;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

    //查找所有公司信息
    public List<Company> findAllCompany();

    /**
     * 根据物资类型查找供货商
     * @param type
     * @return
     */
    public List<Company> findCompnayByType(Integer type);
}
