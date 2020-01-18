package com.BitterGourd.knowlegebase.daoDemo;

import javax.sql.DataSource;
import java.io.File;
import java.sql.*;

/**
 * @Program: knowledge-base
 * @Description: JDBCUtils
 * @Author: BitterGourd
 * @Date: 2020-01-13 23:06
 */
public final class JDBCUtils{

    private static DataSourcePool dataSourcePool = new DataSourcePool();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");  // 保证注册驱动只会做一次
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private JDBCUtils(){}  // 私有的构造方法保证不能被创建
    public static Connection getConnection() {
        return dataSourcePool.getConnection();
    }

    public static void free(ResultSet rs,Statement st,Connection conn)  {
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
                        dataSourcePool.free(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static DataSource getDataSource(){
        return dataSourcePool;  // 我的数据源
    }
}

/*public class JDBCUtils {
    private String url = "jdbc:mysql://localhost:3306/jdbc";
    private String user = "root";
    private String password = "root";

//    private static JDBCUtils innstance = new JDBCUtils();
    private static JDBCUtils instance = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");  // 保证注册驱动只会做一次
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private JDBCUtils(){}  // 私有的构造方法保证不能被创建

    public static JDBCUtils getInstance() {
        if (instance == null) {
            instance = new JDBCUtils();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void free(ResultSet rs,Statement st,Connection conn){
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
}*/

// 单例模式  https://www.jianshu.com/p/3bfd916f2bb2
// JDBCUtils.getInstance().getConnection();

/*    static void template() throws Exception {
        private static String url = "jdbc:mysql://localhost:3306/jdbc";
        private static String user = "root";
        private static String password = "root";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 一、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 二、建立连接
            conn = DriverManager.getConnection(url,user,password);

            // 三、创建语句
            st = conn.createStatement();

            // 四、执行语句
            rs = st.executeQuery("select * from user");

            // 五、处理请求
            while (rs.next()){ // 移动指针

                // 获取每一个单元格
                System.out.println(rs.getObject(1)+"\t"+rs.getObject(1));
            }
        }finally {
            try {
                if (rs != null){
                    rs.close();  // 如果这一行抛异常 也会进行
                }
            } finally {
                try {
                    if(st != null){
                        st.close();
                    }
                } finally {
                    if(conn != null){
                        conn.close();
                    }
                }
            }
        }
    }*/