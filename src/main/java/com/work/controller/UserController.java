package com.work.controller;

import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userController")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("findAll")
    public String findAll()
    {
        System.out.println("usercontroller里面的findAll方法.表现层");
        userService.findAllUser();
        return "list";
    }

}
