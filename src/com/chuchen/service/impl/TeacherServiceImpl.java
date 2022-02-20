package com.chuchen.service.impl;

import com.chuchen.bean.Student;
import com.chuchen.bean.Teacher;
import com.chuchen.dao.IStudentDao;
import com.chuchen.dao.ITeacherDao;
import com.chuchen.dao.impl.StudentDaoImpl;
import com.chuchen.dao.impl.TeacherDaoImpl;
import com.chuchen.service.ITeacherService;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    @Override
    public boolean changePassword(String teacherId, String password) {
        return false;
    }

    @Override
    public boolean delTeacherInfo(String teacherId) {
        ITeacherDao teacherDao = new TeacherDaoImpl();
        int i = teacherDao.delTeacher(teacherId);
        return i>0;
    }

    @Override
    public List<Teacher> printAllTeacher() {
        ITeacherDao teacherDao = new TeacherDaoImpl();
        return teacherDao.printAllTeacher();
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        ITeacherDao teacherDao = new TeacherDaoImpl();
        int i = teacherDao.addTeacher(teacher);
        return i>0;
    }

    @Override
    public boolean isFindTeacher(String teacherId, String password) {
        ITeacherDao teacherDao = new TeacherDaoImpl();
        return teacherDao.findTeacherByIdAndPassword(teacherId, password) != null;
    }

    @Override
    public Teacher findTeacher(String teacherId) {
        ITeacherDao teacherDao = new TeacherDaoImpl();
        return teacherDao.findTeacher(teacherId);
    }
}
