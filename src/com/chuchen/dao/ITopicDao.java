package com.chuchen.dao;

import com.chuchen.bean.Topic;

import java.util.List;

public interface ITopicDao {

    /**
     * 添加课题
     * @param topic 添加的课题
     * @return 返回受影响的行数
     */
    int addTopic(Topic topic);

    /**
     * 删除课设
     * @param id 要删除课设的id
     * @return 返回受影响的行数
     */
    int delTopic(String id);

    /**
     * 指定课设设置分数
     * @param id 设置分数的课设
     * @param score 设置的分数
     * @return 返回受影响的行数
     */
    int setScore(String id,double score);

    /**
     * 设置课设学生提交的文件名
     * @param id 指定的课设
     * @param path 文件名（一般在该课设id同名的目录下）
     * @return 返回受影响的行数
     */
    int setSubmitFilePath(String id,String path);

    /**
     * 设置该课设是否被选择
     * @param id 指定的课设
     * @param flag 是否被选择的标志
     * @return 返回受影响的行数
     */
    int setIsChoose(String id,boolean flag);

    /**
     * 设置该课设是否被提交
     * @param id 指定的课设
     * @param flag 是否提交的标志
     */
    int setIsSubmit(String id, boolean flag);

    /**
     * 设置该课设的成员
     * @param id 指定的课设
     * @param num1 组长
     * @param num2 成员1
     * @param num3 成员2
     * @return 返回受影响的行数
     */
    int setNumber(String id,String num1,String num2,String num3);

    /**
     * 查找指定课设
     * @param id 指定id
     * @return 返回查找到的课设
     */
    Topic findTopic(String id);

    /**
     * 查找指定老师的课设
     * @param teacherId 指定的老师
     * @return 返回符合要求的所有课设
     */
    List<Topic> findTeacherTopic(String teacherId);

    /**
     * 通过年级查找课设
     * @param grade 指定年级
     * @return 返回符合要求课设
     */
    List<Topic> findTopicByGrade(String grade);

    /**
     * 查找指定学生的课设
     * @param studentId 指定的学生
     * @return 返回符合要求的所有课设
     */
    List<Topic> findStudentTopic(String studentId);

    /**
     * 浏览所有课设
     * @return 返回所有课设
     */
    List<Topic> printAllTopic();

    List<Topic> findTopicByTeacherIdMark(String teacherId);
}
