package com.lyd.jdbc.demo;

import com.lyd.jdbc.dao.PersonDAO2;
import com.lyd.jdbc.dao.SysDAO;
import com.lyd.jdbc.pojo.Person;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-21 15:58
 **/
public class TestOfTeacherDAO2 extends SysDAO {

    public static void main(String[] args) {
        PersonDAO2 personDAO = new PersonDAO2();
        Person person = new Person();
        person.setId(3);
        person.setName("李白");
        person.setAge(18);

        // 新增
        // personDAO.insert(person)

        // 修改
        // person.setName("白居易");
        // personDAO.update(person);

        // 删除
        // personDAO.delete(person);

        // 查询
        List<Person> personList = personDAO.list();
    }

}
