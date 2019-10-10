package com.work.dao;

import com.work.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PurchaseDao {


    //查询所有采购员
    @Select("SELECT * FROM tb_user where position='采购员'")
    public List<User> findAllPurcher();

    //
}
