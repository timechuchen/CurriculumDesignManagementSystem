package com.chuchen.dao.impl;

import com.chuchen.bean.Student;
import com.chuchen.bean.Teacher;
import com.chuchen.dao.ITeacherDao;
import com.utils.JdbcUtilByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TeacherDaoImpl implements ITeacherDao {
    QueryRunner qr = new QueryRunner();

    @Override
    public int addTeacher(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "INSERT INTO teacher(id,password,name,gender,age,phone) VALUES(?,?,?,?,?,?)";
            return qr.update(connection,sql,teacher.getId(),teacher.getPassword(),teacher.getName(),teacher.getGender(),teacher.getAge(),teacher.getPhone());
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int delTeacher(String id) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "DELETE FROM teacher WHERE id=?";
            return qr.update(connection,sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public int modTeacher(String id, Teacher teacher) {
        Connection connection = null;
        try{
            connection = JdbcUtilByDruid.getConnection();
            String sql = "DELETE FROM teacher WHERE id=?";
            qr.update(connection,sql,id);
            sql = "INSERT INTO teacher(id,password,name,gender,age,phone) VALUES(?,?,?,?,?,?)";
            return qr.update(connection,sql,teacher.getId(),teacher.getPassword(),teacher.getName(),teacher.getGender(),teacher.getAge(),teacher.getPhone());
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public List<Teacher> printAllTeacher() {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from teacher";
            return qr.query(connection,sql,new BeanListHandler<Teacher>(Teacher.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public Teacher findTeacher(String id) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from teacher where id=?";
            return qr.query(connection,sql,new BeanHandler<Teacher>(Teacher.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }

    @Override
    public Teacher findTeacherByIdAndPassword(String id, String password) {
        Connection connection = null;
        try {
            connection = JdbcUtilByDruid.getConnection();
            qr = new QueryRunner();
            String sql = "select * from teacher where id=? and password = ?";
            return qr.query(connection,sql,new BeanHandler<Teacher>(Teacher.class),id,password);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JdbcUtilByDruid.close(null,null,connection);
        }
    }
}

//class Test{
//    public static void main(String[] args) throws FileNotFoundException {
//        Teacher teacher = new Teacher("214912","李白","男",12,"31231","3213");
//        ITeacherDao teacherDao = new TeacherDaoImpl();
//        System.out.println(teacherDao.addTeacher(teacher));
//    }
//}
