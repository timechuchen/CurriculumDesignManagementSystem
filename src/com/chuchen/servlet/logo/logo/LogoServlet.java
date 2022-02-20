package com.chuchen.servlet.logo.logo;

import com.chuchen.bean.Student;
import com.chuchen.bean.Teacher;
import com.chuchen.bean.Topic;
import com.chuchen.dao.IImageDao;
import com.chuchen.dao.impl.ImageDaoImpl;
import com.chuchen.service.IStudentService;
import com.chuchen.service.ITeacherService;
import com.chuchen.service.ITopicService;
import com.chuchen.service.impl.StudentServiceImpl;
import com.chuchen.service.impl.TeacherServiceImpl;
import com.chuchen.service.impl.TopicServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LogoServlet", value = "/calLogoServlet")
public class LogoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("uid");
        String password = request.getParameter("upwd");
        String card = request.getParameter("ucard");

        if ("学生".equals(card)) {
            IStudentService service = new StudentServiceImpl();
            if (service.isFindStudent(id, password)) {
                ITopicService topicService = new TopicServiceImpl();
                Student student = service.findStudent(id);
                List<Topic> allTopics = topicService.printAllTopic();
                List<Topic> canChooseTopic = topicService.findTopicByGrade(student.getId().substring(student.getId().length() - 4));
                List<Topic> myTopic = topicService.findMyTopicByNumber(student.getId());
                request.setAttribute("student", student);
                request.setAttribute("allTopics", allTopics);
                request.setAttribute("myTopic", myTopic);
                request.setAttribute("canChooseTopic", canChooseTopic);
                request.setAttribute("id", student.getId());
                request.getRequestDispatcher("studentLogo.jsp").forward(request, response);
            } else {
                response.sendRedirect("JSP/error/failLogo.jsp");
            }
        } else if ("老师".equals(card)) {
            ITeacherService service = new TeacherServiceImpl();
            if (service.isFindTeacher(id, password)) {
                ITopicService topicService = new TopicServiceImpl();
                Teacher teacher = service.findTeacher(id);
                List<Topic> myTopics = topicService.findTopicByTeacherId(teacher.getId());
                List<Topic> myMarkTopics = topicService.findTopicByTeacherIdMark(teacher.getId());
                request.setAttribute("teacher", teacher);
                request.setAttribute("myTopics", myTopics);
                request.setAttribute("id", teacher.getId());
                request.setAttribute("myMarkTopics", myMarkTopics);
                request.getRequestDispatcher("teacherLogo.jsp").forward(request, response);
            }else {
                response.sendRedirect("JSP/error/failLogo.jsp");
            }
        }else {
            if("0000000000".equals(id) && "000000".equals(password)){
                ITeacherService teacherService = new TeacherServiceImpl();
                IStudentService studentService = new StudentServiceImpl();
                List<Teacher> allTeachers = teacherService.printAllTeacher();
                List<Student> allStudents = studentService.printAllStudent();
                request.setAttribute("allTeachers", allTeachers);
                request.setAttribute("allStudents", allStudents);
                request.getRequestDispatcher("manager.jsp").forward(request, response);

            }else {
                response.sendRedirect("JSP/error/failLogo.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
