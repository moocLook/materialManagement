package com.work.service.imp;

import com.work.bean.User;
import com.work.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {
    @Override
    public List<User> findAllUser() {
        System.out.println("业务层:查询所有账户信息");
        return null;
    }
}
