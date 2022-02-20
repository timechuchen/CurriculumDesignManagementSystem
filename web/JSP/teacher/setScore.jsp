<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/9
  Time: 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览我的项目详情</title>
</head>
<body>
<h1 align="center">我是项目详情页</h1> <br>
${requestScope.topic}<br>
<%--${requestScope.teacher}--%>
<a href="calDowmSubmitFile?filename=${requestScope.topic.submitFile}">下载学生提交文档</a>
<form action="calSubmitScoreServlet">
    ${requestScope.topic.numberOne}的成绩：<input type="text" name="scoreOne"><br>
    ${requestScope.topic.numberTwo}的成绩：<input type="text" name="scoreTwo"><br>
    ${requestScope.topic.numberThree}的成绩：<input type="text" name="scoreThree"><br>
    <input type="hidden" name="topicId" value="${requestScope.topic.id}">
    <input type="submit" value="提交"> <input type="reset" value="重置">
</form>
</body>
</html>
