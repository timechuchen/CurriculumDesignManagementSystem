package com.chuchen.dao;

import com.chuchen.bean.Student;

import java.util.List;

public interface IStudentDao {
    /**
     * 增加学生信息
     * @param student 添加的学生对象
     * @return 返回受影响的行数
     */
    int addStudent(Student student);

    /**
     * @param id 通过id删除的学生
     * @return 返回受影响的行数
     */
    int delStudent(String id);

    /**
     *
     * @param student 修改后的学生信息
     * @return 返回的受影响的行数
     */
    int modStudent(String id,Student student);

    /**
     * 修改学生password属性
     * @param student 指定学生
     * @param password 修改的密码
     * @return 返回受影响的行数
     */
    int modStudentPassword(String student,String password);

    /**
     * @param id 查找的学号
     * @return 返回学生对象
     */
    Student findStudent(String id);

    /**
     * 设置学生的topicId属性
     * @param studentId 指定学生
     * @param topicId 课设ID
     */
    void setTopicId(String studentId, String topicId);

    /**
     * 查找还未选择课设的学生而且指定班级的学生
     * @return 返回指定的学生
     */
    List<Student> findNoChooseTopicStudents(String specialId);

    /**
     * 修改成绩
     * @param studentId 要修改的学生
     * @param score 成绩
     * @return 返回受影响的行数
     */
    int setScore(String studentId,double score);

    /**
     * 浏览所有学生
     * @return 返回所有学生
     */
    List<Student> printAllStudent();

    /**
     * 通过学号和密码查找学生
     * @param id 指定的id
     * @param password 指定的密码
     * @return 返回查找的结果
     */
    Student findStudentByIdAndPassword(String id,String password);
}
