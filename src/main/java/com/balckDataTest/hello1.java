package com.balckDataTest;

import java.sql.*;

import static java.sql.DriverManager.*;

/**
 * 这数据驱动测试
 *     1，连接mysql
 */
public class hello1 {
    public static void main(String[] args) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = getConnection("jdbc:mysql://localhost:3306/test",
                    "root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //插入操作
        String sql2;
        PreparedStatement pst =null;
        for(int i=0;i<10;i++) {
            String ii = String.valueOf(i+3);
            sql2 = "Insert into xueyuan values(?,?,?)";
            pst = conn.prepareStatement(sql2);
            pst.setString(1,String.valueOf(i+4));
            pst.setString(2,String.valueOf(i+4));
            pst.setString(3,ii);
            pst.executeUpdate();
            System.out.println(sql2);
            try {
                statement.executeQuery(sql2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

       //读取数据操作
        String sql;
        sql  ="SELECT id,name,score FROM xueyuan";
        System.out.println(sql);
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while(rs.next()){
                // 通过字段检索
                String id  = rs.getString("id");
                String name = rs.getString("name");
                int url = rs.getInt("score");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
