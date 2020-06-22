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
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>主页面</title>
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/layui/css/layui.css" media="all">
  <script type="text/javascript" Charset="UTF-8" src="${pageContext.request.contextPath}/res/js/layui/layui.js"></script>
</head>

<body style="height: calc(100% - 225px)">
<div class="layui-carousel" id="demoCarousel" lay-filter="testCarousel"  style="overflow: hidden; position: relative; left: 50%; width: 1280px; height: 720px; margin-top: 20px; margin-left: -640px">
  <div carousel-item="" id="demoPicture">
    <c:forEach items="${message['list']}" var="pic">
        <div><img src="${pageContext.request.contextPath}/res/img/right/${pic}"></div>
    </c:forEach>
  </div>
</div>

<fieldset class="layui-elem-field" style="position: relative; left: 50%; width: 1280px; margin-top: 20px; margin-left: -640px">
  <legend style="font-size: 16px;">轮播设置</legend>
  <div class="layui-field-box">
    <div class="layui-form">
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">宽高</label>
          <div class="layui-input-inline" style="width: 80px;">
            <input type="tel" name="width" value="1280" autocomplete="off" placeholder="width" class="layui-input demoSet">
          </div>
          <div class="layui-input-inline" style="width: 80px;">
            <input type="tel" name="height" value="720" autocomplete="off" placeholder="height" class="layui-input demoSet">
          </div>
        </div>
        <div class="layui-inline">
          <label class="layui-form-label">自动切换</label>
          <div class="layui-input-block">
            <input type="checkbox" name="switch" lay-skin="switch" checked="" lay-text="ON|OFF" lay-filter="autoplay">
          </div>
        </div>
        <div class="layui-inline">
          <label class="layui-form-label" style="width: auto;">时间间隔</label>
          <div class="layui-input-inline" style="width: 80px;">
            <input type="tel" name="interval" value="2000" autocomplete="off" placeholder="毫秒" class="layui-input demoSet">
          </div>
        </div>
        <div class="layui-inline">
          <label class="layui-form-label" style="width: auto;">索引名称</label>
          <div class="layui-input-inline" style="width: 40px;">
            <input type="text" id="picIndex" name="picIndex" lay-verify="required" value="0" autocomplete="off" class="layui-input">
          </div>
          <div class="layui-input-inline" style="width: 150px;">
            <input type="text" id="picName" name="picName" lay-verify="required" value="bim.png" autocomplete="off" class="layui-input">
          </div>
        </div>
      </div>

      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">动画</label>
          <div class="layui-input-block">
            <div class="layui-btn-group demoTest" style="margin-top: 5px;">
              <button class="layui-btn layui-btn-sm" style="background-color: #5FB878;" data-type="set" data-key="anim" data-value="default">左右切换</button>
              <button class="layui-btn layui-btn-sm" data-type="set" data-key="anim" data-value="updown">上下切换</button>
              <button class="layui-btn layui-btn-sm" data-type="set" data-key="anim" data-value="fade">渐隐渐显</button>
            </div>
          </div>
        </div>
        <div class="layui-inline">
          <label class="layui-form-label">箭头</label>
          <div class="layui-input-block">
            <div class="layui-btn-group demoTest" style="margin-top: 5px;">
              <button class="layui-btn layui-btn-sm" style="background-color: #5FB878;" data-type="set" data-key="arrow" data-value="hover">悬停显示</button>
              <button class="layui-btn layui-btn-sm" data-type="set" data-key="arrow" data-value="always">始终显示</button>
              <button class="layui-btn layui-btn-sm" data-type="set" data-key="arrow" data-value="none">不显示</button>
            </div>
          </div>
        </div>
        <div class="layui-inline">
          <label class="layui-form-label">指示器</label>
          <div class="layui-input-block">
            <div class="layui-btn-group demoTest" style="margin-top: 5px;">
              <button class="layui-btn layui-btn-sm" style="background-color: #5FB878;" data-key="indicator" data-type="set" data-value="inside">容器内部</button>
              <button class="layui-btn layui-btn-sm" data-type="set" data-key="indicator" data-value="outside">容器外部</button>
              <button class="layui-btn layui-btn-sm" data-type="set" data-key="indicator" data-value="none">不显示</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</fieldset>

<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form
            ,$ = layui.$
            ,layer = layui.layer;

        //设定各种参数
        var Carousel = carousel.render({
            elem: '#demoCarousel'
            ,width: '1280'
            ,height: '720'
            ,interval: 2000
            ,autoplay: true
        });

        var list = []; //new Array();
        <c:forEach items="${message['list']}" var="pic" varStatus="status">
            list.push("${pic}");
        </c:forEach>

        //事件
        carousel.on('change(testCarousel)', function(res){
            console.log(res);
            $("#picIndex").val(res.index);
            $("#picName").val(list[res.index]);
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                Carousel.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            Carousel.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            Carousel.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>
</body>
</html>