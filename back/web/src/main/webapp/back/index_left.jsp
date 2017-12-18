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
    $(function(){
        $('#menu').tree({
            // 给树形控件添加 点击事件
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    var tabs = $("#tabs");
                    var tab = tabs.tabs("getTab",node.text);
                    if(tab){
                        tabs.tabs("select",node.text);
                    }else{
                        tabs.tabs('add',{
                            title:node.text,
                            href: node.attributes.url,
                            closable:true
//                            bodyCls:"content"
                        });
                    }
                }
            }
        });
    });

    //
    function onClickBtn(objct) {
        var tabs = $("#tabs");
        var tab = tabs.tabs("getTab",objct.text);
        if(tab){
            tabs.tabs("select",objct.text);
        }else{
            tabs.tabs('add',{
                title:objct.text,
                href: objct.attributes.url,
                closable:true,
                bodyCls:"content"
            });
        }
    }

</script>


<div class="easyui-accordion" fit="true" border="0">
  <!-- 树形控件 -->
  <div title="菜单" data-options="iconCls:'icon-search'" style="padding:10px;">

    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
      <li>
        <span>用户管理</span>
        <ul>
          <li data-options="attributes:{'url':'staff_add'}">用户列表</li>
        </ul>
      </li>
      <li>
        <span>商品管理</span>
        <ul>
          <li data-options="attributes:{'url':'goods_add'}">添加商品</li>
          <li data-options="attributes:{'url':'goods_list'}">商品列表</li>
        </ul>
      </li>
      <li>
        <span>订单管理</span>
        <ul>
          <li data-options="attributes:{'url':'order_buy'}">采购订单</li>
          <li data-options="attributes:{'url':'order_sale'}">销售订单</li>
          <li data-options="attributes:{'url':'order_back'}">退货订单</li>
        </ul>
      </li>
      <li>
        <span>优惠券管理</span>
        <ul>
          <li data-options="attributes:{'url':'order_add'}">添加优惠券</li>
          <li data-options="attributes:{'url':'order_sale'}">优惠券列表</li>
        </ul>
      </li>
    </ul>

  </div>

  <div title="员工管理" style="overflow:auto;padding:0 0 0 20px;">
    <%--<ul>--%>
      <%--<li data-options="attributes:{'url':''}">添加员工</li>--%>
      <%--<li data-options="attributes:{'url':''}">员工列表</li>--%>
    <%--</ul>--%>
    <a href="javascript:;"
       class="easyui-linkbutton"
       data-options="attributes:{'url':'staff_add'}"
       onclick="onClickBtn(this)">
      添加员工
    </a>
    <a href="javascript:;"
       class="easyui-linkbutton"
       data-options="attributes:{'url':'staff_list'}"
       onclick="onClickBtn(this)">
      员工列表
    </a>

  </div>

  <div title="商品管理" style="overflow:auto;padding:0 0 0 20px;">
    <ul>
      <li data-options="attributes:{'url':''}">添加商品</li>
      <li data-options="attributes:{'url':''}">商品列表</li>
    </ul>
  </div>

  <div title="订单管理" style="overflow:auto;padding:0 0 0 20px;">
    <ul>
      <li data-options="attributes:{'url':''}">采购订单</li>
      <li data-options="attributes:{'url':''}">销售订单</li>
      <li data-options="attributes:{'url':''}">退货订单</li>
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
