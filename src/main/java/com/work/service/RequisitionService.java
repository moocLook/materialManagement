package com.work.service;

import com.work.bean.*;

import java.util.List;

public interface RequisitionService {


    public void addRequisition(Requisition requisition,
                               List<RequisitionInfo> requisitionInfoList);

    public List<Requisition> findAllRequisition();


    public List<Requisition> findRequisition( RequisitionSearch requisitionSearch);

    public List<Requisition> findMyRequisition( MyRequisitionSearch myRequisitionSearch);

    public void deletRequisition(Requisition requisition);
}
