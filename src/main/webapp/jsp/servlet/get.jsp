<%--
  Created by IntelliJ IDEA.
  User: zsm
  Date: 2017/11/15
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Http Get</title>
    <script type="application/javascript" src="../../res/js/lib/jquery-3.2.1.min.js"></script>
</head>
<body>
    <div style="margin-left: 15%;margin-top: 30px">
        <div style="height: 40px">
            <a href="get/find"
            >http://localhost:8080/mvch_demo/servlet/get/find</a>
        </div>
        <div style="height: 40px">
            <a href='get/findUser?username="admin"&password="123456"'
            >http://localhost:8080/mvch_demo/servlet/get/findUser?username="admin"&password="123456"</a>
        </div>
        <div style="height: 40px">
            <a href='get/findUser1/admin/123456'
            >http://localhost:8080/mvch_demo/servlet/get/findUser1/admin/123456</a>
        </div>
        <div style="height: 40px">
            <a href='get/findUser2?username="admin"&password="123456"'
            >http://localhost:8080/mvch_demo/servlet/get/findUser2?username="admin"&password="123456"</a>
        </div>
        <div style="height: 40px">
            <a href='get/findUser3?username="admin"&password="123456"'
            >http://localhost:8080/mvch_demo/servlet/get/findUser3?username="admin"&password="123456"</a>
        </div>
        <div style="height: 40px">
            <a href='get/findUser4?username="admin"&password="123456"'
            >http://localhost:8080/mvch_demo/servlet/get/findUser4?username="admin"&password="123456"</a>
        </div>
        <div style="height: 40px">
            <a href='get/findUser5?username="admin"&password="123456"'
            >http://localhost:8080/mvch_demo/servlet/get/findUser5?username="admin"&password="123456"</a>
        </div>
    </div>
</body>
</html>
