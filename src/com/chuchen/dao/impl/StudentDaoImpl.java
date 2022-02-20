package com.chuchen.dao.impl;

import com.chuchen.bean.Student;
import com.chuchen.bean.Topic;
import com.chuchen.dao.IStudentDao;
import com.utils.JdbcUtilByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    QueryRunner qr = new QueryRunner();

    @Override
    public int addStudent(Student student) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "INSERT INTO student(id,password,name,gender,age,phone) VALUES(?,?,?,?,?,?)";
            return qr.update(connection,sql,student.getId(),student.getPassword(),student.getName(),student.getGender(),student.getAge(),student.getPhone());
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int delStudent(String id) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "DELETE FROM student WHERE id=?";
            return qr.update(connection,sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int modStudent(String id,Student student) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "DELETE FROM student WHERE id=?";
            qr.update(connection,sql,id);
            sql = "INSERT INTO student(id,password,name,gender,age,phone) VALUES(?,?,?,?,?)";
            return qr.update(connection,sql,student.getId(),student.getPassword(),student.getName(),student.getGender(),student.getAge(),student.getPhone());
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int modStudentPassword(String studentId, String password) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "update student set password = ? where id = ?";
            return qr.update(connection, sql, password, studentId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public Student findStudent(String id) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from student where id=?";
            return qr.query(connection,sql,new BeanHandler<Student>(Student.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public void setTopicId(String studentId, String topicId) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "update student set topicId = ? where id = ?";
            qr.update(connection, sql, topicId, studentId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Student> findNoChooseTopicStudents(String specialId) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from student where id like ?";
            return qr.query(connection,sql,new BeanListHandler<Student>(Student.class),"%" + specialId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int setScore(String studentId, double score) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "update student set score = ? where id = ?";
            return qr.update(connection, sql, score, studentId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Student> printAllStudent() {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from student";
            return qr.query(connection,sql, new BeanListHandler<>(Student.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public Student findStudentByIdAndPassword(String id, String password) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from student where id=? and password = ?";
            return qr.query(connection,sql, new BeanHandler<>(Student.class),id,password);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }
}

//class Test{
//    public static void main(String[] args) {
//        IStudentDao s = new StudentDaoImpl();
//        System.out.println(s.findNoChooseTopicStudents("1902"));
//    }
//}
