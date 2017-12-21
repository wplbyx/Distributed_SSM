<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/16 0016
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>user_list</title>
</head>
<body>
<table class="easyui-datagrid" id="userList"
       url="/user/list"
       rownumbers="true" fitColumns="true" singleSelect="true">
  <thead>
  <tr>
    <th data-options="field:'ck',checkbox:true"></th>
    <th data-options="field:'userId',align:'center'">用户ID</th>
    <th data-options="field:'username',align:'center'">用户名</th>
    <th data-options="field:'sex',align:'center'">性别</th>
    <th data-options="field:'birthday',align:'center'">出生日期</th>
    <th data-options="field:'phone',align:'center'">电话</th>
    <th data-options="field:'qq',align:'center'">QQ号</th>
    <th data-options="field:'email',align:'center'">电子邮箱</th>
    <th data-options="field:'points',align:'center'">拥有积分</th>
  </tr>
  </thead>
</table>


<div id="itemEditWindow" class="easyui-window" title="用户编辑"
     data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'"
     style="width:80%;height:80%;padding:10px;">
</div>

<script type="text/javascript">

    $(function () {
        $('#userList').datagrid({
//            url: '/user/list',   // 指定后台的一个 controller地址
            fit:true,
            method:'get',
            pagination: true,     // 下面的分页栏，
            pageSize: 3,         // 默认每页记录数
            pageList: [3, 4, 5, 10] // 每页记录数

        });
    });





</script>

</body>
</html>
