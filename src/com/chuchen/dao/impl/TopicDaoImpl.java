package com.chuchen.dao.impl;

import com.chuchen.bean.Topic;
import com.chuchen.dao.ITopicDao;
import com.utils.JdbcUtilByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class TopicDaoImpl implements ITopicDao {
    QueryRunner qr = new QueryRunner();

    @Override
    public int addTopic(Topic topic) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "INSERT INTO topic(id,name,teacherId,grade,resFile,introduction) VALUES(?,?,?,?,?,?)";
            return qr.update(connection,sql,topic.getId(),topic.getName(),topic.getTeacherId(),topic.getGrade(),topic.getResFile(),topic.getIntroduction());
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int delTopic(String id) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "DELETE FROM topic WHERE id=?";
            return qr.update(connection,sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int setScore(String id, double score) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "update topic set score = ? where id = ?";
            return qr.update(connection,sql,score,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int setSubmitFilePath(String id, String path) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "update topic set submitFile = ? where id = ?";
            return qr.update(connection,sql,path,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int setIsChoose(String id, boolean flag) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "update topic set isChoose = ? where id = ?";
            return qr.update(connection,sql,flag,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int setIsSubmit(String id, boolean flag) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "update topic set isSubmit = ? where id = ?";
            return qr.update(connection, sql, flag, id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int setNumber(String id, String num1, String num2, String num3) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "update topic set numberOne = ?,numberTwo = ?,numberThree = ? where id = ?";
            return qr.update(connection,sql,num1,num2,num3,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public Topic findTopic(String id) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from topic where id=?";
            return qr.query(connection,sql,new BeanHandler<Topic>(Topic.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Topic> findTeacherTopic(String teacherId) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from topic where teacherId=?";
            return qr.query(connection,sql,new BeanListHandler<Topic>(Topic.class),teacherId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Topic> findTopicByGrade(String grade) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from topic where grade like ?";
            return qr.query(connection,sql,new BeanListHandler<Topic>(Topic.class),"%"+grade);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Topic> findStudentTopic(String studentId) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from topic where numberOne = ? or numberTwo = ? or numberThree = ?";
            return qr.query(connection,sql,new BeanListHandler<Topic>(Topic.class),studentId,studentId,studentId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Topic> printAllTopic() {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from topic";
            return qr.query(connection,sql,new BeanListHandler<Topic>(Topic.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Topic> findTopicByTeacherIdMark(String teacherId) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from topic where teacherId = ? and isChoose = 1";
            return qr.query(connection,sql,new BeanListHandler<Topic>(Topic.class),teacherId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }
}

//class Test{
//    public static void main(String[] args) {
//        TopicDaoImpl topicDao = new TopicDaoImpl();
////        Topic t1 = new Topic("1001003","学生管理系统","101111212","一大","C盘","好好学习，天天向上");
////        if(topicDao.addTopic(t1)>=1){
////            System.out.println("添加成功！！！");
////        }else {
////            System.out.println("添加失败！！！");
////        }
////        if(topicDao.setScore("1001003",99.9)>0){
////            System.out.println("修改成功！！！");
////        }
//        System.out.println(topicDao.printAllTopic());
//    }
//}
