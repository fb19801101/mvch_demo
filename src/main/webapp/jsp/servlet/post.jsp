<%--
  Created by IntelliJ IDEA.
  User: zsm
  Date: 2017/11/15
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Http Post</title>
    <%@include file="../ajax.jsp" %>
</head>
<body>
    <div style="margin-left: 30%;margin-top: 30px">
        <div style="height: 40px">
            <form action="post/find" method="post">
                用户 : <input type="text" name="username" value="admin"/>
                <input type="submit"  value="PostWrite"/>
            </form>
        </div>
        <div style="height: 40px">
            <input type="button" value="PostHref" onclick = "window.location.href = '${pageContext.request.contextPath}/index.jsp'">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost" onclick="postTest('')">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost1" onclick="postTest(1)">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost2" onclick="postTest(2)">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost3" onclick="postTest(3)">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost4" onclick="postTest(4)">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost5" onclick="postTest(5)">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost6" onclick="postTest1(6)">
        </div>
        <div style="height: 40px">
            <input type="button" value="TestPost7" onclick="postTest2()">
        </div>
    </div>
</body>
<script type="text/javascript">
    var url = "${pageContext.request.contextPath}/servlet/post/findUser";
    var params = {username: "admin", password: "123456"};

    function postTest(param) {
        postRequest(url + param, params, "application/x-www-form-urlencoded", function () {
        });
    }

    function postTest1(param) {
        postRequest(url + param, JSON.stringify(params), "application/json;charset=utf-8", function () {
        });
    }

    function postTest2() {
        postRequest(url +"7/admin/123456", JSON.stringify(params), "application/json;charset=utf-8", function () {
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
            // 1、type: 要求为String类型的参数，请求方式（post或get）默认为get。注意其他http请求方法，例如put和delete也可以使用，但仅部分浏览器支持。
            type: "POST",
            // 2、url: 要求为String类型的参数，（默认为当前页地址）发送请求的地址。
            url: urlStr,
            // 3、timeout: 要求为Number类型的参数，设置请求超时时间（毫秒）。此设置将覆盖$.ajaxSetup()方法的全局设置。
            // 4、async: 要求为Boolean类型的参数，默认设置为true，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为false。注意，同步请求将锁住浏览器，用户其他操作必须等待请求完成才可以执行。
            async: false,
            // 5、cache: 要求为Boolean类型的参数，默认为true（当dataType为script时，默认为false），设置为false将不会从浏览器缓存中加载请求信息。
            // 6、data: 要求为Object或String类型的参数，发送到服务器的数据。如果已经不是字符串，将自动转换为字符串格式。get请求中将附加在url后。防止这种自动转换，
            // 可以查看　　processData选项。对象必须为key/value格式，例如{foo1:"bar1",foo2:"bar2"}转换为&foo1=bar1&foo2=bar2。如果是数组，JQuery将自动为不同值对应同一个名称。例如{foo:["bar1","bar2"]}转换为&foo=bar1&foo=bar2。
            data: param,
            // 7、dataType: 要求为String类型的参数，预期服务器返回的数据类型。如果不指定，JQuery将自动根据http包mime信息返回responseXML或responseText，并作为回调函数参数传递。可用的类型如下：
            // xml：返回XML文档，可用JQuery处理。
            // html：返回纯文本HTML信息；包含的script标签会在插入DOM时执行。
            // script：返回纯文本JavaScript代码。不会自动缓存结果。除非设置了cache参数。注意在远程请求时（不在同一个域下），所有post请求都将转为get请求。
            // json：返回JSON数据。
            // jsonp：JSONP格式。使用SONP形式调用函数时，例如myurl?callback=?，JQuery将自动替换后一个“?”为正确的函数名，以执行回调函数。
            // text：返回纯文本字符串。
            dataType: "json",
            // 8、beforeSend： 要求为Function类型的参数，发送请求前可以修改XMLHttpRequest对象的函数，例如添加自定义HTTP头。在beforeSend中如果返回false可以取消本次ajax请求。XMLHttpRequest对象是惟一的参数。
            // function(XMLHttpRequest){
            //     this;   //调用本次ajax请求时传递的options参数
            // }
            // 9、complete： 要求为Function类型的参数，请求完成后调用的回调函数（请求成功或失败时均调用）。参数：XMLHttpRequest对象和一个描述成功请求类型的字符串。
            // function(XMLHttpRequest, textStatus){
            //     this;    //调用本次ajax请求时传递的options参数
            // }
            // 10、success： 要求为Function类型的参数，请求成功后调用的回调函数，有两个参数。
            // (1)由服务器返回，并根据dataType参数进行处理后的数据。
            // (2)描述状态的字符串。
            // function(data, textStatus){
            //     //data可能是xmlDoc、jsonObj、html、text等等
            //     this;  //调用本次ajax请求时传递的options参数
            // }
            // 11.error:
            // 要求为Function类型的参数，请求失败时被调用的函数。该函数有3个参数，即XMLHttpRequest对象、错误信息、捕获的错误对象(可选)。ajax事件函数如下：
            // function(XMLHttpRequest, textStatus, errorThrown){
            //    //通常情况下textStatus和errorThrown只有其中一个包含信息
            //    this;   //调用本次ajax请求时传递的options参数
            // }
            // 12、contentType： 要求为String类型的参数，当发送信息至服务器时，内容编码类型默认为"application/x-www-form-urlencoded"。该默认值适合大多数应用场合。
            // 设置你发送给服务器的格式。RequestBody 接受参数时需设置 application/json;charset=utf-8
            contentType: contentType,
            // 13、dataFilter： 要求为Function类型的参数，给Ajax返回的原始数据进行预处理的函数。提供data和type两个参数。data是Ajax返回的原始数据，type是调用jQuery.ajax时提供的dataType参数。函数返回的值将由jQuery进一步处理。
            // function(data, type){
            //     //返回处理后的数据
            //     return data;
            // }
            // 14、global： 要求为Boolean类型的参数，默认为true。表示是否触发全局ajax事件。设置为false将不会触发全局ajax事件，ajaxStart或ajaxStop可用于控制各种ajax事件。
            // 16、ifModified： 要求为Boolean类型的参数，默认为false。仅在服务器数据改变时获取新数据。服务器数据改变判断的依据是Last-Modified头信息。默认值是false，即忽略头信息。
            // 17、jsonp： 要求为String类型的参数，在一个jsonp请求中重写回调函数的名字。该值用来替代在"callback=?"这种GET或POST请求中URL参数里的"callback"部分，例如{jsonp:'onJsonPLoad'}会导致将"onJsonPLoad=?"传给服务器。
            // 18、username： 要求为String类型的参数，用于响应HTTP访问认证请求的用户名。
            // 19、password： 要求为String类型的参数，用于响应HTTP访问认证请求的密码。
            // 20、processData： 要求为Boolean类型的参数，默认为true。默认情况下，发送的数据将被转换为对象（从技术角度来讲并非字符串）以配合默认内容类型"application/x-www-form-urlencoded"。如果要发送DOM树信息或者其他不希望转换的信息，请设置为false。
            // 21、scriptCharset： 要求为String类型的参数，只有当请求时dataType为"jsonp"或者"script"，并且type是GET时才会用于强制修改字符集(charset)。通常在本地和远程的内容编码不同时使用。

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

            // $(function(){
            //     $('#send').click(function(){
            //         $.ajax({
            //             type: "GET",
            //             url: "test.json",
            //             data: {username:$("#username").val(), content:$("#content").val()},
            //             dataType: "json",
            //             success: function(data){
            //                 $('#resText').empty();   //清空resText里面的所有内容
            //                 var html = '';
            //                 $.each(data, function(commentIndex, comment){
            //                     html += '<div class="comment"><h6>' + comment['username']                                         + ':</h6><p class="para"' + comment['content']                                         + '</p></div>';
            //                 });
            //                 $('#resText').html(html);
            //             }
            //         });
            //     });
            // });
        })
    }
</script>
</html>
