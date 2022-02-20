package com.chuchen.servlet.logo.logo.studentLogo;

import com.chuchen.bean.Topic;
import com.chuchen.service.ITeacherService;
import com.chuchen.service.ITopicService;
import com.chuchen.service.impl.TeacherServiceImpl;
import com.chuchen.service.impl.TopicServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TopicInfoServlet", value = "/calTopicInfoServlet")
public class TopicInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String topicId = request.getParameter("topicId");
        String choose = request.getParameter("choose");
        ITopicService topicService = new TopicServiceImpl();
        Topic topic = topicService.findTopic(topicId);
        String teacher  = new TeacherServiceImpl().findTeacher(topic.getTeacherId()).getName();
        request.setAttribute("teacher",teacher);
        request.setAttribute("topic",topic);
        if("1".equals(choose))  request.getRequestDispatcher("JSP/student/topicInfo.jsp").forward(request,response);
        else if("2".equals(choose)) request.getRequestDispatcher("JSP/student/applyTopic.jsp").forward(request,response);
        else request.getRequestDispatcher("JSP/student/printMyTopic.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
