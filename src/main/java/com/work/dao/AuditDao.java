package com.work.dao;

import com.work.bean.AuditInfo;
import com.work.bean.Purchase;
import com.work.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 有关审核的持久层
 */
@Repository
public interface AuditDao {

    /**
     * 添加审核安排的具体信息.
     * @param auditInfo
     */
    public void addAudit(AuditInfo auditInfo);

    /**
     * 保存当前用户的审核结果
     * @param purchaseId 审核的采购单号
     * @param userId    当前审核员的id
     * @param remark
     * @param result
     */
    @Update("UPDATE tb_audit_info  ai\n" +
            "SET (\n" +
            "result = #{result} , remark=#{remark} ) WHERE\n" +
            "ai.audit_id in (select id from tb_audit a where a" +
            ".purchase_id=#{purchaseId} ) and ai.user_id=#{useId}")
    public void updateAuditInfo(@Param("purchaseId") Integer purchaseId,
                                @Param("userId") String userId,
                                @Param("result") Integer result,@Param("remark") String remark);

    /**
     * 更新审核结果
     * @param purchaseId
     * @param result
     */
    @Update("UPDATE tb_audit a set a.result=#{result} where a" +
            ".purchase_id=#{purchaseId}")
    public void updateAuditResult(@Param("purchaseId") Integer purchaseId,
                                  @Param("result") Integer result);

    /**
     * 更新审核表的状态
     * @param purchaseId
     */
    @Update("UPDATE tb_audit a set a.`status`=a.`status`+1 WHERE a.purchase_id=#{purchaseId} and a.result<>-1")
    public void updateStatus(Integer purchaseId);

    /**
     * 检查是否已经审核结束,如果是就将result设为true
     * @param purchaseId
     */
    @Update("UPDATE tb_audit a set a.result=1 WHERE a.purchase_id=#{purchaseId} and a.`status`>4 and a.result<>-1")
    public void checkResult(Integer purchaseId);


    /**
     * 查询所有没有安排审核的采购单
     * @return
     */
    @Select("SELECT p.* from tb_purchase p WHERE p.id not in (select a.purchase_id from tb_audit a)")
    public List<Purchase> findAllPurchaseWithoutManage();

    /**
     * 新建一条记录用于保存某个订购单的审核信息
     * @param purchaseId
     */
    @Update("INSERT into tb_audit(purchase_id,result,`status`) VALUES(#{purchaseId},0,1)")
    public void updateAudit(Integer purchaseId);

    /**
     * 更新AuditInfo表
     */
    @Update("INSERT INTO tb_audit_info(audit_id,`order`,user_id) VALUES (#{auditId},#{order},#{userId})")
    public void updateAuditInfo(@Param("auditId") Integer auditId,
                                @Param("order") Integer order,
                                @Param("userId") String userId);

    /**
     * 获取插入的audit的id
     * @param purchaseId
     */
    @Select("select id from tb_audit WHERE purchase_id=#{purchaseId}")
    public int getAuditIdByPurchase(Integer purchaseId);
}
