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
  <title>easyui center</title>

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
    $(function () {
        $('#table_datagrid').datagrid({
            url: '',   // 指定后台的一个 controller地址
            fit: true,          // 自动填充父控件
            fitColumns: true,    // 水平滚动条，列少的时候用true，反之用false
            // nowrap:false,        // false: 自动换行，true: 不自动换行
            title: 'aaaaaaaa',
            iconCls: 'icon-save', // 图标
            idField: 'id',// 后台返回的数据的标识，这里的id是数据库的表的主键

            pagination: true,     // 下面的分页栏，
            pageSize: 10,         // 默认每页记录数
            pageList: [10, 15, 20], // 每页记录数

            columns: [[{
                title: '编号',
                field: 'id',
                width: 100,
                sortable: true  // 支持点击这一栏排序
            }, {
                title: '姓名',
                field: 'name',
                width: 100,
                sortable: true  // 支持点击这一栏排序
            }, {
                title: '密码',
                field: 'pwd',
                width: 100
            }
            ]]         // 表头处理, 可以合并单元格
        });
    });
</script>

<div class="easyui-tabs" border="0" fit="true">
  <div title="用户管理">
    <table id="table_datagrid" border="0">

    </table>
  </div>
</div>

</body>
</html>
