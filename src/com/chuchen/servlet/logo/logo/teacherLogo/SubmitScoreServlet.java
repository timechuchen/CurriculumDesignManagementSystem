package com.chuchen.servlet.logo.logo.teacherLogo;

import com.chuchen.bean.Topic;
import com.chuchen.service.IStudentService;
import com.chuchen.service.ITopicService;
import com.chuchen.service.impl.StudentServiceImpl;
import com.chuchen.service.impl.TopicServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SubmitScoreServlet", value = "/calSubmitScoreServlet")
public class SubmitScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String topicId = request.getParameter("topicId");
        Topic topic = new TopicServiceImpl().findTopic(topicId);
        double scoreOne = Double.parseDouble(request.getParameter("scoreOne"));
        double scoreTwo = Double.parseDouble(request.getParameter("scoreTwo"));
        double scoreThree = Double.parseDouble(request.getParameter("scoreThree"));

        IStudentService studentService = new StudentServiceImpl();
        studentService.setScore(topic.getNumberOne(),scoreOne);
        studentService.setScore(topic.getNumberTwo(),scoreTwo);
        studentService.setScore(topic.getNumberThree(),scoreThree);

        response.sendRedirect("JSP/success/successSetScore.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
