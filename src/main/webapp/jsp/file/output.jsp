<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/2/24
  Time:    11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mvc.bean.InFileBean" %>
<%@ page import="com.mvc.bean.OutFileBean" %>
<jsp:useBean id="infile" class="com.mvc.bean.InFileBean" scope="page" />
<jsp:useBean id="outfile" class="com.mvc.bean.OutFileBean" scope="page"/>
<html>
<head>
    <title>Test File Write</title>
</head>
<body>
    <jsp:setProperty name="outfile" property="fileName"
                     value="${pageContext.request.contextPath}/jsp/file/file.txt"/>
    <jsp:setProperty name="outfile" property="filesMess"
                     value="&lt;br&gt;这些内容写入文件中！"/>
    <jsp:setProperty name="infile" property="fileName"
                     value="${pageContext.request.contextPath}/jsp/file/download.jsp"/>
    文件:
    <jsp:getProperty name="infile" property="fileName"/>
    的内容如下：<br>
    <jsp:getProperty name="infile" property="filesMess"/>
</body>
</html>
