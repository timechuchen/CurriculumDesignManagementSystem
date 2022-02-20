package com.chuchen.service;

import com.chuchen.bean.Student;
import com.chuchen.bean.Topic;

import java.util.List;

public interface IStudentService {

    /**
     * 报名参加的课设
     * @param topicId 指定课设
     * @param studentId1 指定的学生
     * @return 是否报名成功
     */
    boolean applyTopic(String topicId,String studentId1,String studentId2,String studentId3);

    /**
     * 提交指定课设
     * @param topicId 指定课设
     * @return 是否提交成功
     */
    boolean submitTopic(String topicId);

    /**
     * 查找还未选择课设的学生
     * @return 返回符合要求的学生集合
     */
    List<Student> findNoChooseTopic_Student(String special);

    /**
     * 查找指定学生（主要用于查看学生的详情信息）
     * @param studentId 指定学生
     * @return 返回指定学生的详情信息
     */
    Student findStudent(String studentId);

    /**
     * 修改指定学生的密码
     * @param studentId 指定的学生
     * @return 是否修改成功
     */
    boolean changePassword(String studentId,String password);

    /**
     * 删除指定学生信息
     * @param studentId 指定的学生
     * @return 是否删除成功
     */
    boolean delStudentInfo(String studentId);

    /**
     * 设置成绩
     * @param studentId 指定学生ID
     * @param score 学生成绩
     * @return 是否修改成功
     */
    boolean setScore(String studentId,double score);

    /**
     * 添加学生
     * @param student 指定的学生
     * @return 是否添加成功
     */
    boolean addStudent(Student student);

    /**
     * 查看是否存在指定学生（主要用来验证登陆）
     * @param studentId 指定学生id
     * @param studentPassword 指定学生密码
     * @return 返回是否存在
     */
    boolean isFindStudent(String studentId,String studentPassword);

    /**
     * 浏览所有学生
     * @return 返回所有学生
     */
    List<Student> printAllStudent();
}
