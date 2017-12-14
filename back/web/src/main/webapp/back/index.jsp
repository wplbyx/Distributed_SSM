<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/14 0014
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>hello easyUI</title>

  <%-- 导入样式和图标 --%>
  <link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css"/>
  <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css"/>

  <%-- 导入基本的 js 库 --%>
  <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>

  <%-- 引入中文国际化 --%>
  <script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>


</head>

<body class="easyui-layout">

<!-- 顶部 -->
<div data-options="region:'north'"
     href="top.jsp"
     style="height:100px">
</div>

<!-- 底部 -->
<div data-options="region:'south'"
     href="bottom.jsp"
     style="height:50px;">
</div>

<!-- 右边 -->
<div data-options="region:'east',split:true" title="工具栏"
     href="right.jsp"
     style="width:200px;">
</div>

<!-- 左边 -->
<div data-options="region:'west',split:true" title="选择栏"
     href="left.jsp"
     style="width:260px;">
</div>

<!-- 中间 -->
<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'"
     href="center.jsp"
     style="overflow:hidden">
</div>

</body>
</html>




























