package com.bittergourd.mybatis.dao;

import com.bittergourd.mybatis.domain.User;
import com.bittergourd.mybatis.domain.User;

import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: UserDao
 * @Author: BitterGourd
 * @Date: 2020-01-29 13:03
 */
public interface UserDao {
//    @Select("select * from user")
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer uid);

    User findById(Integer id);

    User findByName(String name);
}
