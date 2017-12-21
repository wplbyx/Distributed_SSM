<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/14 0014
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>goods_list</title>

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

<table class="easyui-datagrid" id="itemList" >
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'goodsId',width:60">商品ID</th>
      <th data-options="field:'goodsname',width:200">商品名称</th>
      <th data-options="field:'goodsTypeId',width:100">商品分类</th>
      <th data-options="field:'goodsdesc',width:100">简单描述</th>
      <th data-options="field:'goodsprice',width:70,align:'right'">价格</th>
      <th data-options="field:'goodsnumber',width:70,align:'right'">库存数量</th>
      <th data-options="field:'provider',width:100">生产厂家</th>
      <th data-options="field:'status',width:60,align:'center'">状态</th>
      <th data-options="field:'givepoints',width:60,align:'center'">积分值</th>
      <th data-options="field:'onTime',width:130,align:'center'">创建日期</th>
      <th data-options="field:'offTime',width:130,align:'center'">更新日期</th>
    </tr>
  </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品"
     data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'"
     style="width:80%;height:80%;padding:10px;">
</div>
<script>



    function getSelectionsIds() {
        var itemList = $("#itemList");
        var sels = itemList.datagrid("getSelections");
        var ids = [];
        for (var i in sels) {
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }


    $(function () {

    var toolbar = [{
        text: '新增',
        iconCls: 'icon-add',
        handler: function () {
            $(".tree-title:contains('新增商品')").parent().click();
        }
    }, {
        text: '编辑',
        iconCls: 'icon-edit',
        handler: function () {
            var ids = getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert('提示', '必须选择一个商品才能编辑!');
                return;
            }
            if (ids.indexOf(',') > 0) {
                $.messager.alert('提示', '只能选择一个商品!');
                return;
            }

            $("#itemEditWindow").window({
                onLoad: function () {
                    //回显数据
                    var data = $("#itemList").datagrid("getSelections")[0];
                    data.priceView = TAOTAO.formatPrice(data.price);
                    $("#itemeEditForm").form("load", data);

                    // 加载商品描述
                    $.getJSON('/rest/item/query/item/desc/' + data.id, function (_data) {
                        if (_data.status == 200) {
                            //UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
                            itemEditEditor.html(_data.data.itemDesc);
                        }
                    });

                    //加载商品规格
                    $.getJSON('/rest/item/param/item/query/' + data.id, function (_data) {
                        if (_data && _data.status == 200 && _data.data && _data.data.paramData) {
                            $("#itemeEditForm .params").show();
                            $("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
                            $("#itemeEditForm [name=itemParamId]").val(_data.data.id);

                            //回显商品规格
                            var paramData = JSON.parse(_data.data.paramData);

                            var html = "<ul>";
                            for (var i in paramData) {
                                var pd = paramData[i];
                                html += "<li><table>";
                                html += "<tr><td colspan=\"2\" class=\"group\">" + pd.group + "</td></tr>";

                                for (var j in pd.params) {
                                    var ps = pd.params[j];
                                    html += "<tr><td class=\"param\"><span>" + ps.k + "</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='" + ps.v + "'/></td></tr>";
                                }

                                html += "</li></table>";
                            }
                            html += "</ul>";
                            $("#itemeEditForm .params td").eq(1).html(html);
                        }
                    });

                    TAOTAO.init({
                        "pics": data.image,
                        "cid": data.cid,
                        fun: function (node) {
                            TAOTAO.changeItemParam(node, "itemeEditForm");
                        }
                    });
                }
            }).window("open");
        }
    }, {
        text: '删除',
        iconCls: 'icon-cancel',
        handler: function () {
            var ids = getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert('提示', '未选中商品!');
                return;
            }
            $.messager.confirm('确认', '确定删除ID为 ' + ids + ' 的商品吗？', function (r) {
                if (r) {
                    var params = {"ids": ids};
                    $.post("/rest/item/delete", params, function (data) {
                        if (data.status == 200) {
                            $.messager.alert('提示', '删除商品成功!', undefined, function () {
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }, '-', {
        text: '下架',
        iconCls: 'icon-remove',
        handler: function () {
            var ids = getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert('提示', '未选中商品!');
                return;
            }
            $.messager.confirm('确认', '确定下架ID为 ' + ids + ' 的商品吗？', function (r) {
                if (r) {
                    var params = {"ids": ids};
                    $.post("/rest/item/instock", params, function (data) {
                        if (data.status == 200) {
                            $.messager.alert('提示', '下架商品成功!', undefined, function () {
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }, {
        text: '上架',
        iconCls: 'icon-remove',
        handler: function () {
            var ids = getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert('提示', '未选中商品!');
                return;
            }
            $.messager.confirm('确认', '确定上架ID为 ' + ids + ' 的商品吗？', function (r) {
                if (r) {
                    var params = {"ids": ids};
                    $.post("/rest/item/reshelf", params, function (data) {
                        if (data.status == 200) {
                            $.messager.alert('提示', '上架商品成功!', undefined, function () {
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];

//    $(function () {
        $('#itemList').datagrid({
            url: '',   // 指定后台的一个 controller地址
            fit: true,          // 自动填充父控件
            toolbar:toolbar,
            method:'get',
            fitColumns: true,    // 水平滚动条，列少的时候用true，反之用false
            // nowrap:false,        // false: 自动换行，true: 不自动换行
            idField: 'id', // 后台返回的数据的标识，这里的id是数据库的表的主键
            collapsible:true,
            singleSelect:false,
            pagination: true,     // 下面的分页栏，
            pageSize: 10,         // 默认每页记录数
            pageList: [10, 15, 20], // 每页记录数

        });
    });

</script>

</body>
</html>
