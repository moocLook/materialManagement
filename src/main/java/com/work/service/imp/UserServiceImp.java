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
    //登陆
    @Override
    public User login(String id, String password) {
        User user=userDao.findUserById(id);
        if(user!=null&&user.getPassword().equals(password))
        {
            return user;
        }return null;
    }
    //查询所有用户,仅供测试使用,用不到
    @Override
    public List<User> findAllUser() {
        System.out.println("业务层:查询所有账户信息");
        return userDao.findAllUser();
    }
    //添加用户,也用不到.
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
