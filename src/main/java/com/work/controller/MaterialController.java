package com.work.controller;

import com.work.bean.Company;
import com.work.bean.CompanyInfo;
import com.work.bean.Material;
import com.work.bean.ShowedMaterialInfo;
import com.work.service.CompanyService;
import com.work.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("material")
public class MaterialController {

    @Autowired
    CompanyService companyService;
    @Autowired
    MaterialService materialService;



    /**
     * 跳转到新建物资信息界面
     * @param model
     * @return
     */
    @RequestMapping("toAddMaterial")
    public String toAddMaterial(Model model)
    {
        //查询所有公司的信息
        List<Company> companyList=companyService.findAllCompany();

        /*//测试,测试成功,能够顺利输出
        for (Company c:companyList)
        {
            System.out.println(c.toString());
        }*/

        model.addAttribute("listCompany",companyList);
        return "";
    }


    /**
     * 跳转到查询物资信息界面,需要有所有公司信息以及材料分类信息.
     * @param model
     * @return
     */
    @RequestMapping("toFindMaterial")
    public String toFindMaterial(Model model)
    {
        //公司信息
        List<Company> companyList=companyService.findAllCompany();
        model.addAttribute("listCompany",companyList);
        //材料分类信息
        List<Material> materialList= materialService.findAllMeterial();
       /* //测试成功
        for (Material c:materialList)
        {
            System.out.println(c.toString());
        }*/

        model.addAttribute("materialList",materialList);
        return "";
    }

    //测试信息 http://localhost:8080/material/addMaterial?name=%E9%BB%84%E9%87%91&unit=%E5%85%8B&companyId=1

    /**
     * 新建物资信息
     * @param material  要添加的物资信息
     * @param companyId  供货商的id
     * @return
     */
    @RequestMapping("addMaterial")
    @ResponseBody
    public int addMaterial(Material material,Integer companyId)
    {
        materialService.addMaterial(material,companyId);
        return 1;
    }



    /**
     * 查询物资信息
     * @param companyInfo
     * @return
     */
    @RequestMapping("findMaterial")
    public String findMaterial(CompanyInfo companyInfo)
    {

        List<ShowedMaterialInfo> showedMaterialInfoList=
                materialService.findMeterialInfo(companyInfo.getCompany_id(),
            companyInfo.getType());
        //测试 http://localhost:8080/material/findMaterial?type=1&company_id=1
        //测试通过
        for(ShowedMaterialInfo s:showedMaterialInfoList)
        {
            System.out.println(s.toString());
        }

        return "list";
    }

}
