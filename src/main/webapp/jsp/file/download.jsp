<%--
  Created by IntelliJ IDEA.
  User: zengsm
  Date: 2018/1/18
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Down Load File</title>
</head>
<body>
    <div style="margin-left: 30%;margin-top: 30px">
        <div style="height: 40px">
            <a href="student.sql">MySQL查询练习.sql</a>
            <br><hr>
            ${pageContext.request.contextPath}/file/student.sql
        </div>
    </div>
</body>
</html>
