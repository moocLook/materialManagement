package com.work.controller;

import com.work.bean.User;
import com.work.service.UserService;
import com.work.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     * @param model
     * @return
     */
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

    /**
     * 登陆
     * @param u  用户名和密码
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public int login(User u, HttpServletRequest request)
    {
        User user=userService.login(u.getId(),u.getPassword());
        if(user!=null)
        {
            // 登陆成功
            request.getSession().setAttribute("loginUser",user);
            return 1;

        }else
        {
            return -1;
        }

    }


}
