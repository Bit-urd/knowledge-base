package dao;

import entity.Disk;

import java.sql.*;

/**
 * @Program: knowledge-base
 * @Description: DiskDao
 * @Author: BitterGourd
 * @Date: 2020-05-26 14:56
 */
public class DiskDao {
    public Disk queryByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = null;
        Disk disk = null;

        try {
            sql = "select * from dbo.te_disk where name = ?";

            conn = JDBCUtils.getConnection();

            st = conn.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement(sql);
            st.setString(1, name);
            rs = st.executeQuery();

            while (rs.next()) {
                disk = new Disk();
                disk.setName(rs.getString("name"));
                disk.setMessage(rs.getString("message"));
                disk.setNum(rs.getInt("num"));
            }
        } finally {
            JDBCUtils.free(rs, st, conn);
        }
        return disk;
    }
    public void updateByName(String name,int num) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = null;
        Disk disk = null;

        try {
            sql = "update dbo.te_disk set num = ? where name = ?";

            conn = JDBCUtils.getConnection();

            st = conn.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement(sql);
            st.setInt(1, num);
            st.setString(2, name);
            st.executeUpdate();

        } finally {
            JDBCUtils.free(rs, st, conn);
        }
    }
}
