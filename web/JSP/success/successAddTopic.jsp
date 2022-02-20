<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/9
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加成功</title>
  <style>
    div {
      display: block;
      width: 630px;
      height: 300px;
      margin: 10% auto;
      color: aqua;
      background-color: rgba(94, 88, 95, 0.5);
    }
    button{
      display: inline-block;
      width: 100px;
      height: 60px;
      margin: 100px 100px;
      line-height: 60px;
      text-align: center;
      font-weight: 700;
      font-size: 30px;
      background-color: #1deeab;
      color: #fdfbfb;
      border: 3px solid #3ae5e5;
      border-radius: 25px;
    }
    button:hover{
      background-color: #c81623;
    }
  </style>
  <link rel="stylesheet" href="../../css/base.css">
  <script src="../../js/jquery.min.js"></script>
  <script src="../../js/animate.js"></script>
  <script src="../../js/common.js"></script>
  <script>
    function back(){
      window.history.back();
    }
    function sign(){
      window.location.replace("../../sign.jsp");
    }
  </script>
</head>
<body>
<div>
  <h1 align="center">添加成功</h1>
  <button onclick="back()">确定</button>
</div>
</body>
</html>