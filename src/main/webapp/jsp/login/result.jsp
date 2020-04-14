<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/2/24
  Time:    20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mvc.bean.LoginBean" %>
<jsp:useBean id="login" class="com.mvc.bean.LoginBean" scope="page" />
<html>
<head>
    <title>Test Login Bean</title>
</head>
<body bgcolor="cyan" >
    <jsp:setProperty name="login"  property="*" />
    <% if (login.checkLogin()) { %>
    <h2>欢迎<jsp:getProperty name="login" property="username"/>
        进入考生报名系统。</h2>
    <% } else { %>
    <h2>登录失败,单击<a href="javascript:history.back(-1);">
        这里重新登录</a></h2><% }
    %>
    <p>您登录的信息是：<br>用户名称：
    <jsp:getProperty name="login" property="username"/>
    <br>用户密码：
    <jsp:getProperty name="login" property="password"/>
</body>
</html>
