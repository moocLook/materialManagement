package com.work.controller;

import com.work.bean.AuditManageBean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 审核管理模块
 */
@RequestMapping("AuditController")
public class AuditController {

    /**
     * 查询所有没有进行审核安排的订购单
     * @param model
     * @return
     */
    public String findAllPurchaseButNoManage(Model model){
        //todo 注意需要查询的是采购单而不是审核的信息.
        return "";
    }

    /**
     * 执行审核安排
     * @param auditManageBean 审核安排的具体信息
     * @return
     */
    public String manageAudit(AuditManageBean auditManageBean)
    {
        //todo


        return "";
    }
}
