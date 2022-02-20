package com.chuchen.servlet.logo.logo.studentLogo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@WebServlet(name = "FileDownloadServlet", value = "/calFileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取需要下载的文件名
        String filename = request.getParameter("filename");  //包含了文件的扩展名
        System.out.println(filename);
        //下载文件需要设置一个响应消息头
        response.addHeader("content-Type","application/octet-stream"); //二进制类型文件，任意文件都行
        //需要对不同的浏览器进行不同的处理
        //获取客户端的user-agent（客户端）信息
        String agent = request.getHeader("User-Agent");
        if(agent.toLowerCase(Locale.ROOT).contains("firefox")){
            //客户端是火狐浏览器
            //response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+new String(Base64.encodeBase64(filename.getBytes(StandardCharsets.UTF_8)))+"?=");
            return;
        }else {
            //客户端是edge浏览器
            response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename, StandardCharsets.UTF_8));
        }

        String path = request.getSession().getServletContext().getRealPath("file\\upload");
        InputStream in = new FileInputStream(path+"\\"+filename);
        //通过输出流输出给用户
        ServletOutputStream out = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int lens = -1;
        while((lens = in.read(bytes)) != -1){
            out.write(bytes,0,lens);
        }
        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
