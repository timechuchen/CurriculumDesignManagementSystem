<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/7
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>
<%!
  //随机产生颜色
  public Color getColor(){
    Random rand = new Random();
    int r = rand.nextInt(255);
    int g = rand.nextInt(255);
    int b = rand.nextInt(255);
    return new Color(r,g,b);
  }

  //产生随机的四位数
  public String getNum(){
    int rand = (int)(Math.random()*9000 + 1000);
    return String.valueOf(rand);
  }
%>

<%
  //禁止缓存，以防验证码过期
  response.setHeader("Pragma","no-cache");
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Expires","0");

  //绘制验证码
  BufferedImage image = new BufferedImage(80,25,BufferedImage.TYPE_INT_RGB);
  //画笔
  Graphics graphics = image.getGraphics();
  graphics.fillRect(0,0,80,30);

  //绘制真实的验证码
  graphics.setFont(new Font("seif",Font.BOLD,20));
  graphics.setColor(Color.black);
  String checkCode = getNum();
  StringBuffer sb = new StringBuffer();
  for(int i = 0;i<checkCode.length();i++){
    sb.append(checkCode.charAt(i)+" ");// 验证码的每一位数
  }

  graphics.drawString(sb.toString(),15,20);
  //绘制干扰线条
  for(int i = 0;i<30;i++){
    Random ran = new Random();
    int x1 = ran.nextInt(80);
    int y1 = ran.nextInt(30);
    int x2 = ran.nextInt(x1+10);
    int y2 = ran.nextInt(y1+10);

    graphics.setColor(getColor());

    graphics.drawLine(x1,y1,x2,y2);
  }

  //将验证码存到session中以供使用时比较
  session.setAttribute("CHECKCODE",checkCode);

  //真实的产生图片
  ImageIO.write(image,"jpeg",response.getOutputStream());

  //关闭
  out.clear();
  out = pageContext.pushBody();
%>
