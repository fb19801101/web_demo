<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/4/1
  Time:    15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>收支信息添加</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/layui/css/layui.css" media="all">

  <script type="text/javascript" Charset="UTF-8" src="${pageContext.request.contextPath}/res/js/layui/layui.js"></script>
  <script type="text/javascript" Charset="UTF-8" src="${pageContext.request.contextPath}/res/js/check.js"></script>
</head>

<body style="height: calc(100% - 225px)">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>收支信息添加</legend>
</fieldset>

<form class="layui-form" method="POST" action="insertFinance" lay-filter="demoForm" id=""  name="myform" onSubmit="return checkGuidance(myform)">
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">编号</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="pCode"  name="pCode" lay-verify="number" placeholder="可以为空，系统默认自增！" autocomplete="off" value="${message['finance'].pCode}">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">日期</label>
      <div class="layui-input-inline" style="width: 515px">
        <input type="text" class="layui-input" id="pDate" name="pDate" lay-verify="required" placeholder="yyyy-MM-dd" autocomplete="off" value="${message['finance'].pDate}">
      </div>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">款项</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="fCode" name="fCode" lay-verify="required|number" autocomplete="off" value="${message['finance'].fCode}">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">成员</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="mCode" name="mCode" lay-verify="required" autocomplete="off" value="${message['finance'].mCode}">
      </div>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">数量</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="pQty"  name="pQty" lay-verify="required|number" autocomplete="off" value="${message['finance'].pQty}">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">金额</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="pMoney"  name="pMoney" lay-verify="required|number" autocomplete="off" value="${message['finance'].pMoney}">
      </div>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">收支</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="pType"  name="pType" lay-verify="required" autocomplete="off" value="${message['finance'].pType}">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">方式</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="pMethod"  name="pMethod" lay-verify="required" autocomplete="off" value="${message['finance'].pMethod}">
      </div>
    </div>
  </div>

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-inline" style="width: 515px">
      <textarea class="layui-textarea" id="pInfo"  name="pInfo" placeholder="请输入内容" value="${message['finance'].pInfo}"></textarea>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demoForm">提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
      <font align="center" color="red" size="3">${message['msg']}</font>
    </div>
  </div>
</form>

<script>
    layui.config({
        base: '${pageContext.request.contextPath}/res/js/layui/module/'
    }).extend({
        dtree: 'dtree/dtree'
    }).use(['form', 'layer', 'dtree', 'layedit', 'laydate', 'jquery'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,dtree = layui.dtree
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,$ = layui.$;

        //日期
        laydate.render({
            elem: '#qyDate'
            ,value: '2020-05-10'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demoForm)', function(data){
            layer.alert(JSON.stringify(data), {
                title: '最终的提交信息'
            });
            return true;
        });

        //表单赋值
        var urlData = function () {
            var reg = new RegExp("(^|&)"+"data"+"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg); //匹配目标参数
            if(r != null) return decodeURI(r[2]); //decodeURI参数内容。
            return null; //返回参数值
        };
        form.val('demoForm', JSON.parse(urlData()));

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function(){
            var data = form.val('demoForm');
            alert(JSON.stringify(data));
        });

        // 初始化树
        dtree.renderSelect({
            elem: "#partItem"
            ,method: "post"
            ,width: "100%"
            ,dataStyle: "layuiStyle"  //使用layui风格的数据格式
            ,dataFormat: "list"  //配置data的风格为list
            ,url: "${pageContext.request.contextPath}/partitem/toPartItemTreeBody" // 使用url加载（可与data加载同时存在）
            ,initLevel: 1
            ,selectTips: "单选数据示例"
            ,menubar: true //开启菜单栏
            ,checkbar: false  //开启复选框
            ,accordion: true  //开启手风琴模式
            ,line: true  //开启树线
            ,response: { //修改response中返回数据的定义
                statusCode: 0
                ,message: "msg"
                ,treeId: "piId"
                ,parentId: "piPid"
                ,title: "piName"
                ,level: "piLevel"
                ,basicData: "piInfo"
                ,spread: "piFold"
                ,checkArr: "piCheck"
            }
            ,request: {
                field: null
                ,value: null
                ,level: 4
            }
        });

        dtree.render({
            elem: "#costLayer"
            ,method: "post"
            ,width: "100%"
            ,dataStyle: "layuiStyle"  //使用layui风格的数据格式
            ,dataFormat: "list"  //配置data的风格为list
            ,url: "${pageContext.request.contextPath}/costlayer/toCostLayerBody" // 使用url加载（可与data加载同时存在）
            ,initLevel: 1
            ,selectTips: "单选数据示例"
            ,menubar: true //开启菜单栏
            ,checkbar: false  //开启复选框
            ,accordion: true  //开启手风琴模式
            ,line: true  //开启树线
            ,select: true //指定下拉树模式
            ,response: {
                statusCode: 0
                ,message: 'msg'
                ,treeId: "ctId"
                ,parentId: "ctPid"
                ,title: "clName"
                ,level: "ctLevel"
                ,basicData: "clCode"
                ,spread: "ctFold"
                ,checkArr: "ctCheck"
            }
            ,request: {
                id: null
                ,type: "数量层"
                ,level: 4
            }
        });

        dtree.on('node("partItem")', function(obj){
            var json = JSON.parse(JSON.stringify(obj.param));
            $("#piId").val(json.nodeId);
            $("#piName").val(json.context);
        });

        dtree.on('node("costLayer")', function(obj){
            var json = JSON.parse(JSON.stringify(obj.param));
            $("#clId").val(json.nodeId);
            $("#clCode").val(json.basicData);
        });

        //点击任何地方关闭下拉树
        $("body").on("click", function(event){
            $("div[dtree-id][dtree-select]").removeClass("layui-form-selected");
            $("div[dtree-id][dtree-card]").removeClass("dtree-select-show layui-anim layui-anim-upbit");
        });
    });
</script>
</body>
</html>