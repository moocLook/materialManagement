package com.work.service;

import com.work.bean.User;
import com.work.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PurchaseService {

    //查询到所有的采购员的信息
    public List<User> findAllPurcher();

    //新建订购单
    public void AddPurchase();
}
