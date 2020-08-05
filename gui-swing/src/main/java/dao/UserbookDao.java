package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Program: knowledge-base
 * @Description: BorrowbookDao
 * @Author: BitterGourd
 * @Date: 2020-05-26 15:20
 */
public class userbookDao {
    public void insert() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = null;

        try {
            sql = "select * from dbo.te_book";

            conn = JDBCUtils.getConnection();

            st = conn.createStatement();
//            PreparedStatement ps = conn.prepareStatement(sql);

            rs = st.executeQuery(sql);

            while (rs.next()){
                System.out.println("id:\t"+rs.getObject(1)+"\t"
                        +rs.getObject("id"));  // 建议用列名
                System.out.println("name:\t" + rs.getObject("name"));
            }
        }finally {
            JDBCUtils.free(rs,st,conn);
        }
    }
    public void delete() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = null;

        try {
            sql = "select * from dbo.te_book";

            conn = JDBCUtils.getConnection();

            st = conn.createStatement();
//            PreparedStatement ps = conn.prepareStatement(sql);

            rs = st.executeQuery(sql);

            while (rs.next()){
                System.out.println("id:\t"+rs.getObject(1)+"\t"
                        +rs.getObject("id"));  // 建议用列名
                System.out.println("name:\t" + rs.getObject("name"));
            }
        }finally {
            JDBCUtils.free(rs,st,conn);
        }
    }
}
