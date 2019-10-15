package com.work.service.imp;

import com.work.bean.MyRequisitionSearch;
import com.work.bean.Requisition;
import com.work.bean.RequisitionInfo;
import com.work.bean.RequisitionSearch;
import com.work.dao.RequisitionDao;
import com.work.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("requisitionService")
public class RequisitionServiceImp implements RequisitionService {
    @Autowired
    RequisitionDao requisitionDao;

    /**
     * 添加领料单
     * @param requisition
     * @param requisitionInfoList
     */
    @Override
    public void addRequisition(Requisition requisition, List<RequisitionInfo> requisitionInfoList) {
        //添加requisition表
            //补充数据
        requisition.setCreate_time(new Date());
        requisitionDao.addRequisition(requisition);
        //添加到requisitionInfo表
        for (RequisitionInfo ri:requisitionInfoList)
        {
            requisitionDao.addRequisitionInfo(ri);
        }

    }




    /**
     * 查询所有领料单
     * @return
     */
    public List<Requisition> findAllRequisition()
    {
       return  requisitionDao.findAllRequisition();
    }

    /**
     * 根据条件查询领料单
     * @param requisitionSearch  查询条件
     * @return
     */
    @Override
    public List<Requisition> findRequisition(RequisitionSearch requisitionSearch) {
       return  requisitionDao.findRequisition(requisitionSearch);

    }

    /**
     * 根据条件查询我的领料单
     * @param myRequisitionSearch
     * @return
     */
    @Override
    public List<Requisition> findMyRequisition(MyRequisitionSearch myRequisitionSearch) {
        return requisitionDao.findMyRequisition(myRequisitionSearch);
    }

    /**
     * 删除某个领料单
     * @param requisition
     */
    public void deletRequisition(Requisition requisition)
    {
        requisitionDao.deletRequisition(requisition);
    }


}
