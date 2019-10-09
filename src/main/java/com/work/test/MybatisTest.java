package com.work.test;

import com.work.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.work.dao.UserDao;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void testFindall() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=sf.openSession();
        UserDao dao=session.getMapper(UserDao.class);
        User user=dao.findAllUser().get(0);
        System.out.println(user.toString());
        session.close();
        in.close();
    }

}
