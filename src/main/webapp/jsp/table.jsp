<%--
  Created by IntelliJ IDEA.
  User: zsm
  Date: 2017/11/15
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>DataBase Modify Method</title>
    <%@include file="ajax.jsp" %>
</head>
<body>

</body>
<body>
<h1>单行数据</h1><br>
<form action="display" method="post">
    <div style="margin-left: 30%;margin-top: 30px">
        序号 : <input type="text" id="id" name="id" value="11"/><br/>
        学号 : <input type="text" id="user_no" name="user_no" value="500"/><br/>
        姓名 : <input type="text" id="user_name" name="user_name" value="test"/><br/>
        密码 : <input type="text" id="user_pwd" name="user_pwd" value="123"/><br/>
        性别 : <input type="text" id="user_sex" name="user_sex" value="男"/><br/>
        生日 : <input type="text" id="user_birth" name="user_birth" value="1980/11/1"/><br/>
        班级 : <input type="text" id="user_class" name="user_class" value="95000"/><br/>
        创建 : <input type="text" id="date_create" name="date_create" value="1980/11/1"/><br/>
        更新 : <input type="text" id="date_update" name="date_update" value="1980/11/1"/><br/>
    </div>
    <div style="margin-left: 30%;margin-top: 30px">
        方法 : <input type="button" id="insert" value="新增" onclick="postInsert()"/>
        <input type="button" id="update" value="更新" onclick="postUpdate()"/>
        <input type="button" id="delete" value="删除" onclick="postDelete()"/>
        <input type="button" id="query" value="查询" onclick="postQuery()"/><br/>
    </div>
    <div style="margin-left: 30%;margin-top: 30px">
        表单 : <input type="submit" value="显示表格信息"/>
    </div>
</form>

<hr>
<div>
    <%
        String[] cols = new String[]{"id","user_no","user_name","user_pwd","user_sex","user_birth",
                "user_class","date_create","date_update","data_modify"};
    %>
    <table bgcolor="#9999dd" border="1" align="center" width="100%">
        <tr>
            <c:forEach items="<%=cols%>" var="col">
                <th>${col}</th>
            </c:forEach>
        </tr>
        <% int i=1000; %>
        <c:forEach items="${students}" var="item">
            <tr>
                <td align="center" width="9%">${item.id}</td>
                <td align="center" width="9%">${item.userNo}</td>
                <td align="center" width="10%">${item.userName}</td>
                <td align="center" width="10%">${item.userPwd}</td>
                <td align="center" width="10%">${item.userSex}</td>
                <td align="center" width="10%"><fmt:formatDate value="${item.userBirth}" type="date"/></td>
                <td align="center" width="10%">${item.userClass}</td>
                <td align="right" width="18%"><fmt:formatDate value="${item.dateCreate}" type="both"/></td>
                <td align="right" width="18%"><fmt:formatDate value="${item.dateUpdate}" type="both"/></td>
                <td align="center" width="18%">
                    <input type="button" id="<%=i++%>" name="update" value="更新" onclick="postUpdate()"/>
                    <input type="button" id="<%=i++%>" name="delete" value="删除" onclick="postDelete()"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script type="text/javascript">
    //将获取到的 年-月-日 时:分:秒 赋给input文本输入框
    document.getElementById("date_create").value = toDay();
    document.getElementById("date_update").value = toDay();

    function toDay(){//构建方法
        var today=new Date();//new 出当前时间
        var y=today.getFullYear();//获取年
        var M=today.getMonth()+1;//获取月
        var d=today.getDate();//获取日
        var H = today.getHours();//获取时
        var m = today.getMinutes();//获取分
        var s = today.getSeconds();//获取秒
        return y+"-"+M+"-"+d+" "+H+":"+m+":"+s; //返回 年-月-日 时:分:秒
    }

    function postInsert() {
        var url = "${pageContext.request.contextPath}/table/insert";
        var param = {id: document.getElementById("id").value,
            userNo: document.getElementById("user_no").value,
            userName: document.getElementById("user_name").value,
            userPwd: document.getElementById("user_pwd").value,
            userSex: document.getElementById("user_sex").value,
            userBirth: document.getElementById("user_birth").value,
            userClass: document.getElementById("user_class").value,
            dateCreate: document.getElementById("date_create").value,
            dateUpdate: document.getElementById("date_update").value};

        postRequest(url, param, "application/x-www-form-urlencoded", function () {
        });
    }

    function postUpdate() {
        var url = "${pageContext.request.contextPath}/table/update";
        var param = {id: document.getElementById("id").value,
            userNo: document.getElementById("user_no").value,
            userName: document.getElementById("user_name").value,
            userPwd: document.getElementById("user_pwd").value,
            userSex: document.getElementById("user_sex").value,
            userClass: document.getElementById("user_class").value};

        postRequest(url, JSON.stringify(param), "application/json;charset=utf-8", function () {
        });
    }

    function postDelete() {
        var url = "${pageContext.request.contextPath}/table/delete";
        var param = {id: document.getElementById("id").value,
            userNo: document.getElementById("user_no").value};

        postRequest(url, param, "application/x-www-form-urlencoded", function () {
        });
    }

    function postQuery() {
        var url = "${pageContext.request.contextPath}/table/query";
        var param = {id: document.getElementById("id").value,
            userNo: document.getElementById("user_no").value,
            userName: document.getElementById("user_name").value};

        postRequest(url, param, "application/x-www-form-urlencoded", function () {
        });
    }

    /**
     * POST请求
     * @param urlStr
     * @param param
     * @param contentType   "application/json;charset=utf-8"
     * @param callBack  function
     */
    function postRequest(urlStr, param, contentType, callBack) {
        $.ajax({
            type: "POST",
            url: urlStr,
            async: false,
            data: param,
            dataType: "json",
            contentType: contentType,

            success: function (data) {
                console.log(data);
                var json = JSON.parse(data);
                if (json.status == undefined || json.status == 0) {
                    return;
                }
                callBack(json);
                return json;
            },

            error: function (data) {
                console.log(data);
                return data;
            }
        })
    }
</script>
</html>
