package com.chuchen.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckCodeServlet", value = "/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultTip = "false";
        //获取用户输入的验证码
        String checkcodeClient = request.getParameter("checkcode");
        //真实的验证码值
        String checkcode = (String)request.getSession().getAttribute("CHECKCODE");
        if(checkcodeClient.equals(checkcode)){
            resultTip = "true";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(resultTip);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
