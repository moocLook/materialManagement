package com.work.controller;

import com.work.bean.*;
import com.work.service.CompanyService;
import com.work.service.MaterialService;
import com.work.service.PurchaseService;
import com.work.service.UserService;
import com.work.service.imp.PurchaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    MaterialService materialService;
    @Autowired
    CompanyService companyService;



    /**
     * 跳转到新建采购单页面的方法
     * 需要有所有采购者的信息,所有材料信息
     * @param model 用于往页面中传输数据
     * @return 指定跳转的页面
     */
    @RequestMapping("toAddPurchase")
    public String toAddPurchase(Model model)
    {
        //获得所有采购者信息
        List<User> userList=purchaseService.findAllPurcher();
        model.addAttribute("userList",userList);
       /*// http://localhost:8080/purchase/toAddPurchase
       通过
        for (User u:userList)
        {
            System.out.println(u.toString());
        }*/

        //获得所有材料信息
        List<Material> materialList=materialService.findAllMeterial();
        model.addAttribute("materialList",materialList);

        return "list";
    }


    /**
     * 用在新建采购单时,如果选择了采购的物资,那么就需要显示相应的有哪些供货商.
     */
    @RequestMapping("findCompanyByType")
    @ResponseBody
    public List<Company> findCompanyByType(Integer type)
    {
       return companyService.findCompnayByType(type);
    }



    /**
     * 新建采购单,该功能需要更新两张表,采购单表和采购单信息表
     * 需要获取的信息有:采购单名称,创建者名字,采购员,备注.以及一个数组,该数组里面有材料类型
     * 编号,供货商,计划采购数量.
     * 没有测试过,不知道对错
     * @return
     */
    @RequestMapping("addPurchase")
    public String addPurchase(List<PurchaseInfo> purchaseInfoList, Purchase purchase)
    {

        purchaseService.AddPurchase(purchaseInfoList,purchase);
        return "";
    }

    /**
     * 去到查询采购单页面,需要所有采购单的信息,所有采购单创建者的信息,所有采购员的信息.
     * @return
     */
    public String toFindPurchase(Model model)
    {
        //获得所有采购单信息,审核通过的采购单的信息
        List<Purchase> purchaseList=purchaseService.findallPurchase();
        model.addAttribute("purchaseList",purchaseList);
        //获得所有采购单创建者信息
        List<User> userList=purchaseService.findAllCreator();
        model.addAttribute("creatorList",userList);
        //获得所有采购员的信息
        List<User> purcherList= purchaseService.findAllPurcher();
        model.addAttribute("purcherList",purcherList);
        return "";
    }



    /**
     * 查询采购单,查询的都是审核通过的.
     * @return
     */
    public String findPurchase(Model model,PurchaseSearch purchaseSearch)
    {
        List<Purchase> purchaseList=
                purchaseService.findPurchaseBy(purchaseSearch);
        model.addAttribute("purchaseList",purchaseList);
        return "";
    }


    /**
     * 去到管理采购单页面,需要显示所有与当前用户相关的采购单的信息
     * @return
     */
    public String toManagePurchase(Model model,HttpServletRequest request)
    {
        //todo
        //获得当前用户的信息.
        User user= (User) request.getSession().getAttribute("loginUser");
        //获得和当前用户相关的订单信息
        PurchaseSearch purchaseSearch=new PurchaseSearch();
        purchaseSearch.setUserId(user.getId());
        List<Purchase> purchaseList=
                purchaseService.findPurchaseBy(purchaseSearch);
        model.addAttribute("purchaseList",purchaseList);
        return "";
    }

    /**
     * 管理采购单,即删除自己创建的采购单.
     * @param purchase
     * @return
     */
    public String ManagePurchase(Purchase purchase)
    {

        purchaseService.deletePurchase(purchase);
        return "";
    }



    /**
     * 去到审批采购单页面,需要显示所有待审批的采购单的信息.request用于获得当前用户的信息.
     * @return
     */
    public String toAuditPurchase(Model model, HttpServletRequest request)
    {
        User user= (User) request.getSession().getAttribute("loginUser");
        List<Purchase> purchaseList = purchaseService.findAuditPurchase(user);
        model.addAttribute("purchaseList",purchaseList);


        return "";
    }

    /**
     * 审批采购单
     * @param purchase 待审核的采购单信息
     * @return
     */
    public String AuditPurchase(HttpServletRequest request,Purchase purchase,
                                AuditResult auditResult)
    {

        User user= (User) request.getSession().getAttribute("loginUser");
        purchaseService.AuditPurchase(purchase,auditResult,user);
        return "";//跳转到审核页面
    }
}
