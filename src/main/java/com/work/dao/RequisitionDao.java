package com.work.dao;

import com.work.bean.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.ui.Model;

import java.util.List;

/**
 * 有关领料模块的持久层
 */
public interface RequisitionDao {
    /**
     * 查询所有领料单的信息
     * @return
     */
    @Select("select * from tb_requisition")
    public List<Requisition> findAllRequisition();

    /**
     * 新建领料单
     * @param requisition
     */
    @Update("insert into tb_requisition (user_id,`name`,create_time,\n" +
            "creator,requester,requisition_state,executor,end_time,remark) VALUES (\n" +
            "#{user_id},\n" +
            "#{name},\n" +
            "#{create_time},\n" +
            "#{creator},\n" +
            "#{requester},\n" +
            "#{requisition_state},\n" +
            "#{executor},\n" +
            "#{end_time},\n" +
            "#{remark}\n" +
            ")")
    public void addRequisition(Requisition requisition);

    /**
     * 添加领料单的具体事项
     * @param requisitionInfo
     */
    @Update("INSERT INTO tb_requisition_info ( requisition, type, company, plan_number, number, remark )\n" +
            "VALUES\n" +
            "\t( #{requisition},\n" +
            "#{type},#{company},#{plan_number},#{number},#{remark}\n" +
            "\t)")
    public void addRequisitionInfo(RequisitionInfo requisitionInfo);

    /**
     * 根据条件查询领料单的信息
     * @param requisitionSearch 查询条件
     * @return
     */
    @Select("select * from tb_requisition WHERE (name=#{name} or #{name}='' or ISNULL(#{name})) AND (user_id=#{creatorId} or #{creatorId}='' or ISNULL(#{creatorId}) )")
    public List<Requisition> findRequisition( RequisitionSearch requisitionSearch);

    /**
     * 根据条件查询我的领料单
     * @param myRequisitionSearch
     * @return
     */
    @Select("select * from tb_requisition WHERE (name=#{name} or #{name}='' or ISNULL(#{name})) \n" +
            "AND (user_id=#{creatorId} or #{creatorId}='' or ISNULL(#{creatorId}) )\n" +
            "AND ((create_time BETWEEN #{startTime} and #{endTime}) or #{startTime}='' or ISNULL(#{startTime}) )")
    public List<Requisition> findMyRequisition( MyRequisitionSearch myRequisitionSearch);

    /**
     * 删除领料单
     * @param requisition 需要删除的领料单的信息.
     */
    @Update("DELETE FROM tb_requisition WHERE id=#{id}")
    public void deletRequisition(Requisition requisition);


}
