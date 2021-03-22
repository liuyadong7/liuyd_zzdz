package com.lyd.jdbc.dao;

import com.lyd.jdbc.pojo.Person;
import com.lyd.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 人员的DAO - v1 </p>
 *
 * @author liuyadong
 * @since 2021-03-21 15:51
 **/
public class PersonDAO {

    /**
     * <p> 添加人员方法 </p>
     *
     * @param
     * @return
     * @author asus
     * @since 2021/3/21 16:03
     */
    public boolean insert(int id, String name, int age) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBHelper.getConnection();
            statement = connection.createStatement();
            String sql = "insert into person values (" + id + ",'" + name + "'," + age + " )";
            int count = statement.executeUpdate(sql);
            return count > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
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
            // 使用工具类关闭资源
            // DBHelper.closeJDBC(statement,connection);
        }
        return false;
    }

    /**
     * <p> 修改人员方法 </p>
     *
     * @param
     * @return
     * @author asus
     * @since 2021/3/21 16:11
     */
    public boolean update(int id, String name, int age) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBHelper.getConnection();
            statement = connection.createStatement();
            String sql = "update person set name = '" + name + "',age = '" + age + "' where id = " + id;
            int count = statement.executeUpdate(sql);
            return count > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 使用工具类关闭资源
            DBHelper.closeJDBC(statement, connection);
        }
        return false;
    }


    /**
     * <p> 删除人员方法 </p>
     *
     * @param
     * @return
     * @author asus
     * @since 2021/3/21 16:09
     */
    public boolean deleteById(int id) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBHelper.getConnection();
            statement = connection.createStatement();
            String sql = "delete from person where id = " + id;
            return statement.executeUpdate(sql) > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeJDBC(statement, connection);
        }
        return false;
    }

    public List<Person> list() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement("select * from person");

            resultSet = preparedStatement.executeQuery();

            List<Person> personList = new ArrayList<Person>();

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                personList.add(person);
            }

            return personList;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeJDBC(resultSet, preparedStatement, connection);
        }

        return null;
    }


}
