package com.typealpha.notecms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String CONN_STR = "jdbc:mysql://localhost:3306/NoteCMS?characterEncoding=utf8";
    private static String USERNAME = "NoteCMS_Admin";
    private static String PWD = "Admin_NoteCMS";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STR,USERNAME,PWD);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
