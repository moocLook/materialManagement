package com.work.service;

import com.work.bean.Company;

import java.util.List;

public interface CompanyService {

    //查找所有公司信息
    public List<Company> findAllCompany();
}
