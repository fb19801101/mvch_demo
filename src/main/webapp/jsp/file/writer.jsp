<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/2/24
  Time:    14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mvc.bean.ReadFileBean" %>
<%@ page import="com.mvc.bean.WriteFileBean" %>
<jsp:useBean id="readf" class="com.mvc.bean.ReadFileBean" scope="page" />
<jsp:useBean id="writef" class="com.mvc.bean.WriteFileBean" scope="page"/>
<html>
<head>
    <title>Test File Writer</title>
</head>
<body>
    <jsp:setProperty name="writef" property="fileName"
                     value="D:\\writer.txt" />
    <jsp:setProperty name="writef" property="filesMess"
                     value="这些内容写入文件中！"/>
    <jsp:setProperty name="readf" property="fileName"
                     value="D:\\writer.txt"/>
    文件:
    <jsp:getProperty name="readf" property="fileName"/>
    的内容如下：<br>
    <jsp:getProperty name="readf" property="filesMess"/>
</body>
</html>
