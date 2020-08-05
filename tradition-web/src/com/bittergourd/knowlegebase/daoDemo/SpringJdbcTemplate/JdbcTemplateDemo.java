package com.bittergourd.knowlegebase.daoDemo.SpringJdbcTemplate;

import com.bittergourd.knowlegebase.daoDemo.JDBCUtils;
import com.bittergourd.knowlegebase.daoDemo.util.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Program: knowledge-base
 * @Description: JdbcTemplateDemo
 * @Author: bittergourd
 * @Date: 2020-01-18 16:21
 */
public class JdbcTemplateDemo {
    /*
    * JdbcTemplate  ->  NamedParameterJdbcTemplate -> SimpleJdbc(后来删除了)
    *
    * 参数需要
    * 传的javabean对象SqlParameterSource，命名的映射器BeanPropertyRowMapper，
    * BeanPropertyRowMapper  封装的Map、或者javabean对象
    * SqlParameterSource   封装的Map、或者javabean对象
    * */

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    NamedParameterJdbcTemplate named =
            new NamedParameterJdbcTemplate(JDBCUtils.getDataSource());

    User findUser(String name){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(JDBCUtils.getDataSource());
        String sql = "select * from user";
        Object[] args = new Object[]{name};
        User user = jdbcTemplate.queryForObject(sql,args,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User a = new User();
                a.setId(123);
                return a;
            }
        });

        User user2 = jdbcTemplate.queryForObject(sql,args,
                (resultSet,i)->{  // 参数对应接口里的方法。
            User a = new User();
            a.setId(123);
            return a;
        });


        User user3 = jdbcTemplate.queryForObject(sql,args,
                new BeanPropertyRowMapper<>(User.class));

        return user;
    }

    int addUser(User user){
        jdbcTemplate.execute(new ConnectionCallback<Object>(){

            @Override
            public Object doInConnection(Connection connection) throws SQLException, DataAccessException {
                String sql = "";
                PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,user.getId());
                ps.executeUpdate();

                return null;
            }
        });
        return 0;
    }

    User findUser0(User user){
        String sql = "select id from user" +
                "where id<:id";
        Object[] args = new Object[]{
                user.getId()
        };
        Map params = new HashMap();
        params.put("n",user.getId());
        named.queryForObject(sql,params,
                new BeanPropertyRowMapper<>(User.class));

        SqlParameterSource ps =new BeanPropertySqlParameterSource(user);
        // 变量名必须规范
        return named.queryForObject(sql,ps,
                new BeanPropertyRowMapper<>(User.class));

    }

    void addUser0(User user) throws SQLException {
        String sql = "";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        SqlParameterSource parameterSource =
                new BeanPropertySqlParameterSource(User.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        named.update(sql,parameterSource,keyHolder);
        int id = keyHolder.getKey().intValue();
        user.setId(id);

        Map map = keyHolder.getKeys();
    }
}
