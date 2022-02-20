package com.chuchen.service.impl;

import com.chuchen.bean.Student;
import com.chuchen.dao.IStudentDao;
import com.chuchen.dao.ITopicDao;
import com.chuchen.dao.impl.StudentDaoImpl;
import com.chuchen.dao.impl.TopicDaoImpl;
import com.chuchen.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    @Override
    public boolean isFindStudent(String studentId, String studentPassword) {
        IStudentDao studentDao = new StudentDaoImpl();
        return studentDao.findStudentByIdAndPassword(studentId, studentPassword) != null;
    }

    @Override
    public List<Student> printAllStudent() {
        IStudentDao studentDao = new StudentDaoImpl();
        return studentDao.printAllStudent();
    }

    @Override
    public boolean applyTopic(String topicId,String studentId1,String studentId2,String studentId3) {
        ITopicDao topicDao = new TopicDaoImpl();
        IStudentDao studentDao = new StudentDaoImpl();
        try{
            studentDao.setTopicId(studentId1,topicId);
            studentDao.setTopicId(studentId2,topicId);
            studentDao.setTopicId(studentId3,topicId);
            topicDao.setIsChoose(topicId,true);
            int i = topicDao.setNumber(topicId,studentId1,studentId2,studentId3);
            return i>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean submitTopic(String topicId) {
        ITopicDao topicDao = new TopicDaoImpl();
        int i = topicDao.setIsSubmit(topicId,true);
        return i > 0;
    }

    @Override
    public List<Student> findNoChooseTopic_Student(String special) {
        IStudentDao studentDao = new StudentDaoImpl();
        return studentDao.findNoChooseTopicStudents(special);
    }

    @Override
    public Student findStudent(String studentId) {
        return new StudentDaoImpl().findStudent(studentId);
    }

    @Override
    public boolean changePassword(String studentId,String password) {
        int i = new StudentDaoImpl().modStudentPassword(studentId,password);
        return i > 0;
    }

    @Override
    public boolean delStudentInfo(String studentId) {
        int i = new StudentDaoImpl().delStudent(studentId);
        return i>0;
    }

    @Override
    public boolean setScore(String studentId, double score) {
        int i = new StudentDaoImpl().setScore(studentId,score);
        return i>0;
    }

    @Override
    public boolean addStudent(Student student) {
        Student isStudent = new StudentDaoImpl().findStudent(student.getId());
        if(isStudent != null){
            return false;
        }else {
            IStudentDao studentDao = new StudentDaoImpl();
            studentDao.addStudent(student);
            return true;
        }
    }
}
