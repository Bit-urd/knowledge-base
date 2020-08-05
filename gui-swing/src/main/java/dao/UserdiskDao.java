package dao;

import java.sql.*;

public class UserdiskDao {
    // 借书的时候先看一下有没有借过
    public boolean queryByUidAndBid(int uid, int bid) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = null;

        try {
            sql = "select * from tr_user_disk where uid = ? and bid = ?";

            conn = JDBCUtils.getConnection();

            st = conn.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement(sql);
            st.setInt(1, uid);
            st.setInt(2, bid);
            rs = st.executeQuery();

        } finally {
            JDBCUtils.free(rs, st, conn);
        }
        if (null == rs) {
            return false;  // 没查到,可以借书
        }
        return true;
        // 查到了,借书弹窗错误
    }

    // 借书的时候先看一下有没有借过
    public boolean queryByName(String username, String diskname) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = null;

        try {
            // todo
            sql = "select * from tr_user_disk where username = ? and diskname = ?";

            conn = JDBCUtils.getConnection();

            st = conn.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, diskname);
            rs = st.executeQuery();
            while (rs.next()) {
                return false;  // 查到了,不可以借书
            }
        } finally {
            JDBCUtils.free(rs, st, conn);
        }
        return true;
        // 没查到,能借书
    }

    // 借书的逻辑
    public int insert(String username, String diskname) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int i = 0;
        String sql = null;

        if (queryByName(username, diskname)) {
            try {
                sql = "insert into tr_user_disk(username,diskname) values (?,?)";

                conn = JDBCUtils.getConnection();

                st = conn.prepareStatement(sql);
                //            PreparedStatement ps = conn.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, diskname);
                i = st.executeUpdate();
            } finally {
                JDBCUtils.free(rs, st, conn);
            }
        }
        return i;
    }

    // 归还的逻辑
    public int delete(String username, String diskname) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = null;
        int i = 0;
        if (!queryByName(username, diskname)) {
            try {
                sql = "delete from tr_user_disk where username = ? and diskname = ?";
                conn = JDBCUtils.getConnection();
                st = conn.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, diskname);
//            PreparedStatement ps = conn.prepareStatement(sql);
                i = st.executeUpdate();

            } finally {
                JDBCUtils.free(rs, st, conn);
            }
        }
        return i;
    }
}
