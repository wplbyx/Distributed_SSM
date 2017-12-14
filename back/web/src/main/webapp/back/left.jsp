<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/14 0014
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>easyui left</title>

  <%-- 导入样式和图标 --%>
  <link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css"/>
  <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css"/>

  <%-- 导入基本的 js 库 --%>
  <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>

  <%-- 引入中文国际化 --%>
  <script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>

<script type="text/javascript" charset="utf-8">

</script>


<div class="easyui-accordion" fit="true" border="0">
  <!-- 树形控件 -->
  <div title="树形控件" data-options="iconCls:'icon-search'" style="padding:10px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
      <li>
        <span>商品管理</span>
        <ul>
          <li data-options="attributes:{'url':'item-add'}">新增商品</li>
          <li data-options="attributes:{'url':'item-list'}">查询商品</li>
          <li data-options="attributes:{'url':'item-param-list'}">规格参数</li>
        </ul>
      </li>
      <li>
        <span>网站内容管理</span>
        <ul>
          <li data-options="attributes:{'url':'content-category'}">内容分类管理</li>
          <li data-options="attributes:{'url':'content'}">内容管理</li>
        </ul>
      </li>
    </ul>
  </div>

  <!-- 关于栏 -->
  <div title="关于" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
    <h3 style="color:#0099FF;">Accordion for jQuery</h3>
    <p>Accordion is a part of easyui framework for jQuery.
      It lets you define your accordion
      component on web page more easily.</p>
  </div>

  <!-- 帮助栏 -->
  <div title="帮助" data-options="iconCls:'icon-help'" style=" padding:10px;">
    <h1 style="color:#0099FF;">这是一个帮助栏</h1>
    <p> 帮助文档信息... 帮助文档信息... 帮助文档信息... 帮助文档信息... 帮助文档信息...</p>
  </div>

</div>

</body>
</html>
