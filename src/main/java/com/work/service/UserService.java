package com.work.service;

import com.work.bean.User;

import java.util.List;

public interface UserService {


    //登陆
    public User login(String id,String password);

    //查询所有账户
    public List<User> findAllUser();
    //保存用户信息
    public void addUser(User user);

    /**
     * 获取某个职位的所有人的信息
     * @return
     */
    public List<User> findAllByPosition(String department,String position);


}
