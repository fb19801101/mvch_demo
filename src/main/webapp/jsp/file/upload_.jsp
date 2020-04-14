<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/2/24
  Time:    17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mvc.bean.UploadFileBean" %>
<%@ page import="java.io.*" %>
<jsp:useBean id="upfile" class="com.mvc.bean.UploadFileBean" scope="page" />
<html>
<head>
    <title>File Upload</title>
</head>
<body>
    <%  String tempFileName=request.getSession().getId();
        String saveFileName=tempFileName+"test";
        InputStream fileSource=request.getInputStream();
    %>
    <jsp:setProperty name="upfile" property="driverPath"
                     value="D:\\"/>
    <jsp:setProperty name="upfile" property="saveFileName"
                     value="<%=saveFileName%>"/>
    <jsp:setProperty name="upfile" property="fileSource"
                     value="<%=fileSource %>"/>
    <jsp:setProperty name="upfile" property="tempFileName"
                     value="<%=tempFileName %>"/>
    <jsp:getProperty name="upfile" property="backMessage" />
    <%  out.print("上传文件的一些信息如下：<br>");
        out.print("文件路径：");
        out.println(upfile.getDriverPath()+"<br>");
        out.print("文件保存名：");
        out.print(upfile.getSaveFileName()+"<br>");
        out.print("文件原来名称：");
        out.print(upfile.getUploadFileName()+"<br>");
        out.print("临时文件名称：");
        out.print(upfile.getTempFileName()+"<br>");
    %>
</body>
</html>
