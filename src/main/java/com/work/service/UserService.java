package com.work.service;

import com.work.bean.User;

import java.util.List;

public interface UserService {

    //查询所有账户
    public List<User> findAllUser();
}
