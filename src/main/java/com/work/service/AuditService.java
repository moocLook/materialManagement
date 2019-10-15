package com.work.service;

import com.work.bean.AuditInfo;
import com.work.bean.AuditManageBean;
import com.work.bean.Purchase;
import com.work.bean.User;

import java.util.List;

public interface AuditService {

    public List<Purchase> findAllPurchaseWithoutManage();

    public void manageAudit(AuditManageBean auditManageBean);

}
