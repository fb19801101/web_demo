<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/4/6
  Time:    22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>展开折叠侧栏导航菜单</title>
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/side/side.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/side/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/font-awesome-4.7.0/css/font-awesome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/font-awesome-4.7.0/css/font-montserrat.css">
  <script src="${pageContext.request.contextPath}/res/js/jquery-2.2.4.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/side.js"></script>
  <script language="javascript">
    function openHref(action) {
      parent.iframeRight.location.href="${pageContext.request.contextPath}/"+action;
      // parent.iframeLeft.location.href="toLeft?action="+action;
    }
  </script>
</head>

<body style="height: calc(100% - 160px)">
<h2 id="home" style="margin-top: 22px">拉动式生产 ★ 生产线</h2>
<ul class="accordionMenu">
  <li>
    <div class="dropdownItem"><i class="fa fa-sitemap" aria-hidden="true"></i> 分部分项
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
            href="#" onClick="openHref('partitem/partItemIframe?action=template')"> 分部分项模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
            href="#" onClick="openHref('partitem/insertPartItem')"> 建立分部分项</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
            href="#" onClick="openHref('partitem/searchPartItem')"> 查询分部分项</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
            href="#" onClick="openHref('partitem/partItemIframe?action=mount')"> 分部分项挂载</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-calendar" aria-hidden="true"></i> 网络计划
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('netplan/netPlanIframe?action=template')"> 网络计划模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('netplan/insertNetPlan')"> 建立网络计划</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('netplan/searchNetPlan')"> 查询网络计划</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('netplan/netPlanIframe?action=mount')"> 网络计划挂载</a></li>
      <li><a class="fa fa-exclamation-triangle" aria-hidden="true"
             href="#" onClick="openHref('netplan/warnNetPlan')"> 网络计划预警</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-calculator" aria-hidden="true"></i> 工程数量
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('quantity/quantityIframe?action=template')"> 工程数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('quantity/insertQuantity')"> 录入工程数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('quantity/searchQuantity')"> 查询工程数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('quantity/quantityIframe?action=mount')"> 工程数量挂载</a></li>
      <li><a class="fa fa-upload" aria-hidden="true"
             href="#" onClick="openHref('quantity/uploadQuantity')"> 导入工程数量</a></li>
      <li><a class="fa fa-download" aria-hidden="true"
             href="#" onClick="openHref('quantity/downloadQuantity')"> 导出工程数量</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('quantity/restoreQuantity')"> 汇入成本层</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-address-card-o" aria-hidden="true"></i> 队伍信息
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('company/companyIframe?action=template')"> 队伍模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('company/insertCompany')"> 录入队伍</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('company/searchCompany')"> 查询队伍</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('company/companyIframe?action=mount')"> 队伍挂载</a></li>
    </ul>
  </li>
</ul>

<h2 id="cover">拉动式生产 ★ 经济线</h2>
<ul class="accordionMenu">
  <li>
    <div class="dropdownItem"><i class="fa fa-table" aria-hidden="true"></i> 合同清单
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('contract/contractIframe?action=template')"> 清单模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('contract/insertContract')"> 录入清单</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('contract/searchContract')"> 查询清单</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('contract/contractIframe?action=mount')"> 清单挂载</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-list" aria-hidden="true"></i> 单项概算
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('budget/budgetIframe?action=template')"> 概算模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('budget/insertBudget')"> 录入概算</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('budget/searchBudget')"> 查询概算</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('budget/budgetIframe?action=mount')"> 概算挂载</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-road" aria-hidden="true"></i> 指导价
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('guidance/guidanceIframe?action=template')"> 指导价模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('guidance/insertGuidance')"> 录入指导价</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('guidance/searchGuidance')"> 查询指导价</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('guidance/guidanceIframe?action=mount')"> 指导价挂载</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-balance-scale" aria-hidden="true"></i> 成本层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('costlayer/costLayerIframe?action=template')"> 成本层模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('costlayer/insertCostLayer')"> 录入成本层</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('costlayer/searchCostLayer')"> 查询成本层</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('costlayer/costLayerIframe?action=mount')"> 成本层挂载</a></li>
      <li><a class="fa fa-download" aria-hidden="true"
             href="#" onClick="openHref('costlayer/downloadCostLayer')"> 导出成本层</a></li>
    </ul>
  </li>
</ul>

<h2 id="layer">拉动式生产 ★ 成本层</h2>
<ul class="accordionMenu">
  <li>
    <div class="dropdownItem"><i class="fa fa-user-md" aria-hidden="true"></i> 劳务层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('labour/labourIframe?action=template')"> 劳务数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('labour/insertLabour')"> 录入劳务数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('labour/searchLabour')"> 查询劳务数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('labour/labourIframe?action=mount')"> 劳务数量挂载</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('labour/restoreLabour')"> 汇入成本层</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-shopping-basket" aria-hidden="true"></i> 物资层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('material/materialIframe?action=template')"> 物资数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('material/insertMaterial')"> 录入物资数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('material/searchMaterial')"> 查询物资数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('material/materialIframe?action=mount')"> 物资数量挂载</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('material/restoreMaterial')"> 汇入成本层</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-train" aria-hidden="true"></i> 设备层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('equipment/equipmentIframe?action=template')"> 设备数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('equipment/insertEquipment')"> 录入设备数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('equipment/searchEquipment')"> 查询设备数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('equipment/equipmentIframe?action=mount')"> 设备数量挂载</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('equipment/restoreEquipment')"> 汇入成本层</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-building" aria-hidden="true"></i> 临建层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('temporary/temporaryIframe?action=template')"> 临建数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('temporary/insertTemporary')"> 录入临建数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('temporary/searchTemporary')"> 查询临建数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('temporary/temporaryIframe?action=mount')"> 临建数量挂载</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('temporary/restoreTemporary')"> 汇入成本层</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-tree" aria-hidden="true"></i> 征拆层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('demolition/demolitionIframe?action=template')"> 征拆数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('demolition/insertDemolition')"> 录入征拆数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('demolition/searchDemolition')"> 查询拆层数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('demolition/demolitionIframe?action=mount')"> 征拆数量挂载</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('demolition/restoreDemolition')"> 汇入成本层</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-money" aria-hidden="true"></i> 间接层
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-file-excel-o" aria-hidden="true"
             href="#" onClick="openHref('indirect/indirectIframe?action=template')"> 间接数量模板</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('indirect/insertIndirect')"> 录入间接数量</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('indirect/searchIndirect')"> 查询间接数量</a></li>
      <li><a class="fa fa-gears" aria-hidden="true"
             href="#" onClick="openHref('indirect/indirectIframe?action=mount')"> 间接数量挂载</a></li>
      <li><a class="fa fa-window-restore" aria-hidden="true"
             href="#" onClick="openHref('indirect/restoreIndirect')"> 汇入成本层</a></li>
    </ul>
  </li>
</ul>

<h2 id="test">拉动式生产 ★ 测试线</h2>
<ul id="finance" class="accordionMenu" style="display: none">
  <li>
    <div class="dropdownItem"><i class="fa fa-sitemap" aria-hidden="true"></i> 成员信息
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('member/insertMember')"> 录入成员</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('member/searchMember')"> 查询成员</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-calendar" aria-hidden="true"></i> 款项信息
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('funds/insertFunds')"> 录入款项</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('funds/searchFunds')"> 查询款项</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-calculator" aria-hidden="true"></i> 收入信息
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('income/insertIncome')"> 录入收入</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('income/searchIncome')"> 查询收入</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-address-card-o" aria-hidden="true"></i> 支出信息
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('outlay/insertOutlay')"> 录入支出</a></li>
      <li><a class="fa fa-search-plus" aria-hidden="true"
             href="#" onClick="openHref('outlay/searchOutlay')"> 查询支出</a></li>
    </ul>
  </li>
  <li>
    <div class="dropdownItem"><i class="fa fa-road" aria-hidden="true"></i> 收支报表
      <i class="fa fa-chevron-down" aria-hidden="true"></i>
    </div>
    <ul class="submenuItems">
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('finance/sumFinance')"> 收支汇总</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('finance/sumIncome')"> 收入汇总</a></li>
      <li><a class="fa fa-plus-square" aria-hidden="true"
             href="#" onClick="openHref('finance/sumOutlay')"> 支出汇总</a></li>
    </ul>
  </li>
</ul>

<div style="margin-top: 30px; margin-right: 20%;">
  <jsp:include flush="true" page="login.jsp"></jsp:include>
</div>

<script>
    $("#home,#cover,#layer").click(function(){
        parent.iframeRight.location.href='${pageContext.request.contextPath}/right/toRight';
    });

    $("#test").click(function(){
        if($('#finance').is(':hidden')) {
            $("#finance").show();
        } else {
            $("#finance").hide();
        }
    });
</script>
</body>
</html>