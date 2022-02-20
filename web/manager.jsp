<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/9
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>设置老师、学生信息</title>
    <!-- 网站说明 -->
    <meta name="description" content="软件工程课程设计管理，可供学生选择，老师评分">
    <!-- 关键字，搜索网站的关注点之一 -->
    <meta name="keywords" content="课设、课程设计、系统">

    <!-- 图标的引入 -->
    <link rel="shortcut icon" href="logo.ico">
    <!-- 引入初始化样式文件 -->
    <link rel="stylesheet" href="css/common.css">
    <!-- 引入公共的样式 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入本页css文件 -->
    <link rel="stylesheet" href="css/manager.css">

    <script src="js/jquery.min.js"></script>
    <script src="js/animate.js"></script>
    <script src="js/common.js"></script>
    <!-- 引入本页JS -->
    <script src="js/manager.js"></script>
</head>
<body>
<div class="pre">
    <span>欢迎各位老师，各位同学使用该管理系统</span>
    <button class="changePF">更换主题</button>
    <ul class="baidu">
        <li><img src="images/背景1.png" alt=""></li>
        <li><img src="images/背景2.png" alt=""></li>
        <li><img src="images/背景3.png" alt=""></li>
        <li><img src="images/背景4.png" alt=""></li>
    </ul>
</div>
<div class="w nav">
    <img src="images/logo.png" alt="logo" class="logo">
    <a href="javascript:"><img src="head/管理员.jpg" alt="注册" class="enroll"></a>
    <div class="name">管理员</div>
</div>
<!-- 内容 -->
<div class="main w">
    <div class="left">
        <ul>
            <li><button class="oneButton">学生信息</button></li>
            <li><button class="oneButton">老师信息</button></li>
        </ul>
    </div>
    <div class="right">
        <table>
            <c:if test="${requestScope.allStudents != null}">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>年级</th>
                    <th>电话</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${requestScope.allStudents}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.gender}</td>
                        <td>${student.phone}</td>
                        <td><a href="calTopicInfoServlet?topicId=${student.id}&choose=1">详情信息</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${requestScope.allStudents == null}">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>年级</th>
                    <th>电话</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="5">没有学生</td>
                </tr>
                </tbody>
            </c:if>
        </table>
        <table style="display: none;">
            <c:if test="${requestScope.allTeachers != null}">
                <thead>
                <tr>
                    <th>工号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="teacher" items="${requestScope.allTeachers}">
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.phone}</td>
                        <td><a href="calTopicInfoServlet?topicId=${student.id}&choose=1">详情信息</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${requestScope.allTeachers == null}">
                <thead>
                <tr>
                    <th>工号</th>
                    <th>姓名</th>
                    <th>年级</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="4">没有老师</td>
                </tr>
                </tbody>
            </c:if>
        </table>
    </div>
</div>
</body>
</html>
