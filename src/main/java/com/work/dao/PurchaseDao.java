package com.work.dao;

import com.work.bean.Purchase;
import com.work.bean.PurchaseInfo;
import com.work.bean.PurchaseSearch;
import com.work.bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采购单持久层接口
 */
@Repository
public interface PurchaseDao {




    /**
     * 查询所有采购员
     * @return
     */
    @Select("SELECT * FROM tb_user where position='采购员'")
    public List<User> findAllPurcher();

    /**
     * 添加订单
     * @param purchase
     */
    @Update("INSERT INTO tb_purchase (\n" +
            "tb_purchase.user_id,\n" +
            "tb_purchase.`name`,\n" +
            "tb_purchase.create_time,\n" +
            "tb_purchase.creator,\n" +
            "tb_purchase.purchaser,\n" +
            "tb_purchase.audit_order,\n" +
            "tb_purchase.audit_state,\n" +
            "tb_purchase.purchase_state,\n" +
            "tb_purchase.end_time,\n" +
            "tb_purchase.remark \n" +
            ")\n" +
            "VALUES\n" +
            "\t( #{user_id},\n" +
            "#{name},\n" +
            "#{create_time},\n" +
            "#{creator},\n" +
            "#{purchaser},\n" +
            "#{audit_order},\n" +
            "#{audit_state},\n" +
            "#{purchase_state},\n" +
            "#{end_time},\n" +
            "#{remark}\n" +
            "\t)")
    public int addPurchase(Purchase purchase);

    /**
     * 获取订单的id
     * @param purchase
     * @return
     */
    @Select("select id from tb_purchase WHERE tb_purchase.`name`=#{name} and tb_purchase.create_time=#{create_time};")
    public int getPurchaseId(Purchase purchase);

    /**
     * 添加订单的具体信息
     * @param purchaseInfo
     */
    @Update("INSERT INTO tb_purchase_info ( tb_purchase_info.purchase, tb_purchase_info.type, tb_purchase_info.company, plan_number, number )\n" +
            "VALUES\n" +
            "\t(#{purchase},#{type},#{company},#{plan_number},#{number} )")
    public int addPurchaseInfo(PurchaseInfo purchaseInfo);


    /**
     * 查询所有审核通过的采购单的信息
     * @return
     */
    @Select("SELECT p.* FROM tb_audit a join tb_purchase p on p.id=a" +
            ".purchase_id WHERE a.result=1")
    public List<Purchase> findallPurchase();

    /**
     * 查询所有采购单创建者的信息
     * @return
     */
    @Select("select u.* FROM tb_user u,tb_purchase p WHERE p.user_id=u.id")
    public List<User> findAllCreator();

    /**
     * 查询符合条件的订购单的信息
     */
    @Select("SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\ttb_purchase p \n" +
            "WHERE\n" +
            "\taudit_state = 1 \n" +
            "\tAND (\n" +
            "\tp.`name` = #{name} or #{name}='' or ISNULL(#{name}))\n" +
            "\t\n" +
            "\tAND (\n" +
            "\tpurchaser = #{purchaser} or #{purchaser}='' or ISNULL(#{purchaser})\t)\n" +
            "\n" +
            "AND (\n" +
            "creator = #{creator} or #{creator}='' or ISNULL(#{creator}))" +
            "and (user_id=#{userId}) or #{userId}='' or ISNULL(#{userId})")
    public List<Purchase> findPurchaseBy(PurchaseSearch purchaseSearch);

    /**
     * 查询待当前审核人员审核的订单信息
     * @param user
     * @return
     */
    @Select("SELECT p.* FROM tb_audit a join tb_purchase p on p.id=a.purchase_id join tb_audit_info ai on a.id=ai.audit_id where a.`status`=ai.`order` and ai.user_id=#{id}")
    public List<Purchase> findAuditPurchase(User user);


    /**
     * 删除采购单,采购单的Info会级联删除
     * @param purchase
     */
    @Select("DELETE from tb_purchase WHERE id=#{id}")
    public void deletePurchase(Purchase purchase);

    /**
     * 修改采购单的审核状态
     * @param purchase
     */
    public void AuditPurchase(Purchase purchase);



}
