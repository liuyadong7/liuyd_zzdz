package com.lyd.jdbc.dao;

import com.lyd.jdbc.pojo.Person;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-22 23:12
 **/
public class PersonDAO2 extends SysDAO {

    public boolean insert(Person person) {
        String sql = "insert into person (id, name, age) values (?, ?, ?)";
        return this.sysUpdate(sql, person.getId(), person.getName(), person.getAge());
    }

    public boolean update(Person person) {
        String sql = "update person set name = ?, age = ? where id = ?";
        return this.sysUpdate(sql, person.getName(), person.getAge(), person.getId());
    }

    public boolean delete(Person person) {
        String sql = "delete from person where id = ?";
        return this.sysUpdate(sql, person.getId());
    }

    public List<Person> list() {
        String sql = "select * from person";
        return this.query(Person.class, sql);
    }

}
