package com.work.dao;

import com.work.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao接口
 */
@Repository
public interface UserDao {

    //查询所有账户
    @Select("select * from tb_user")
    public List<User> findAllUser();
}
