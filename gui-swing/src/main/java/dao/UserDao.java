package dao;

import entity.User;

import java.sql.*;

/**
 * @Program: knowledge-base
 * @Description: UserDao
 * @Author: BitterGourd
 * @Date: 2020-05-26 14:57
 */
public class UserDao {
    // 根据名字查询，登陆功能
    public User queryUserByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql;
        User user = null;

        try {
            sql = "select * from dbo.te_user where username = ?";

            conn = JDBCUtils.getConnection();

//            st = conn.createStatement();
            st = conn.prepareStatement(sql);
            st.setString(1,name);

            rs = st.executeQuery();

            while (rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }finally {
            JDBCUtils.free(rs,st,conn);
        }
        return user;
    }

    // 插入一个User，注册功能
    public int insertUser(String name,String password) throws SQLException {
        // 增删改都是update 返回的是一个int 类型，不需要对结果集做处理
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql;
        int i;
        // 先验证数据库有没有重名的用户
        if (null != queryUserByName(name)){
            return 0;
        }

        try {
            sql = "insert into dbo.te_user values (?,?)";

            conn = JDBCUtils.getConnection();

            st = conn.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, password);

            i = st.executeUpdate();
            // 数据库客户端里面修改的话 就会 显示有多少条受影响 这个同理

        }finally {
            JDBCUtils.free(rs,st,conn);
        }
        return i;
    }

}
