package com.work.service.imp;

import com.work.bean.AuditInfo;
import com.work.bean.AuditManageBean;
import com.work.bean.Purchase;
import com.work.bean.User;
import com.work.dao.AuditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("auditServic")
public class AuditServiceImp {

    @Autowired
    AuditDao auditDao;
    /**
     * 查询所有为安排审核的订购单的信息
     * @return
     */
    public List<Purchase> findAllPurchaseWithoutManage()
    {
       return  auditDao.findAllPurchaseWithoutManage();
    }

    public void manageAudit(AuditManageBean auditManageBean)
    {
        //更新audit表
        auditDao.updateAudit(auditManageBean.getPurchaseId());
        //更新auditinfo表
        Integer auditId=
                auditDao.getAuditIdByPurchase(auditManageBean.getPurchaseId());
        auditDao.updateAuditInfo(auditId, 1, auditManageBean.getId1());
        auditDao.updateAuditInfo(auditId, 2, auditManageBean.getId2());
        auditDao.updateAuditInfo(auditId, 3, auditManageBean.getId3());
        auditDao.updateAuditInfo(auditId, 4, auditManageBean.getId4());


    }


}
