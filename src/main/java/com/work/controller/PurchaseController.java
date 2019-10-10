package com.work.controller;

import com.work.bean.User;
import com.work.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;


    //去到新建采购单页面,需要有所有采购员的数据
    @RequestMapping("toAddPurchase")
    public String toAddPurchase(Model model)
    {
        List<User> userList=purchaseService.findAllPurcher();
        model.addAttribute("userList",userList);
       /*// http://localhost:8080/purchase/toAddPurchase
       通过
        for (User u:userList)
        {
            System.out.println(u.toString());
        }*/

        return "list";
    }

    //新建采购单,该功能需要更新两张表,采购单表和采购单信息表
    public String addPurchase()
    {
        return "";
    }

    //去到查询采购单页面,需要所有采购单的信息
    public String toFindPurchase()
    {
        return "";
    }

    //查询采购单
    public String findPurchase()
    {
        return "";
    }
    //去到管理采购单页面
    public String toManagePurchase()
    {
        return "";
    }
    //去到审批采购单页面
    public String toAuditPurchase()
    {
        return "";
    }

}
