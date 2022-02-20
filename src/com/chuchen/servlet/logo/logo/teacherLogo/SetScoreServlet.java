package com.chuchen.servlet.logo.logo.teacherLogo;

import com.chuchen.bean.Student;
import com.chuchen.bean.Topic;
import com.chuchen.service.ITopicService;
import com.chuchen.service.impl.TopicServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SetScoreServlet", value = "/calSetScoreServlet")
public class SetScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String topicId = request.getParameter("topicId");

        ITopicService topicService = new TopicServiceImpl();
        Topic topic = topicService.findTopic(topicId);
        request.setAttribute("topic", topic);
        request.getRequestDispatcher("JSP/teacher/setScore.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
