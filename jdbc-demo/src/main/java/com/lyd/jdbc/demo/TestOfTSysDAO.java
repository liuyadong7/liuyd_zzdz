package com.lyd.jdbc.demo;

import com.lyd.jdbc.dao.SysDAO;
import com.lyd.jdbc.pojo.Person;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-21 15:58
 **/
public class TestOfTSysDAO extends SysDAO {

    public static void main(String[] args) {

        SysDAO<Person> dao = new SysDAO<Person>();

        List<Person> personList = dao.query1(Person.class, "select * from person");

        System.out.println(personList.toString());
    }

}
