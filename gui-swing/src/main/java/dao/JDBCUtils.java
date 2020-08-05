package dao;

import java.sql.*;

/**
 * @Program: knowledge-base
 * @Description: JDBCUtils
 * @Author: BitterGourd
 * @Date: 2020-05-26 14:53
 */
public final class JDBCUtils {
    private static String url = "jdbc:sqlserver://192.168.3.128:1433;DatabaseName=disk_manage";
    private static String user = "sa";
    private static String password = "xx@xg123";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // 保证注册驱动只会做一次
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private JDBCUtils(){}  // 私有的构造方法保证不能被创建

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void free(ResultSet rs, Statement st, Connection conn){
        try {
            if (rs != null){
                rs.close();  // 如果这一行抛异常 也会进行
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(st != null){
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

