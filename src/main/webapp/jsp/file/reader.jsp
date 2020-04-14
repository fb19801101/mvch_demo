<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/2/24
  Time:    14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="readf" class="com.mvc.bean.ReadFileBean" scope="page" />
<html>
<head>
    <title>Test File Reader</title>
</head>
<body>
    <form action="" name="form1" method="get">
        输入要读取的文件带路径名称：
        <input type="text" name="fileName" size="30"
               value="D:\\reader.txt"/>
        <input type="submit" name="submit" value="提交"/>
        <br>单击“提交”按钮，读取文件内容：</form>
    <jsp:setProperty name="readf" property="fileName" param="fileName"/>
    文件<jsp:getProperty name="readf" property="fileName"/>
    的内容如下：<br>
    <jsp:getProperty name="readf" property="filesMess"/>
</body>
</html>
