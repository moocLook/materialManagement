package com.work.service.imp;

import com.work.bean.*;
import com.work.dao.AuditDao;
import com.work.dao.PurchaseDao;
import com.work.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 采购模块业务层接口
 */
@Service("purchaseService")
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;
    @Autowired
    AuditDao auditDao;
    /**
     * 找到所有的采购员
     * @return
     */
    @Override
    public List<User> findAllPurcher() {
        return purchaseDao.findAllPurcher();
    }

    /**
     * 查询所有采购单的信息
     * @return
     */
    @Override
    public List<Purchase> findallPurchase()
    {
        return purchaseDao.findallPurchase();
    }

    /**
     * 新建订购单
     * @param purchaseInfoList
     * @param purchase
     */
    @Override
    public void AddPurchase(List<PurchaseInfo> purchaseInfoList, Purchase purchase) {

        //完善数据
        Date now=new Date();
        purchase.setCreate_tima(now);
        purchase.setAudit_state(0);
        //在Purchase表中插入
        purchaseDao.addPurchase(purchase);
        //获得插入后订单的id;
        int purchaseId=purchaseDao.getPurchaseId(purchase);
        //遍历集合,在purchase_info中插入每一个记录.
        for(PurchaseInfo p:purchaseInfoList)
        {
            //完善数据
            p.setPurchase(purchaseId);
            //插入数据
            purchaseDao.addPurchaseInfo(p);
        }
    }

    /**
     * 获取所有采购单创建者的信息.
     * @return
     */
    public List<User> findAllCreator()
    {
        return purchaseDao.findAllCreator();
    }


    /**
     * 根据条件查询采购单
     * @return
     */
    public List<Purchase> findPurchaseBy(PurchaseSearch purchaseSearch)
    {
        return  null;
    }

    /**
     * 删除订单
     * @param purchase
     */
    @Override
    public void deletePurchase(Purchase purchase) {
        purchaseDao.deletePurchase(purchase);
    }

    /**
     * 查询待当前人员审核的采购单的信息.
     * @param user 当前审核人员的信息.
     * @return
     */
    @Override
    public List<Purchase> findAuditPurchase(User user)
    {
        if (user==null)
        {
            return null;
        }
        return purchaseDao.findAuditPurchase(user);
    }

    /**
     * 审批采购单
     * @param purchase
     * @param auditResult
     */
    @Override
    public void AuditPurchase(Purchase purchase, AuditResult auditResult,
                              User user) {
        //不管审核有没有通过都需要更新auditinfo和audit表
            //更新auditINfo表
            auditDao.updateAuditInfo(purchase.getId(),user.getId(),
                    auditResult.getResult(),auditResult.getRemark());
            //更新audit表
                //如果为不通过,更新result,审核结束
                if(auditResult.getResult()==-1)
                {
                    auditDao.updateAuditResult(purchase.getId(),auditResult.getResult());
                }else if(auditResult.getResult()==1){//如果通过,更新status,更新result
                    auditDao.updateStatus(purchase.getId());
                    auditDao.checkResult(purchase.getId());
                }


    }

}
