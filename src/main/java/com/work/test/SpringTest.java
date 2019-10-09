package com.work.test;

import com.work.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testHello()
    {
        //1. 通过配置文件创建spring容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath" +
                ":applicationContext.xml");

        //2. 通过容器获得bean
        UserService us= (UserService) ac.getBean("userService");

        //3. 调用方法进行测试
        us.findAllUser();
    }
}
