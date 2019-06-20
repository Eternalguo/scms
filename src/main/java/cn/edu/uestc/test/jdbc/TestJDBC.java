package cn.edu.uestc.test.jdbc;

import java.sql.*;

/**
 * @author :glb
 * @date :Created in 20:15 2019/6/7
 * @discription :test the jdbc
 */
public class TestJDBC {
    public static void main(String[] args) {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(new TestJDBC().findStaff("2"));
    }
    public Staff findStaff(String id) {
        Staff staff = null;
        String url = "jdbc:mysql://localhost:3306/mobile_scm";
        String userName = "root";
        String password = "root";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取数据库连接
            conn = DriverManager.getConnection(url, userName, password);
            String sql = "select * from staff where id = ?";
            //通过连接操作数据库
            ps = conn.prepareStatement(sql);
            //为prepareStatement的参数设置值
            ps.setString(1, id);
            //获得操作的返回结果
            rs = ps.executeQuery();
            if(rs.next()) {
                staff = new Staff();
                staff.setId(id);
                staff.setName(rs.getString("name"));
                staff.setAge(rs.getString("age"));
                staff.setNumber(rs.getString("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭数据库资源
        finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return staff;
    }
}
