package com.lyd.jdbc.demo;

import com.lyd.jdbc.utils.DBHelper;

import java.sql.*;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-22 22:35
 **/
public class TestOfResultSet {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 获取连接
        Connection connection = DBHelper.getConnection();

        // 发送指令
        PreparedStatement preparedStatement = connection.prepareStatement("select * from person");

        // 类似游标
        ResultSet resultSet = preparedStatement.executeQuery();

        // 表的类型
        ResultSetMetaData mt = resultSet.getMetaData();
        System.out.println(mt.getColumnCount()); // 获得列数
        System.out.println(mt.getColumnType(1)); // 获取的列类型为 Types.INTEGER 的常量
        System.out.println(mt.getColumnClassName(1));  //获取 java 的类型

        // 整表读取
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ":" + resultSet.getString("name") + ":" + resultSet.getInt("age"));
        }

        // 关闭资源
        DBHelper.closeJDBC(preparedStatement, connection);
    }

}
