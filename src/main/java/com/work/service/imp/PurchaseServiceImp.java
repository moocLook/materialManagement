package com.work.service.imp;

import com.work.bean.User;
import com.work.dao.PurchaseDao;
import com.work.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;
    @Override
    public List<User> findAllPurcher() {
        return purchaseDao.findAllPurcher();
    }
}
