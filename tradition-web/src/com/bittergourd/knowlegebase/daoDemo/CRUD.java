package com.bittergourd.knowlegebase.daoDemo;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @Program: knowledge-base
 * @Description: CRUD
 * @Author: bittergourd
 * @Date: 2020-01-14 13:17
 */
public class CRUD {

    DataSource dataSource = JDBCUtils.getDataSource();
    // 获取关闭连接 的冗余代码可以抽取为一个抽象类
    static void query() throws SQLException {
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;

        try (
                Connection conn = JDBCUtils.getConnection();

                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery("");
                ){

            while (rs.next()){
                System.out.println(rs.getObject(1)+"\t"
                        +rs.getObject("id"));  // 建议用列名
            }
        }
    }
    static int update() throws SQLException {
        // 增删改都是update 返回的是一个int 类型，不需要对结果集做处理
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql;

        int i;

        try {
            sql = "";

            conn = JDBCUtils.getConnection();

            st = conn.createStatement();

            i = st.executeUpdate(sql);
            // 数据库客户端里面修改的话 就会 显示有多少条受影响 这个同理

        }finally {
            JDBCUtils.free(rs,st,conn);
        }
        return i;
    }

    public void batchTest(){
        // 批处理executeBatch
        // 相当于executeupdate的加强版  在某些(大部分)数据库里可以优化性能
        // executeQuery不能这样用
        String sql = "";

        int[] i;

        try (
                Connection conn = JDBCUtils.getConnection();
                Statement st = conn.createStatement();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
                ){

            // ps的用法每设置好一条语句 就加入批处理
            ps.setString(1,"456");
            ps.addBatch();
            ps.setString(2,"456");
            ps.addBatch();
            i = ps.executeBatch();
            // st的用法
            st.addBatch("sql1");
            st.addBatch("sql2");
            st.addBatch("sql3");
            i = st.executeBatch();
            // 数据库客户端里面修改的话 就会 显示有多少条受影响 这个同理
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return ;

    }

    public void resuletSetDemo(){
        // 另一种方案 分页sql语句，数据库不支持分页再用这种方案
        // select * from user limit 150,10

        // 可更新的结果集rs.updateFloat()  rs.updateRow()  可读性不好
        try (
                Connection conn = dataSource.getConnection();

                Statement st =
                        conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = st.executeQuery("");
        ){

            while (rs.next()){
                System.out.println(rs.getObject(1)+"\t"
                        +rs.getObject("id"));  // 建议用列名
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getMetaData(String sqlArgs,Object...args){
        try (
                Connection conn = JDBCUtils.getConnection();

                PreparedStatement ps = conn.prepareStatement(sqlArgs);

        ){

            // 获取数据库元数据信息
            DatabaseMetaData dbmd = conn.getMetaData();
            dbmd.getDatabaseProductName();
            dbmd.supportsTransactions();

            // 获取sql语句 元数据信息   // 这功能 mysql驱动没实现  至少早期版本没有
            ParameterMetaData pmd =
                    ps.getParameterMetaData();
            int count = pmd.getParameterCount();
            for(int i=1;i<=count;i++){
                /*System.out.println(pmd.getParameterClassName(i));
                System.out.println(pmd.getParameterType(i));
                System.out.println(pmd.getParameterTypeName(i));*/
                ps.setObject(i,args[i-1]);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    System.out.println(rs.getInt("id")+rs.getByte("Byte"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
