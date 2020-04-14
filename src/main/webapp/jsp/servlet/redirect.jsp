<%--
  Created by IntelliJ IDEA.
  User: zsm
  Date: 2017/11/15
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../ajax.jsp" %>
<html>
<head>
    <title>Test Redirect</title>
</head>
<body>
    <div style="margin-left: 15%;margin-top: 30px">
        <p>Test Redirect Request Web!</p>
        <P>${message}</P>
        <P>${status}</P>
        <P>${data}</P>
    </div>
    <div style="margin-left: 15%;margin-top: 30px">
        <span>重定向跳转</span>
        <div style="height: 40px">
            <a href="${pageContext.request.contextPath}/jump/refresh">ReFresh</a>
        </div>
        <div style="height: 40px">
            <a href="${pageContext.request.contextPath}/jump/header">Header</a>
        </div>
        <div style="height: 40px">
            <a href="${pageContext.request.contextPath}/jump/sendRedirect">SendRedirect</a>
        </div>
    </div>
</body>
</html>
