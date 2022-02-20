package com.chuchen.service;

import com.chuchen.bean.Topic;

import java.util.List;

public interface ITopicService {

    /**
     * 添加课设
     * @param topic 添加的课设
     * @return 返回是否添加成功
     */
    boolean addTopic(Topic topic);

    /**
     * 查找指定课设
     * @param topicId 课设id
     * @return 返回指定课设
     */
    Topic findTopic(String topicId);

    /**
     * 通过学号查找课设
     * @param studentId 指定学号
     * @return 返回符合要求课设集合
     */
    List<Topic> findMyTopicByNumber(String studentId);

    /**
     * 通过年级查找课设
     * @param grade 指定年级
     * @return 返回指定课设集合
     */
    List<Topic> findTopicByGrade(String grade);

    /**
     * 通过年级查找课设
     * @param teacherId 指定年级
     * @return 返回指定课设集合
     */
    List<Topic> findTopicByTeacherId(String teacherId);

    boolean setSubmitFileName(String topicId,String fileName);

    List<Topic> findTopicByTeacherIdMark(String teacherId);

    /**
     * 浏览细搜课设信息
     * @return 返回所有课设
     */
    List<Topic> printAllTopic();
}
