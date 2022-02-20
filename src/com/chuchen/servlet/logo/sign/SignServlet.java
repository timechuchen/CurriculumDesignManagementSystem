package com.chuchen.servlet.logo.sign;

import com.chuchen.bean.Person;
import com.chuchen.bean.Student;
import com.chuchen.bean.Teacher;
import com.chuchen.service.IStudentService;
import com.chuchen.service.ITeacherService;
import com.chuchen.service.impl.StudentServiceImpl;
import com.chuchen.service.impl.TeacherServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "SignServlet", value = "/calSignServlet")
public class SignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = null;
        String name = null;
        int age = 0;
        String gender = null;
        String password = null;
        String phone = null;
        String card = null;
        String path = null;
        String filename;
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
                            case "uage":
                                age = Integer.parseInt(next.getString("utf-8"));
                                break;
                            case "ugender":
                                gender = next.getString("utf-8");
                                break;
                            case "upwd1":
                                password = next.getString("utf-8");
                                break;
                            case "ucard":
                                card = next.getString("utf-8");
                                break;
                            case "uphone":
                                phone = next.getString("utf-8");
                                break;
                            default:
                                break;
                        }
                    } else {
                        //文件上传（sPicture）
                        //文件名
                        filename = id+"head.jpg";//获取上传的文件名
                        //动态获取服务器路径
                        if(!next.getName().equals("")){
                            if("学生".equals(card)) path = request.getSession().getServletContext().getRealPath("head\\student");
                            else if("老师".equals(card)) path = request.getSession().getServletContext().getRealPath("head\\teacher");
                            File file = new File(path, filename);
                            try {
                                next.write(file);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            path = request.getSession().getServletContext().getRealPath("head")+"\\head.jpg";
                            String path2 = null;
                            if("学生".equals(card)) path2 = request.getSession().getServletContext().getRealPath("head\\student")+"\\"+filename;
                            else if("老师".equals(card)) path2 = request.getSession().getServletContext().getRealPath("head\\teacher")+"\\"+filename;
                            FileInputStream fis = new FileInputStream(path);
                            assert path2 != null;
                            FileOutputStream fos = new FileOutputStream(path2);

                            byte[] temp = new byte[10 * 1024];
                            int readData = 0;
                            while((readData = fis.read(temp)) != -1){
                                fos.write(temp,0,readData);
                            }
                            fos.flush();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        Person person;
        if("学生".equals(card)){
            person = new Student(id,name,gender,age,phone,password);
            IStudentService servlet = new StudentServiceImpl();
            if(servlet.addStudent((Student) person)){
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("JSP/error/failRegister.jsp");
            }
        }else if("老师".equals(card)){
            person = new Teacher(id,name,gender,age,phone,password);
            ITeacherService servlet = new TeacherServiceImpl();
            if(servlet.addTeacher((Teacher) person)){
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("JSP/error/failRegister.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
