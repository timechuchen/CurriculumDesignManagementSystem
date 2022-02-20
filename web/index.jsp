<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <!-- 引入index.css文件 -->
  <link rel="stylesheet" href="css/index.css">

  <!-- 引入公共的样式 -->
  <link rel="stylesheet" href="css/base.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/animate.js"></script>
  <script src="js/common.js"></script>
  <!-- 引入首页JS -->
  <script src="js/index.js"></script>
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
  <a href="sign.jsp"><img src="images/enroll.png" alt="注册" class="enroll"></a>
</div>
<!-- 内容 -->
<div class="main w">
  <div class="reg">
    <span>登陆</span>
    <form action="calLogoServlet" method="POST" onsubmit="return check()">
      <table>
        <tr>
          <td class="left">学号：</td>
          <td class="right"><input type="text" name="uid" id="uid" placeholder="请输入10位工号" maxlength="12"></td>
        </tr>
        <tr>
          <td class="left">密码：</td>
          <td class="right"><input type="password" name="upwd" id="upwd" placeholder="请输入密码"></td>
        </tr>
        <tr>
          <td class="left">图片验证：</td>
          <td class="right img"><a href="javascript:reloadCheckImg()"><img src="images/image.jsp" alt="验证码" class="img2"></a> <input type="text" name="checkcode" id="checkcodeId" size="4"></td>
        </tr>
        <tr>
          <td class="left">身份：</td>
          <td class="right">
            <label>
              <select name="ucard">
                <option value="学生">学生</option>
                <option value="老师">老师</option>
                <option value="管理员">管理员</option>
              </select>
            </label>
          </td>
        </tr>
      </table>
      <input type="submit" value="登陆" class="submit"> <input type="reset" value="重置" class="reset">
    </form>
  </div>
  <div class="slide">
    <div class="focus">
      <!-- 左侧按钮 -->
      <a href="javascript:;" class="arrow-l">&lt</a>
      <a href="javascript:;" class="arrow-r">&gt</a>
      <!-- 滚动区域 -->
      <ul>
        <li>
          <img src="upload/轮播图1.png" alt="学生管理系统">
        </li>
        <li>
          <img src="upload/轮播图2.png" alt="学生管理系统">
        </li>
        <li>
          <img src="upload/轮播图3.png" alt="学生管理系统">
        </li>
        <li>
          <img src="upload/轮播图4.png" alt="学生管理系统">
        </li>
      </ul>
      <!-- 小圆圈 -->
      <ol class="circle"></ol>
    </div>
  </div>
  <div class="styde">
    <p>上学期优秀课设</p>
    <table border="1px" cellspacing="0px">
      <tr>
        <th>课设题目</th>
        <th>小组成员</th>
      </tr>
      <tr>
        <td class="ks">学生管理系统</td>
        <td class="stu">张三、李四、王五</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
      <tr>
        <td class="ks">课设题目</td>
        <td class="stu">小组成员</td>
      </tr>
    </table>
  </div>
  <div class="ziliao">
    <div class="left">
      <a href="https://www.baidu.com">
        <p>C++程序设计视频 ---------------------------某某某老师录播</p>
      </a>
      <a href="https://www.baidu.com">
        <p>C语言程序设计视频 ---------------------------某某某老师录播</p>
      </a>
      <a href="https://www.baidu.com">
        <p>java程序设计视频 ---------------------------某某某老师录播</p>
      </a>
      <a href="https://www.baidu.com">
        <p>c#程序设计视频 ---------------------------某某某老师录播</p>
      </a>
      <a href="https://www.baidu.com">
        <p>Go语言程序设计视频 ---------------------------某某某老师录播</p>
      </a>
      <a href="https://www.baidu.com">
        <p>前端开发设计视频 ---------------------------某某某老师录播</p>
      </a>
      <a href="https://www.baidu.com">
        <p>javaWeb开发视频 ---------------------------某某某老师录播</p>
      </a>
    </div>
    <div class="right">
      <a href="https://www.csdn.net"><img src="images/csdn.png" style="width: 50px; border-radius: 25px;" alt="CSDN"></a>
      <a href="https://www.csdn.net"><img src="images/niuke.png" style="width: 50px; border-radius: 25px;" alt="CSDN"></a>
      <a href="https://www.csdn.net"><img src="images/zhihu.png" style="width: 50px; border-radius: 25px;" alt="CSDN"></a>
      <a href="https://www.csdn.net"><img src="images/cxykz.png" style="width: 50px; border-radius: 25px;" alt="CSDN"></a>
      <a href="https://www.csdn.net"><img src="images/LeetCode.png" style="width: 50px; border-radius: 25px;" alt="CSDN"></a>
      <a href="https://www.csdn.net"><img src="images/bilibili.png" style="width: 50px; border-radius: 25px;" alt="CSDN"></a>
    </div>
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
