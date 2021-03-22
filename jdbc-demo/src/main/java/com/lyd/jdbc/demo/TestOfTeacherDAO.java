package com.lyd.jdbc.demo;

import com.lyd.jdbc.dao.PersonDAO;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @since 2021-03-21 15:58
 **/
public class TestOfTeacherDAO {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        //新增
        // personDAO.insert(2, "杜甫", 25);

        //删除
        // boolean result = personDAO.deleteById(1);
        // if (result) {
        //     System.out.println("操作成功！");
        // }

        //修改
        personDAO.update(2, "李清照", 18);
    }

}
