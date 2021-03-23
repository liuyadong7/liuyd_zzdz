package com.lyd.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p> Connection </p>
 *
 * @author liuyadong
 * @since 2021-03-21 13:02
 **/
public class TestOfConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lyd_jdbc?serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=true&useSSL=false", "root", "root");

        System.out.println(connection);

        connection.close();
    }
}
