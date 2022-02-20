<%@ page import="com.chuchen.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>课程设计、学生选择、老师评分</title>
    <!-- 网站说明 -->
    <meta name="description" content="软件工程课程设计管理，可供学生选择，老师评分">
    <!-- 关键字，搜索网站的关注点之一 -->
    <meta name="keywords" content="课设、课程设计、系统">

    <!-- 图标的引入 -->
    <link rel="shortcut icon" href="logo.ico">
    <!-- 引入初始化样式文件 -->
    <link rel="stylesheet" href="css/common.css">
    <!-- 引入本页css文件 -->
    <link rel="stylesheet" href="css/studentLogo.css">
    <!-- 引入公共的样式 -->
    <link rel="stylesheet" href="css/base.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/animate.js"></script>
    <script src="js/common.js"></script>
    <!-- 引入本页JS -->
    <script src="js/studentLogo.js"></script>
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
<!-- 导航 -->
<div class="w nav">
    <img src="images/logo.png" alt="logo" class="logo">
    <a href="javascript:"><img src="head/student/${requestScope.id}head.jpg" alt="注册" class="enroll"></a>
    <div class="name">${requestScope.student.name}</div>
    <ul class="set" style="display: none">
        <li><a href="JSP/student/studentInfo.jsp" methods="post">个人信息</a></li>
        <li><a href="#" methods="post">退出登陆</a></li>
        <li><a href="#" methods="post">注册账户</a></li>
        <li><a href="JSP/student/modPassword.jsp" methods="post">修改密码</a></li>
    </ul>
</div>
<!-- 内容 -->
<div class="main w">
    <div class="left">
        <ul>
            <li><button class="oneButton">浏览项目</button></li>
            <li><button class="oneButton">项目报名</button></li>
            <li><button class="oneButton">我的项目</button></li>
        </ul>
    </div>
    <div class="right">
        <table>
            <c:if test="${requestScope.allTopics != null}">
                <thead>
                    <tr>
                        <th>课设编号</th>
                        <th>课设名称</th>
                        <th>指导老师</th>
                        <th>详细信息</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="topic" items="${requestScope.allTopics}">
                        <tr>
                            <td>${topic.id}</td>
                            <td>${topic.name}</td>
                            <td>${topic.teacherId}</td>
                            <td><a href="calTopicInfoServlet?topicId=${topic.id}&choose=1">详情信息</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${requestScope.allTopics == null}">
                <thead>
                <tr>
                    <th>课设编号</th>
                    <th>课设名称</th>
                    <th>指导老师</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="4">未到选课时间</td>
                    </tr>
                </tbody>
            </c:if>
        </table>
        <table style="display: none;">
            <c:if test="${requestScope.canChooseTopic.size() != 0}">
                <thead>
                <tr>
                    <th>课设编号</th>
                    <th>课设名称</th>
                    <th>指导老师</th>
                    <th>报名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="topic" items="${requestScope.canChooseTopic}">
                    <tr>
                        <td>${topic.id}</td>
                        <td>${topic.name}</td>
                        <td>${topic.teacherId}</td>
                        <td><a href="calTopicInfoServlet?topicId=${topic.id}&choose=2">报名</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${requestScope.canChooseTopic.size() == 0}">
                <thead>
                <tr>
                    <th>课设编号</th>
                    <th>课设名称</th>
                    <th>指导老师</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="4">没有可选课设</td>
                </tr>
                </tbody>
            </c:if>
        </table>
        <table style="display: none;">
            <c:if test="${requestScope.myTopic.size() != 0}">
                <thead>
                <tr>
                    <th>课设名称</th>
                    <th>学年</th>
                    <th>指导老师</th>
                    <th>分数</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="topic" items="${requestScope.myTopic}">
                    <tr>
                        <td>${topic.name}</td>
                        <td>${topic.grade}</td>
                        <td>${topic.teacherId}</td>
                        <td>${requestScope.student.score}</td>
                        <td><a href="calTopicInfoServlet?topicId=${topic.id}&choose=3">详情信息</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${requestScope.myTopic.size() == 0}">
                <thead>
                <tr>
                    <th>课设名称</th>
                    <th>学年</th>
                    <th>指导老师</th>
                    <th>分数</th>
                    <th>详细信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="5">未选过课设</td>
                </tr>
                </tbody>
            </c:if>
        </table>
    </div>
</div>
<div class="button">
    <div class="nr w">
        <span>乘风破浪会有时,直挂云帆济沧海</span> <br>
        <span>只要努力就会有收获</span> <br>
        <span>好好学习天天向上</span>
    </div>
</div>
</body>
</html>
