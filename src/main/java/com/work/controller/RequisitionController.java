package com.work.controller;

import com.work.bean.*;
import com.work.service.CompanyService;
import com.work.service.MaterialService;
import com.work.service.RequisitionService;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 领料or库存物资管理模块
 */
@RequestMapping("requisition")
public class RequisitionController {

    @Autowired
    UserService userService;
    @Autowired
    MaterialService materialService;
    @Autowired
    RequisitionService requisitionService;
    /**
     * 去到新建领料单页面
     * @param model
     * @return
     */
    @RequestMapping("toAddRequisition")
    public String toAddRequisition(Model model)
    {
        //需要获取所有领料人信息,所有发料人信息,所有材料信息
        List<User> reqUsers=userService.findAllByPosition("requisition",
                "reqester");
        List<User> distriUsers=userService.findAllByPosition("requisition",
                "divider");
        List<Material> materialList=materialService.findAllMeterial();
        //todo
        return "";
    }


    /**
     * 新建领料单时调用方方法.
     * @param model
     * @param requisition  领料单信息
     * @param requisitionInfoList 领料单中的物资信息.
     * @return
     */
    public String addRequisition(Model model, Requisition requisition,
                                 List<RequisitionInfo> requisitionInfoList)
    {
        requisitionService.addRequisition(requisition,requisitionInfoList);
        return "";//刷新新建领料单页面
    }

    /**
     *去到查询领料单的页面,显示所有领料单的信息.
     * @param model
     * @return
     */
    public String toFindRequisition(Model model)
    {

        List<Requisition> requisitionList=
                requisitionService.findAllRequisition();
        model.addAttribute("requisitionList",requisitionList);
        return "";
    }

    /**
     * 根据条件查询领料单
     * @param model
     * @param requisitionSearch 查询条件封装成的一个对象.
     * @return
     */
    public String findRequisition(Model model, RequisitionSearch requisitionSearch)
    {
        List<Requisition> requisitionList=
                requisitionService.findRequisition(requisitionSearch);
        model.addAttribute("requisitionList",requisitionList);
        return "";
    }

    /**
     * 去到管理我的领料单界面,默认显示所有与当前用户相关的领料单
     * 其中用户信息可以在session中获取到
     * @param model
     * @return
     */
    public String toManageMyRequisition(Model model, HttpServletRequest request)
    {
        RequisitionSearch requisitionSearch=new RequisitionSearch();
        User user  = (User) request.getSession().getAttribute(
                "loginUser");
        requisitionSearch.setCreatorId(user.getId());

        List<Requisition> requisitionList=
                requisitionService.findRequisition(requisitionSearch);
        model.addAttribute("requisitionList",requisitionList);

        return "";
    }

    /**
     * 查询当前用户相关的领料单
     * @param myRequisitionSearch 查询条件
     * @return
     */
    public String findMyRequisition(HttpServletRequest request,MyRequisitionSearch myRequisitionSearch)
    {
        User user  = (User) request.getSession().getAttribute(
                "loginUser");
        myRequisitionSearch.setCreatorId(user.getId());
        //查询
        List<Requisition> requisitionList=
                requisitionService.findMyRequisition(myRequisitionSearch);

        return "";
    }

    /**
     * 管理当前用户的领料单,就是删除
     * @param requisition  需要删除的领料单信息
     * @return
     */
    public String manageMyRequisition(Requisition requisition)
    {
        requisitionService.deletRequisition(requisition);
        return "";
    }



}
