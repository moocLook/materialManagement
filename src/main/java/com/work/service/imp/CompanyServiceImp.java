package com.work.service.imp;

import com.work.bean.Company;
import com.work.dao.CompanyDao;
import com.work.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 供货商业务接口
 */
@Service("companyService")
public class CompanyServiceImp implements CompanyService {

    @Autowired
    CompanyDao companyDao;


    /**查询所有公司的信息
     * @return
     */
    @Override
    public List<Company> findAllCompany() {
        return companyDao.findAllCompany();
    }

    @Override
    public List<Company> findCompnayByType(Integer type) {
        return companyDao.findCompanyByType(type);
    }


}
