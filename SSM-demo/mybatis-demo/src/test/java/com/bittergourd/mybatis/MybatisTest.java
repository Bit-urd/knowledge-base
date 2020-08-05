package com.bittergourd.mybatis;

import com.bittergourd.mybatis.dao.UserDao;
import com.bittergourd.mybatis.dao.impl.UserDaoImpl;
import com.bittergourd.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: MybatisTest
 * @Author: BitterGourd
 * @Date: 2020-01-29 14:12
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void before() throws Exception {
        // 1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig" +
                ".xml");
        // 2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        // 4. 使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after() throws Exception {
        sqlSession.commit();
        // 6. 释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSave() throws IOException {
        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindAll() throws IOException {
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig" +
                ".xml");
        // 2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4. 使用SqlSession创建Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:
             users) {
            System.out.println(user);
        }
        // 6. 释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 自己实现类
     * @throws IOException
     */
    @Test
    public void testFindAll2() throws IOException {
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig" +
                ".xml");
        // 2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 4. 使用SqlSession创建Dao接口的代理对象
        UserDao userDao = new UserDaoImpl(factory);
        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        if(users!=null)
            for (User user:
                    users) {
                System.out.println(user);
            }
        // 6. 释放资源
        in.close();
    }
}
