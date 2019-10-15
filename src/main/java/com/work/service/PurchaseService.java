package com.work.service;

import com.work.bean.*;
import com.work.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PurchaseService {

    /**
     * 查询到所有的采购员的信息
     * @return
     */
    public List<User> findAllPurcher();

    /**
     * 查询所有采购单的信息
     * @return
     */
    public List<Purchase> findallPurchase();

    /**
     * 新建订购单
     * @param purchaseInfoList
     * @param purchase
     */
    public void AddPurchase(List<PurchaseInfo> purchaseInfoList, Purchase purchase);

    /**
     * 获取所有采购单创建者的信息.
     * @return
     */
    public List<User> findAllCreator();

    /**
     * 根据条件查询采购单
     * @return
     */
    public List<Purchase> findPurchaseBy(PurchaseSearch purchaseSearch);

    /**
     * 删除订单
     * @param purchase
     */
    public void deletePurchase(Purchase purchase);

    /**
     * 查询待当前人员审核的采购单的信息.
     * @param user
     * @return
     */
    public List<Purchase> findAuditPurchase(User user);

    /**
     * 审批操作.
     * @param purchase
     */
    public void AuditPurchase(Purchase purchase, AuditResult auditResult,
                              User user);
}
