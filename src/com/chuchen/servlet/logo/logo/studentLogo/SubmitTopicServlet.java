package com.chuchen.servlet.logo.logo.studentLogo;

import com.chuchen.service.ITopicService;
import com.chuchen.service.impl.TopicServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;

@WebServlet(name = "SubmitTopicServlet", value = "/calSubmitTopicServlet")
public class SubmitTopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String filename = request.getParameter("filename");
        String topicId = null;
        String path = null;
        //上传
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if(multipartContent){
            //判断前台是否有Multipart属性
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
            try {
                //此时前端的数据就保存到fileItems中
                List<FileItem> fileItems = upload.parseRequest(request);
                //通过迭代器遍历表单的内容（uid,uname,sPicture）
                for (FileItem next : fileItems) {
                    //要根据name来判断各属性值
                    String fileName = next.getFieldName();//获取普通字段的name名。
                    //判断前台传过来的字段是否为文件字段
                    if (next.isFormField()){
                        if(fileName.equals("topicId")) topicId = next.getString("utf-8");
                    }else {
                        //文件上传（sPicture）
                        //文件名
                        filename = topicId+"submitFile.zip";//获取上传的文件名
                        ITopicService topicService = new TopicServiceImpl();
                        topicService.setSubmitFileName(topicId,filename);
                        path = request.getSession().getServletContext().getRealPath("file\\studentSubmit");
                        File file = new File(path, filename);
                        try {
                            next.write(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            response.sendRedirect("JSP/success/successSubmit.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
