package com.example.spring5application;

import java.sql.*;

public class ConnMySQL {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            // 加載驅動類
            Class.forName("com.mysql.jdbc.Driver");
            long start =System.currentTimeMillis();

            // 建立連接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
                    "root", "~@Xiemengy7~@");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立連接耗時： " + (end - start) + "ms 毫秒");

            // 創建Statement對象
            Statement stmt = conn.createStatement();

            // 執行SQL語句
            ResultSet rs = stmt.executeQuery("select * from city");
            System.out.println("id\tusername\tpwd\t\tregTime");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
                        + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}