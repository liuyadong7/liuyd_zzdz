package com.lyd.jdbc.demo;

import com.lyd.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-21 15:44
 **/
public class TestOfStatement {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DBHelper.getConnection();

        // 执行sql
        Statement statement = connection.createStatement();
        String sql = "insert into person values (1,'李白',22)";
        int count = statement.executeUpdate(sql);
        System.out.println(count);

        // 关闭资源
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
