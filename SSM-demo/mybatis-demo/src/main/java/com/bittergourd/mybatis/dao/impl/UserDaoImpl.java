package com.bittergourd.mybatis.dao.impl;

import com.bittergourd.mybatis.dao.UserDao;
import com.bittergourd.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: UserDaoImpl
 * @Author: BitterGourd
 * @Date: 2020-01-29 18:41
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1. 根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2. 调用SqlSession的方法,实现查询列表
        List<User> users = session.selectList("com.bittergourd.mybatis" +
                ".dao.UserDao.findAll"); // 需要传入一个查询语句
        // 3. 关闭连接
        session.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer uid) {

    }

    public User findById(Integer id) {
        return null;
    }

    public User findByName(String name) {
        return null;
    }
}
