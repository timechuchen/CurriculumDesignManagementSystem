<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/9
  Time: 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目报名</title>
    <%--    引入CSS--%>
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/student/applyTopic.css">
    <!-- 图标的引入 -->
    <link rel="shortcut icon" href="../../logo.ico">
    <%--    引入JS--%>
    <link rel="stylesheet" href="../../css/base.css">
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/animate.js"></script>
    <script src="../../js/common.js"></script>
</head>
<body>
<div class="box">
    <div class="title">项目报名</div>
    <div class="name">
        项目名称： ${requestScope.topic.name}
    </div>
    <div class="name">
        指导老师： ${requestScope.teacher}
    </div>
    <form action="../../calApplyTopicServlet" method="post">
        <div class="name">
            组长学号：<input type="text" name="numberOne">
            组员一：<input type="text" name="numberTwo">
            组员二：<input type="text" placeholder="若只有一位队员可不写" name="numberThree">
        </div>
        <div class="name introduction">
            ${requestScope.topic.introduction}
        </div>
        <div class="name">
            <input type="submit" value="确定提交" class="btn">
            <a href="../../calFileDownloadServlet?filename=${requestScope.topic.resFile}" class="btn">下载帮助文档</a>
        </div>
        <input type="hidden" name="topicId" value="${requestScope.topic.id}">
    </form>
</div>
</body>
</html>
