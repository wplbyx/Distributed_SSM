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
       href="index_top.jsp"
       style="height:100px">
  </div>

  <!-- 底部 -->
  <div data-options="region:'south'"
       style="height:50px;">
    <h3 style="color:#0099FF;text-align:center;">版权所有 LBYX</h3>
  </div>

  <!-- 右边 -->
  <div data-options="region:'east',split:true" title="工具栏"
       href="index_right.jsp"
       style="width:200px;">
  </div>

  <!-- 左边 -->
  <div data-options="region:'west',split:true" title="选择栏"
       href="index_left.jsp"
       style="width:260px;">
  </div>

  <!-- 中间 -->
  <div data-options="region:'center',title:'',iconCls:'icon-ok'"
       href="index_center.jsp"
       style="overflow:hidden">
  </div>

  <script type="text/javascript">
      $(function () {
          // menu 是左侧树形控件的事件点击：
          $('#menu').tree({
              onClick: function (node) {
                  // 判断点击的节点是否是 叶子节点，是就在 tabs 控件里添加一个页面：
                  if ($('#menu').tree("isLeaf", node.target)) {
                      var tabs = $("#tabs");
                      var tab = tabs.tabs("getTab", node.text);
                      if (tab) {
                          tabs.tabs("select", node.text);
                      } else {
                          tabs.tabs('add', {
                              title: node.text,
                              href: node.attributes.url,
                              closable: true,
                              bodyCls: "content"
                          });
                      }
                  }
              }
          });
      });
  </script>

</body>
</html>




























