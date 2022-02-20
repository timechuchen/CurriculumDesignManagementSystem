package com.chuchen.service.impl;

import com.chuchen.bean.Topic;
import com.chuchen.dao.ITopicDao;
import com.chuchen.dao.impl.TopicDaoImpl;
import com.chuchen.service.ITopicService;

import java.util.List;

public class TopicServiceImpl implements ITopicService {
    @Override
    public boolean addTopic(Topic topic) {
        ITopicDao topicDao = new TopicDaoImpl();
        int i = topicDao.addTopic(topic);
        return i>0;
    }

    @Override
    public Topic findTopic(String topicId) {
        ITopicDao topicDao = new TopicDaoImpl();
        return topicDao.findTopic(topicId);
    }

    @Override
    public List<Topic> findMyTopicByNumber(String studentId) {
        ITopicDao topicDao = new TopicDaoImpl();
        return topicDao.findStudentTopic(studentId);
    }

    @Override
    public List<Topic> findTopicByGrade(String grade) {
        ITopicDao topicDao = new TopicDaoImpl();
        return topicDao.findTopicByGrade(grade);
    }

    @Override
    public List<Topic> findTopicByTeacherId(String teacherId) {
        ITopicDao topicDao = new TopicDaoImpl();
        return topicDao.findTeacherTopic(teacherId);
    }

    @Override
    public boolean setSubmitFileName(String topicId, String fileName) {
        ITopicDao topicDao = new TopicDaoImpl();
        int i = topicDao.setIsSubmit(topicId,true);
        int j = topicDao.setSubmitFilePath(topicId,fileName);
        return i>0 && j>0;
    }

    @Override
    public List<Topic> findTopicByTeacherIdMark(String teacherId) {
        return new TopicDaoImpl().findTopicByTeacherIdMark(teacherId);
    }

    @Override
    public List<Topic> printAllTopic() {
        return new TopicDaoImpl().printAllTopic();
    }
}
