package com.BitterGourd.knowlegebase.daoDemo;

import com.BitterGourd.knowlegebase.daoDemo.util.DataSourceAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

// 要从这个获得Connection所以获得的是MyConnection 重写了close方法
// 获取失败也能自动关闭
class DataSourcePool extends DataSourceAdapter {  // 真正的数据源是实现DataSource接口的
    private static String url = "jdbc:mysql://localhost:3306/jdbc";
    private static String user = "root";
    private static String password = "root";
    private static LinkedList<Connection> connectionsPool =
            new LinkedList<>();

    private static int initCount = 5;
    private static int maxCount = 10;
    private int currentCount = 0;

    public DataSourcePool() {
        for (int i = 0; i < initCount; i++) {
            try (Connection conn = this.creatConn()) {
                this.connectionsPool.addLast(conn);
                this.currentCount++;
            } catch (SQLException e) {
                throw new ExceptionInInitializerError();
            }
        }
    }

    public Connection getConnection(){
        synchronized (connectionsPool) {
            if(connectionsPool.size()<maxCount)
                return connectionsPool.removeFirst();
            if(connectionsPool.size()>maxCount)
                return connectionsPool.removeFirst();
        }
        return null;
    }

    private Connection creatConn() throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(url,user
                        ,password);
                ){
            return conn;
        }
    }

    public void free(Connection connection){
        connectionsPool.addLast(connection);
    }
}