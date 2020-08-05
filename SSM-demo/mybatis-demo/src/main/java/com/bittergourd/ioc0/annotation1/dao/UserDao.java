package com.bittergourd.ioc0.annotation1.dao;

import com.bittergourd.ioc0.annotation1.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: UserDao
 * @Author: BitterGourd
 * @Date: 2020-01-29 13:03
 *
 * 针对CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface UserDao {
    @Select("select * from user")
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer uid);

    User findById(Integer id);

    User findByName(String name);
}
