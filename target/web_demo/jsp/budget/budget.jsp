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
  <title>单项概算信息</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/layui/css/layui.css" media="all">

  <script type="text/javascript" Charset="UTF-8" src="${pageContext.request.contextPath}/res/js/layui/layui.js"></script>
  <script type="text/javascript" Charset="UTF-8" src="${pageContext.request.contextPath}/res/js/check.js"></script>
</head>

<body style="height: calc(100% - 225px)">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>单项概算信息</legend>
  <table class="layui-hide" id="demoTable" lay-filter="test"></table>
</fieldset>

<%--头工具栏--%>
<script type="text/html" id="toolbar">
  <div class="layui-form-item">
    <div class="layui-btn-group">
      <button class="layui-btn layui-btn-sm layui-btn-primary" lay-event="expandAll">
        <i class="layui-icon">&#xe625;</i>展开</button>
      <button class="layui-btn layui-btn-sm layui-btn-primary" lay-event="foldAll">
        <i class="layui-icon">&#xe623;</i>折叠</button>
    </div>

    <div class="layui-inline">
      <input class="layui-input" id="filterData" placeholder="输入关键字" autocomplete="off" value="" style="width:140px; height:30px; margin-top:5px; margin-left:20px;">
    </div>

    <div class="layui-btn-group" style="margin-left:-16px;">
      <button class="layui-btn layui-btn-sm layui-btn-primary" lay-event="dataFilter">
        <i class="layui-icon">&#xe615;</i>搜索</button>
      <button class="layui-btn layui-btn-sm layui-btn-primary" lay-event="clearFilter">
        <i class="layui-icon">&#x1006;</i>清除</button>
    </div>
  </div>
</script>

<!-- 表格操作列 -->
<script type="text/html" id="rowBar">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.config({
        base: '${pageContext.request.contextPath}/res/js/layui/module/'
    }).extend({
        dtable: 'dtable/dtable'
    }).use(['layer', 'dtable', 'jquery'], function(){
        var layer = layui.layer
            ,dtable = layui.dtable
            ,$ = layui.$;

        // 渲染表格
        var table_ins = dtable.render({
            elem: '#demoTable'
            ,method: 'post'
            ,title: '用户数据表'
            ,tree: {
                iconIndex: 2
                ,isPidData: true
                ,idName: 'ctId'
                ,pidName: 'ctPid'
                ,openName: 'ctFold'
                ,arrowType: 'arrow2'
                ,getIcon: 'ew-tree-icon-style2'
            }
            ,where: { id: null, level: 5}
            ,url: '${pageContext.request.contextPath}/budget/toBudgetBody'
            ,toolbar: '#toolbar'
            ,defaultToolbar: ['filter', 'print', 'exports']
            ,event: true
            ,cols: [[{type: 'numbers'},{type: 'checkbox'}
                ,{field: 'bgName', title: '菜单名称', minWidth: 400}
                ,{title: '菜单图标', align: 'center', hide: true,templet: '<p><i class="layui-icon {{d.menuIcon}}"></i></p>'}
                ,{field:'bgId', title:'概算ID', width:100, sort: true, fixed: true}
                ,{field:'ctId', title:'清单ID', width:100, sort: true, fixed: true}
                ,{field:'gdId', title:'指导价ID', width:100, sort: true, fixed: true}
                ,{field:'clId', title:'成本层ID', width:100, sort: true, fixed: true}
                ,{field:'ctCode', title:'清单编码', Width:100, sort: true, fixed: true}
                ,{field:'ctName', title:'清单细目', Width:120, sort: true, fixed: true}
                ,{field:'bgCode', title:'概算编码', Width:100, sort: true, fixed: true}
                ,{field:'gdCode', title:'指导价编码', Width:100, sort: true, fixed: true}
                ,{field:'clCode', title:'成本层编码', Width:100, sort: true, fixed: true}
                ,{field:'bgUnit', title:'计量单位'}
                ,{field:'bgRate', title:'单位比率'}
                ,{field:'bgQty', title:'概算数量'}
                ,{field:'bgPrice', title:'概算单价'}
                ,{field:'bgMoney', title:'概算合价'}
                ,{field:'bgInfo', title:'概算备注'}
                ,{align: 'center', toolbar: '#rowBar', title: '操作', width: 120}
            ]]
            ,parseData:function(res){ //这个函数非常实用，是2.4.0版本新增的，当后端返回的数据格式不符合layuitable需要的格式，用这个函数对返回的数据做处理，在2.4.0版本之前，只能通过修改table源码来解决这个问题
                return {//对返回数据的参数名称进行映射
                    code: res.code, //解析接口状态
                    msg: res.msg, //解析提示文本
                    count: res.count, //解析数据长度
                    data: res.data //解析数据列表
                };
            }
        });

        // 工具列点击事件
        dtable.on('tool(demoTable)', function (obj) {
            var event = obj.event;
            if (event === 'del') {
                layer.confirm('真的删除行么?', {
                    title: '删除提示'
                    ,offset: 't'
                    ,icon: 3
                }, function(index){
                    obj.del();
                    layer.close(index);
                    layer.msg('删除成功');
                });
            } else if (event === 'edit') {
                layer.prompt({
                    title: '修改提示'
                    ,offset: 't'
                }, function(value, index){
                    obj.update({ctName: value});
                    layer.close(index);
                    layer.msg('修改成功');
                });
            }
        });

        // 头部工具栏点击事件
        dtable.on('toolbar(demoTable)', function (obj) {
            switch (obj.event) {
                case 'expandAll': // 全部展开
                    table_ins.expandAll();
                    break;
                case 'foldAll': // 全部折叠
                    table_ins.foldAll();
                    break;
                case 'expandData': // 展开指定
                    table_ins.expand(2);
                    break;
                case 'foldData': // 展开指定
                    table_ins.fold(2);
                    break;
                case 'setChecked': // 设置选中
                    table_ins.expand(4);
                    table_ins.setChecked([4]);
                    break;
                case 'getChecked': // 获取选中
                    layer.alert('<pre>' + JSON.stringify(table_ins.checkStatus().map(function (d) {
                        return {
                            ctName: d.piName,
                            ctId: d.piId,
                            LAY_INDETERMINATE: d.LAY_INDETERMINATE
                        };
                    }), null, 3) + '</pre>');
                    break;
                case 'dataFilter': // 搜索
                    var keywords = $('#filterData').val();
                    if (keywords) {
                        table_ins.filterData(keywords);
                    } else {
                        table_ins.clearFilter();
                    }
                    break;
                case 'clearFilter': // 清楚搜索
                    table_ins.clearFilter();
                    break;
                case 'tableReload': // 重载
                    table_ins.reload();
                    break;
                case 'tableRefresh': // 刷新
                    table_ins.refresh();
                    break;
            }
        });
    });
</script>
</body>
</html>