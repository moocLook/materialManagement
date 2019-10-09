package com.work.controller;

import com.work.bean.User;
import com.work.service.UserService;
import com.work.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("findAll")
    public String findAll(Model model)
    {
        //System.out.println("usercontroller里面的findAll方法.表现层");
        List<User> userlist=userService.findAllUser();
        model.addAttribute("userlist",userlist);
        return "list";
    }

    @RequestMapping("save")
    public String addUser(User user)
    {
        userService.addUser(user);
        return "redirect:/userController/findAll";
    }


}
