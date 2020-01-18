package com.BitterGourd.knowlegebase.daoDemo;

import com.BitterGourd.knowlegebase.daoDemo.util.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: knowledge-base
 * @Description: 利用反射将查询结果封装为对象
 * @Author: BitterGourd
 * @Date: 2020-01-18 18:29
 */
public class ORMDemo {


    List<Map<String, Object>> read(String sql){
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
                ){
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int count = rsmd.getColumnCount();
            String[] colNames = new String[count];
            for (int i = 1; i <= count; i++) {
                colNames[i-1] = rsmd.getColumnLabel(i);
            }

            List<Map<String ,Object>> datas = new ArrayList<>();
            while (resultSet.next()){
                    Map<String ,Object> data = new HashMap<>();
                    for (int j = 0; j < colNames.length; j++) {
                        data.put(colNames[j],
                                resultSet.getObject(colNames[j]));
                    }
                    datas.add(data);
                }
            return datas;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    <T> T getObj(String sql,Class<T> clazz){
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ){
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int count = rsmd.getColumnCount();
            String[] colNames = new String[count];
            for (int i = 1; i <= count; i++) {
                colNames[i-1] = rsmd.getColumnLabel(i);
            }

            T t = null;
            while (resultSet.next()){
                t = clazz.newInstance();  // 必须有一个不带参数的对象
                for (int j = 0; j < colNames.length; j++) {
                    String colName = colNames[j];
                    String methodName = "set"+colName;
                    // 这一点可以sql语句使用别名
                    // 或者查出来变成大写
                    Method[] methods = clazz.getMethods();
                    for (Method m:
                         methods) {
                        if(methodName.equals(m.getName())){
                            m.invoke(t,resultSet.getObject(colName));
                        }
                    }
                }
            }
            return t;
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
