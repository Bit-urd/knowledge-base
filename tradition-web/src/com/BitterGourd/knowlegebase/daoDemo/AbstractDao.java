package com.BitterGourd.knowlegebase.daoDemo;

import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.function.Function;

/**
 * @Program: knowledge-base
 * @Description: AbstractDao
 * @Author: BitterGourd
 * @Date: 2020-01-17 22:52
 */
public abstract class AbstractDao {
    private DataSource dataSource = JDBCUtils.getDataSource();

    public int update(String sql,Object[] obj){
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = null;
                // 这一点还是传统写法比较好,  不用传统的注意也行只要重写close方法,不迷就行
                // 因为Connection关闭的方法都变了,重写aotuclose接口的方法
                ){
            int a = 0;
            for(Object i : obj){
                preparedStatement.setObject(++a,obj);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        /**
         *      // 这一点叫模板设计模式  父类不知道但是要用，先定义出来，子类实现
         *      // 某几个步骤不确定，提取出来做成抽象方法让子类实现，推迟给子类完成
         *      // servlet的service  doget dopost
         *
         *      // 缺点每多一个sql语句就需要多写一个方法。改用策略模式
         *      实体dao继承abstract
         *
         *     public int update(User user){
         *         String sql = "update user set name=?,birthday=? where id=?";
         *         Object[] args = new Object[]{
         *                 user.getName(),user.getBirthday(),user.getId()
         *         };
         *         super.update(sql,args);
         *     }
         * */
    }

    public Object find(String sql,Object[] objArr){
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                // 这一点还是传统写法比较好,  不用传统的注意也行只要重写close方法,不迷就行
                // 因为Connection关闭的方法都变了,重写aotuclose接口的方法
        ){
            int a = 0;
            for(Object i : objArr){
                preparedStatement.setObject(++a,objArr);
            }
            Object object = null;
            while (resultSet.next()){  // 拿最后一个 前面的被覆盖 if是第一个
                object = mapperRow(resultSet);
            }  // 这点的逻辑 因为要根据查询结果拼成一个对象 但是父类不知道对象的样子
            // 交给子类处理 处理好返回就行  子类需要实现此抽象方法
            return object;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        /**
         *
         *     public Object mapperRow(ResultSet resultSet){
         *         User user = new User();
         *         user.setId(1,resultSet.getInt("Id"));
         *         return user;
         *     };
         *     public Object find(){
         *         String sql = "select * from user where id=?";
         *         Object[] args = new Object[]{
         *                 user.getId()
         *         };
         *         Object user = super.find(sql,args);
         *         return (User)user;
         *     }
         * */

    }

    public abstract Object mapperRow(ResultSet resultSet);


    public Object find2(String sql, Object[] objArr,
                        Function<ResultSet,Object> function){
        try (   // 此处的Function对象需要子类传入一个内部类,lambda表达式
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery()
        ){
            Object obj = null;
            for (Object i:objArr
            ) {
                ps.setObject(1,i);
            }

            while (resultSet.next()){
                obj = function.apply(resultSet);
            }
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        for (int i : a){
            System.out.println(i);
        }
    }
}
