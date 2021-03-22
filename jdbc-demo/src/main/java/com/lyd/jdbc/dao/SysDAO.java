package com.lyd.jdbc.dao;

import com.lyd.jdbc.utils.DBHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 提取共性处理 </p>
 *
 * @author liuyadong
 * @since 2021-03-22 23:04
 **/
public class SysDAO<T> {

    public boolean sysUpdate(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeJDBC(preparedStatement, connection);
        }
        return false;
    }

    public List<T> query(Class<T> tClass, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<T> list = new ArrayList<>();

            while (resultSet.next()) {

                // 创建对象（存在无参构造即可）
                T instance = tClass.newInstance();

                // 反射操作set方法
                for (int i = 0; i < columnCount; i++) {
                    // 获取列名
                    String columnName = metaData.getColumnName(i + 1);
                    // System.out.println(columnName);

                    // 拼接set方法，属性的首字母大写
                    String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    // System.out.println(methodName);

                    // 获取java的类型，通过名字获取类
                    String columnClassName = metaData.getColumnClassName(i + 1);
                    // System.out.println(columnClassName);
                    Class columnClass = Class.forName(columnClassName);

                    // 执行setter方法
                    Method setter = tClass.getMethod(methodName, columnClass);
                    setter.invoke(instance, resultSet.getObject(i + 1));
                }
                list.add(instance);
            }

            return list;
        } catch (ClassNotFoundException | SQLException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeJDBC(resultSet, preparedStatement, connection);
        }
        return null;
    }

    public List<T> query1(Class<T> tClass, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<T> list = new ArrayList<>();

            Method[] setters = null;


            while (resultSet.next()) {
                // 创建对象（存在无参构造即可）
                T instance = tClass.newInstance();
                if (setters == null) {
                    setters = new Method[columnCount];

                    // 反射操作set方法
                    for (int i = 0; i < columnCount; i++) {
                        // 获取列名
                        String columnName = metaData.getColumnName(i + 1);
                        // System.out.println(columnName);

                        // 拼接set方法，属性的首字母大写
                        String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                        // System.out.println(methodName);

                        // 获取java的类型，通过名字获取类
                        String columnClassName = metaData.getColumnClassName(i + 1);
                        // System.out.println(columnClassName);
                        Class columnClass = Class.forName(columnClassName);

                        // 执行setter方法
                        Method setter = tClass.getMethod(methodName, columnClass);
                        setter.invoke(instance, resultSet.getObject(i + 1));

                        setters[i] = setter;
                    }

                }

                // 第二此，可直接使用，无需反射处理
                for (int i = 0; i < setters.length; i++) {
                    Method setter = setters[i];
                    setter.invoke(instance, resultSet.getObject(i + 1));
                }

                list.add(instance);
            }
            return list;
        } catch (ClassNotFoundException | SQLException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeJDBC(resultSet, preparedStatement, connection);
        }
        return null;
    }


}
