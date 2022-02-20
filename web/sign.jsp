<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>sign</title>
    <!-- 图标的引入 -->
    <link rel="shortcut icon" href="logo.ico">
    <!-- 引入初始化样式文件 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入公共的样式 -->
    <link rel="stylesheet" href="css/common.css">
    <!-- 引入sign.css文件 -->
    <link rel="stylesheet" href="css/sign.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/animate.js"></script>
    <script src="js/common.js"></script>
    <!-- 引入登陆页JS -->
    <script src="js/sign.js"></script>
</head>

<body>
<div class="main nw">
    <div class="rgs">
        <h1>欢迎注册账号</h1>
        <h3>账号为学号</h3>
        <div class="box">
            <form action="calSignServlet" method="post" onsubmit="return check();" enctype="multipart/form-data">
                <div class="box1">
                    <table>
                        <tr>
                            <td class="left">姓名：</td>
                            <td class="right"><input type="text" name="uname" id="uname"></td>
                        </tr>
                        <tr>
                            <td class="left">账号：</td>
                            <td class="right"><input type="text" name="uid" maxlength="10" id="uid"></td>
                        </tr>
                        <tr>
                            <td class="left">性别：</td>
                            <td class="right"><input type="text" name="ugender" id="ugender"></td>
                        </tr>
                        <tr>
                            <td class="left">身份：</td>
                            <td class="right">
                                <select name="ucard" id="">
                                    <option value="学生" selected="selected">学生</option>
                                    <option value="老师">教师</option>
                                    <option value="管理员">管理员</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="pit">
                    <div class="pit1" style="padding: 0;"><img src="images/默认头像.png" width="100%" height="100%" class="tx"></div>
                    <input type="file" name="picture" id="file" value="上传照片" onchange="handleFiles(this.files);">
                </div>
                <div class="box2">
                    <table>
                        <tr>
                            <td class="left">年龄：</td>
                            <td class="right"><input type="text" name="uage" id="uage"></td>
                        </tr>
                        <tr>
                            <td class="left">密码：</td>
                            <td class="right"><input type="password" name="upwd1" id="upwd1"></td>
                        </tr>
                        <tr>
                            <td class="left">验证密码：</td>
                            <td class="right"><input type="password" name="upwd2" id="upwd2"></td>
                        </tr>
                        <tr>
                            <td class="left">电话：</td>
                            <td class="right"><input type="text" name="uphone" maxlength="11" id="uphone"></td>
                        </tr>
                    </table>
                    <input type="submit" value="确定" class="submit"> <input type="reset" value="重置" class="reset">
                </div>
            </form>
        </div>
    </div>
</div>
<button onclick="registered();" id="province"></button>
</body>

</html>