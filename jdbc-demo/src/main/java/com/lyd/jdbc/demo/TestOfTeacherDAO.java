package com.lyd.jdbc.demo;

import com.lyd.jdbc.dao.PersonDAO;
import com.lyd.jdbc.dao.SysDAO;
import com.lyd.jdbc.pojo.Person;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-21 15:58
 **/
public class TestOfTeacherDAO extends SysDAO {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        //新增
        // personDAO.insert(1, "杜甫", 25);

        //删除
        // boolean result = personDAO.deleteById(1);
        // if (result) {
        //     System.out.println("操作成功！");
        // }

        //修改
        // personDAO.update(2, "李清照", 18);

        //查询数据
        List<Person> personList = personDAO.list();
        System.out.println(personList.toString());

    }

}
