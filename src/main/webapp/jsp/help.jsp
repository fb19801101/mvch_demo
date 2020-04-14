<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/17
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Html Help</title>
    <base href="我是做外链的，一般在head里面" target="_blank">
    <style type="text/css">里面可加n多css</style>
    <script type="text/javascript">javescript语句</script>
    <noscript>不支持javescript的替代语句</noscript>
</head>
<body>
    <h1>h1-h6是标题标签</h1>
    <p>p是段落标签</p>
    <a href="https://www.baidu.com" target="_blank">a标签是插入超链接的，herf指定链接地址，target指定新窗口开启</a>
    <br/><!--这是一个换行符-->
    <wbr><!-- 定义何处适合换行，窗口大小不够则不换行 -->
    <%
        String path = request.getContextPath();
    %>
    <img src="<%=path%>/res/img/face.jpg" alt="这是一个图片，加载不出来时显示我" width="100" height="60"><!--加载图像的标签-->
    <hr/><!--这是一条水平线-->
    <abbr title="China">CN</abbr><!--定义缩写-->
    <address>
        rcw <a href="mailto:small_pupil@126.com"></a>
        <br>
        tel:18127655676
    </address><!--定义地址，签名或者文档的作者身份-->
    <area shape="范围,tect/circle" coords="坐标" href="链接地址"><!-- 可以在图像上划分区域，可点击返回herf -->
    <map>一般和area一起用，管理里面的area</map>
    <article>我这里指定面页的独立部分内容，也可以是页眉</article>
    <header>介绍性内容，在article里面</header>
    <aside>语义化标签，我也不知道什么意思</aside>
    <audio controls="controls">
        <source src="链接地址" type="视频类型"><!-- source可以为图片，视频，音频元素指定资源 -->
    </audio><!-- video也是这样用的 -->
    <b>我可以把字体加粗</b>
    <ul><!-- 无序表格；ol有序列表 -->
        <li>我是做表格用的，必须在ul里或者ol里面</li>
    </ul>
    <bdi>把我隔离出来</bdi>
    <bdo dir="rtl">我可以把文字排序倒置，必须有dir</bdo>
    <blockquote cite="引用地址">我是被自动缩进的引用，我可以很长很长</blockquote>
    <cite>我是引用，我将变成斜体字</cite>
    <button type="button" οnclick="alert(我是弹窗内容)">都用我来设置按钮</button>
    <canvas id="我的标识记号">我是画布，想让我变得更美，就要用script</canvas>
    <caption>我是表格的名字，我出现在table里面</caption>
    <col span="2" style="background-color:red"><!-- 我在table下的colgroup中使用，来设置表格的列属性值 -->
    <colgroup>我把表格按列分组了</colgroup>
    <datalist id="input的那个表格list">
        <option value="我是input那个表格里的下拉选项"></option>
    </datalist><!--我与input一起用，做出来的表格高大上呦，还能让用户选择-->
    <dl>
        <dt>小米</dt>
        <dd>为发骚而生</dd>
    </dl><!--看懂了吗？我跟ol，ul差不多，dt是名人，dd要拍名人的马屁，看出来了吧，dl是代表一个描述列表-->
    <del>我会被划上删除线</del>
    <s>我也会被划上删除线</s>
    <ins>我会被划上下划线，表示修改</ins>
    <u>我才是名正言顺的下划线</u>
    <details>
        <summary>点我能看到很多</summary>
        <p>很多</p>
    </details><!--创建一个可折叠的东西，点开你能看到很多-->
    <em>我是强调文本</em><br>
    <strong>我能加粗文本</strong><br>
    <dfn>反正我是斜的，定义项目</dfn><br>
    <code>一段电脑代码</code><br>
    <samp>计算机样本</samp><br>
    <kbd>键盘输入</kbd><br>
    <var>变量</var>
    <dialog open>我差不多一个是个th的批注，但我很大，还不能隐藏</dialog>
    <div class="属性" id="自己体会" lang="语言">我将被很多属性标记，太幸福了</div>
    <embed src="<%=path%>/jsp/login.jsp"/>
    <fieldset>我被用在form下，我下面的input属于我，哼</fieldset>
    <legend>我替fieldset管理input</legend>
    <figure><!--我是独立的，想引用谁就是谁-->
        <figcaption>我属于figure</figcaption>
    </figure>
    <footer>我相当于页脚</footer>
    <form action="把数据存起来,怎么样" method="传输方式post/get">我向服务器传输数据</form>
    <hgroup>标题集合</hgroup>
    <i>斜体文字</i>
    <iframe src="<%=path%>/jsp/login.jsp"></iframe>
    <input type="控件类型" name="给控件起个名字" value="把我传给数据库">
    <label>单选控件类型</label>
    <link rel="stylesheet" type="text/css" href="文件地址吧"><!-- 我一般用来链接css -->
    <make>我将被标记，重点显示哦</make>
    <menu>我定义一个命令列表或菜单，但好像没有浏览器支持我</menu>
    <meta charset="utf-8"><!-- 一般显示在head里 -->
    <meter value="2" min="0" max="10">0到10之间，输出2，相当于20%</meter>
    <nav>导航链接，索引，目录，菜单</nav>
    <object>外部资源
        <param name="" value="">定义资源
    </object>
    <select>定义一个下拉菜单
        <optgroup>下拉菜单里的分类
            <option>分类里面的选项</option>
        </optgroup>
    </select>
    <output>显示计算或用户操作的结果</output>
    <pre>你怎样输入的,我就怎么显示</pre>
    <progress value="88" max="100"><!-- 下载任务完成88% -->
    <q>显示为引号包含</q>
    <ruby>帅<rp>(</rp><rt>shuai</rt><rp>)</rp></ruby><!-- 作为注释标签使用表示很难懂，不知道为什么，但就是这样子 -->
    <section>定义文档独立的一部分</section>
    <small>我是最小号的字体</small>
    <span style="样式">想给我加样式就这么用</span>
    <sub>下标</sub>
    <sup>上标</sup>
    <table border="1">大表哥，里面有很多tr组成,边框为1
        <thead><!-- 我和tbody，tfoot一样，不会对表格造成什么影响，但可以通过我们为每一行加css -->
        <tr>横向定义的表格，表示一行数据
            <th>加粗版表头文档</th>
            <td>表中内容</td>
        </tr>
        </thead>
    </table>
    <textarea rows="10" cols="30">我是一个文本框</textarea>
    <time>时间：21：00</time>
    <track kind="文本轨道的文本类型" src="轨道文件的url"><!-- 可以叫我字幕 -->
</body>
</html>
