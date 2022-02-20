package com.chuchen.service;

import com.chuchen.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    /**
     * 修改指定学生的密码
     * @param teacherId 指定的老师
     * @return 是否修改成功
     */
    boolean changePassword(String teacherId,String password);

    /**
     * 删除指定老师信息
     * @param teacherId 指定的老师
     * @return 是否删除成功
     */
    boolean delTeacherInfo(String teacherId);

    /**
     * 浏览所有老师信息
     * @return 返回所有老师信息
     */
    List<Teacher> printAllTeacher();

    /**
     * 添加老师
     * @param teacher 指定的老师
     * @return 是否添加成功
     */
    boolean addTeacher(Teacher teacher);

    /**
     *
     * @param teacherId 指定老师id
     * @param password 指定密码
     * @return 是否找到
     */
    boolean isFindTeacher(String teacherId,String password);

    /**
     * 通过指定工号查找老师
     * @param teacherId 指定的id
     * @return 返回指定的老师
     */
    Teacher findTeacher(String teacherId);
}
