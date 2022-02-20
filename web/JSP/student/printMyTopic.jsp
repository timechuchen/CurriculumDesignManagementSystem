<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/9
  Time: 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>浏览我的项目详情</title>
</head>
<body>
    <h1 align="center">我是项目详情页</h1> <br>
    ${requestScope.topic}<br>
    ${requestScope.teacher}
    <c:if test="${requestScope.topic.isSubmit == 0}">
        <form action="calSubmitTopicServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="topicId" value="${requestScope.topic.id}">
            提交文件资料 <input type="file" name="filename" id="">
            <input type="submit" value="提交">
        </form>
    </c:if>
</body>
</html>
