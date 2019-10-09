package com.work.service.imp;

import com.work.bean.User;
import com.work.dao.UserDao;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAllUser() {
        System.out.println("业务层:查询所有账户信息");
        return userDao.findAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
