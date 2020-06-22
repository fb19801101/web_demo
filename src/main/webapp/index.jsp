<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/3/31
  Time:    7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>指导价录入查询</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/layui/css/layui.css" media="all">
  <script type="text/javascript" Charset="UTF-8" src="${pageContext.request.contextPath}/res/js/layui/layui.js"></script>
</head>

<body>
<div style="overflow: scroll; overflow-x: hidden; overflow-y: hidden;">
  <iframe id="iframeTop" name="iframeTop" frameborder="0" scrolling="no"></iframe>
  <iframe id="iframeLeft" name="iframeLeft" frameborder="0" src="left/toLeft" scrolling="auto"></iframe>
  <iframe id="iframeBar" name="iframeBar" frameborder="0" src="right/toBar" scrolling="no"></iframe>
  <iframe id="iframeRight" name="iframeRight" frameborder="0" src="right/toRight" scrolling="auto"></iframe>
  <iframe id="iframeBottom" name="iframeBottom" frameborder="0" scrolling="no"></iframe>
</div>

<script>
    layui.use(['layer', 'form', 'layedit','element', 'upload', 'table', 'jquery'], function(){
        var layer = layui.layer //layer弹层
            ,form = layui.form //form表单
            ,layedit = layui.layedit //layedit编辑框
            ,element = layui.element //element模块
            ,upload = layui.upload //upload模块
            ,table = layui.table //table表格
            ,$ = layui.$; //jQuery
    });
</script>
</body>
</html>