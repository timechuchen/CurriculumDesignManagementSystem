package com.chuchen.servlet.logo.logo.teacherLogo;

import com.chuchen.bean.Topic;
import com.chuchen.service.ITeacherService;
import com.chuchen.service.ITopicService;
import com.chuchen.service.impl.TeacherServiceImpl;
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

@WebServlet(name = "AddTopicServlet", value = "/calAddTopicServlet")
public class AddTopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String id = null;
        String name = null;
        String grade = null;
        String introduction = null;
        String teacherId = null;
        String filename = null;
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
                    if (next.isFormField()) {
                        switch (fileName) {
                            case "uid":
                                id = next.getString("utf-8");
                                break;
                            case "uname":
                                name = next.getString("utf-8");
                                break;
                            case "ugrade":
                                grade = next.getString("utf-8");
                                break;
                            case "introduction":
                                introduction = next.getString("utf-8");
                                break;
                            case "teacherId":
                                teacherId = next.getString("utf-8");
                                break;
                            default:
                                break;
                        }
                    } else {
                        //文件上传（sPicture）
                        //文件名
                        filename = id+"helpAPI.zip";//获取上传的文件名
                        //动态获取服务器路径
                        String path = request.getSession().getServletContext().getRealPath("file\\upload");
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
            ITopicService topicService = new TopicServiceImpl();
            if(topicService.findTopic(id) == null){
                Topic topic = new Topic(id,name,teacherId,grade,filename,introduction);
                topicService.addTopic(topic);
                response.sendRedirect("JSP/success/successAddTopic.jsp");
            }else {
                //添加失败，课设编号重复
                response.sendRedirect("JSP/error/failAddTopic.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
