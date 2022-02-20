package com.chuchen.dao;

import com.chuchen.bean.Student;
import com.chuchen.bean.Teacher;

import java.util.List;

public interface ITeacherDao {

    /**
     * 添加来时
     * @param teacher 添加的老师
     * @return 返回影响的行数
     */
    int addTeacher(Teacher teacher);

    /**
     * @param id 通过id删除的老师
     * @return 返回受影响的行数
     */
    int delTeacher(String id);

    /**
     *
     * @param teacher 修改后的老师信息
     * @return 返回的受影响的行数
     */
    int modTeacher(String id,Teacher teacher);

    /**
     * 浏览所有老师信息
     * @return 返回所有老师信息
     */
    List<Teacher> printAllTeacher();

    /**
     *
     * @param id 查找的学号
     * @return 返回老师对象
     */
    Teacher findTeacher(String id);

    /**
     * 通过学号和密码查找老师
     * @param id 指定的id
     * @param password 指定的密码
     * @return 返回查找的结果
     */
    Teacher findTeacherByIdAndPassword(String id, String password);
}
