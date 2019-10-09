package com.work.dao;

import com.work.bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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


    @Update("insert into tb_user (id,name,password) values (#{id},#{name}," +
            "#{password})")
    public void addUser(User user);
}
