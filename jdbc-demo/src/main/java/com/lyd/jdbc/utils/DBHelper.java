package com.lyd.jdbc.utils;

import java.sql.*;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-21 14:18
 **/
public class DBHelper {
    /**
     * 数据库连接属性
     */
    private static String url = "jdbc:mysql://localhost:3306/lyd_jdbc?serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=true&useSSL=false";
    private static String user = "root";
    private static String password = "123456";

    private static boolean normal = false;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        normal = true;
    }

    /**
     * <p> 获取Connection </p>
     * <li> 1. 先判断是否加载过驱动 </li>
     * <li> 2. 获取Connection对象 </li>
     *
     * @param
     * @return
     * @author asus
     * @since 2021/3/21 14:23
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (!normal) {
            throw new ClassNotFoundException();
        }
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * <p> 关闭jdbc资源 </p>
     *
     * @param
     * @return
     * @author asus
     * @since 2021/3/21 16:03
     */
    public static void closeJDBC(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                statement = null;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                connection = null;
            }
        }
    }

    public static void closeJDBC(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                resultSet = null;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                statement = null;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                connection = null;
            }
        }
    }


}
