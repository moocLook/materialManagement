package com.work.dao;

import com.work.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao接口
 */
@Repository
public interface UserDao {


    /**
     * 根据id查找用户
     * @param id
     * @return User
     */
    @Select("select * from tb_user where id=#{id}")
    public User findUserById(String id);



    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from tb_user")
    public List<User> findAllUser();



    /**
     * 新增用户
     * @param user
     */
    @Update("insert into tb_user (id,name,password) values (#{id},#{name}," +
            "#{password})")
    public void addUser(User user);

    /**
     * 查找某个职位的所有人的信息
     * @param department
     * @param position
     * @return
     */
    @Select("select * from tb_user WHERE department=#{department} and " +
            "position=#{position}")
    public  List<User> findAllByPosition(@Param("department") String department,
                                         @Param("position") String position);
}
