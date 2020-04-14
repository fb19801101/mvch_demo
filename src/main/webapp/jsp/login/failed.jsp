<%--
  Created by IntelliJ IDEA.
  User: zengsm
  Date: 2017/12/7
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Failed</title>
</head>
<body>
    <div>
        <h1>用户失效！</h1><br>
        登录名称：<%=request.getParameter("username")%><br>
        登录密码：<%=request.getParameter("password")%><br>

        <hr>
        <h1>ResultJson:</h1><br>
        <span>${resultJson}</span>
    </div>
</body>
</html>
