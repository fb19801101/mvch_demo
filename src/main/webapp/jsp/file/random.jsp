<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/2/24
  Time:    14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mvc.bean.RandomFileBean" %>
<jsp:useBean id="randf" class="com.mvc.bean.RandomFileBean" scope="page" />
<html>
<head>
    <title>Test File Random</title>
</head>
<body>
    <jsp:setProperty name="randf" property="fileName"
                     value="E:\\programJsp\\ch6\\file1.txt" />
    <br>文件当前指针位置：
    <jsp:getProperty name="randf" property="filePointer"/>
    <br>
    <jsp:getProperty name="randf" property="fileName" />
    <jsp:getProperty name="randf" property="filesMess"/>
    文件的长度为：
    <jsp:getProperty name="randf" property="fileLength" />
</body>
</html>
