package com.chuchen.servlet.logo.logo.studentLogo;

import com.chuchen.service.IStudentService;
import com.chuchen.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplyTopicServlet", value = "/calApplyTopicServlet")
public class ApplyTopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String topicId = request.getParameter("topicId");
        String numberOne = request.getParameter("numberOne");
        String numberTwo = request.getParameter("numberTwo");
        String numberThree = request.getParameter("numberThree");

        IStudentService studentService = new StudentServiceImpl();
        if(studentService.applyTopic(topicId,numberOne,numberTwo,numberThree)){
            response.sendRedirect("JSP/success/successApplyTopic.jsp");
        }else {
            response.sendRedirect("JSP/error/failApplyTopic.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
