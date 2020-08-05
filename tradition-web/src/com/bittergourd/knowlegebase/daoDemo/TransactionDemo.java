package com.bittergourd.knowlegebase.daoDemo;

import java.sql.*;

/**
 * @Program: knowledge-base
 * @Description: TransactionDemo
 * @Author: bittergourd
 * @Date: 2020-01-16 00:44
 */
public class TransactionDemo {
    public boolean TransferAccounts(){
        String outAccout = "update user set money=money-10 where id=1";
        float money = 123;
        try (
                Connection conn = JDBCUtils.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = null;
        ) {
            conn.setAutoCommit(false);
            st.executeUpdate(outAccout);  // 转出

            try {
                if (money > 200){  // 如果这种情况抛出异常 并回滚
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                if(conn != null)
                    conn.rollback();  //回滚到sp之前的提交
                throw e;
            }
            String in = "update user set money=money+10 where id=2";
            st.executeUpdate(in);
            conn.commit();
        }catch (SQLException e) {
            throw new RuntimeException();
        }
        return true;
    }
    public boolean rollBackDemo(){
        String outAccout = "update user set money=money-10 where id=1";
        float money = 123;
        try (
                Connection conn = JDBCUtils.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = null;
        ) {
            Savepoint sp = null; // 设置一个回滚点  这个点以前的会提交[多操作时]
            conn.setAutoCommit(false);
            st.executeUpdate(outAccout);  // 转出

            sp = conn.setSavepoint();  // 设置一个回滚点
            try {
                if (money > 200){  // 如果这种情况抛出异常 并回滚
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                if(conn != null) {
                    conn.rollback(sp);  //回滚到sp之前的提交
                    conn.commit();
                }
                throw e;
            }
            String in = "update user set money=money+10 " +
                    "where id=2";
            st.executeUpdate(in);
            conn.commit();
        }catch (SQLException e) {
            throw new RuntimeException();
        }
        return true;
    }
    public void isolation(){
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setTransactionIsolation(Connection
                    .TRANSACTION_READ_COMMITTED);
            // int类型是枚举值,修改隔离级别只会影响到自己当前线程
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void storedProcedure(){  // 存储过程 过时了一般不用
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setTransactionIsolation(Connection
                    .TRANSACTION_READ_COMMITTED);
            // int类型是枚举值,修改隔离级别只会影响到自己当前线程
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
