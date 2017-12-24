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
  <title>goods_add</title>

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

<div style="padding:10px 10px 10px 10px">
  <form id="goodsAddForm" class="goodsForm" method="post">
    <table cellpadding="5">
      <tr>
        <td>商品类目:</td>
        <td>
          <span id="type_span"></span>
          <a href="javascript:void(0)" class="easyui-linkbutton c4"
             onclick="$('#dlg').dialog('open')">选择类目</a>
          <input type="hidden" id="goodsTypeId" name="goodsTypeId" style="width: 280px;" />
        </td>
      </tr>
      <tr>
        <td>商品名称:</td>
        <td><input class="easyui-textbox" type="text" name="goodsname" data-options="required:true" style="width: 280px;"></input></td>
      </tr>
      <tr>
        <td>商品描述:</td>
        <td><input class="easyui-textbox" name="goodsdesc" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
      </tr>
      <tr>
        <td>商品价格:</td>
        <td>
          <input class="easyui-numberbox" type="text" name="goodsprice"
                 data-options="min:1,max:99999999,precision:2,required:true" />
          <%--<input type="hidden" name="goodsprice"/>--%>
        </td>
      </tr>
      <tr>
        <td>库存数量:</td>
        <td><input class="easyui-numberbox" type="text" name="goodsnumber"
                   data-options="min:1,max:99999999,precision:0,required:true" />
        </td>
      </tr>
      <tr>
        <td>供货商:</td>
        <td>
          <input class="easyui-textbox" type="text" name="provider"
                 data-options="validType:'length[1,30]'" />
        </td>
      </tr>
      <tr>
        <td>商品图片:</td>
        <td>
          <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
          <input type="hidden" name="image"/>
        </td>
      </tr>
      <tr>
        <td>商品描述:</td>
        <td>
          <%-- 富文本编辑器 --%>
          <textarea style="width:800px;height:300px;visibility:hidden;" id="desc" name="desc"></textarea>
        </td>
      </tr>
      <tr>
        <td>商品价值积分:</td>
        <td>
          <input class="easyui-textbox" type="text" name="givepoints"/>
        </td>
      </tr>
    </table>
    <input type="hidden" name="itemParams"/>
  </form>
  <div style="padding:20px 0 20px 0">
    <a href="javascript:void(0)" class="easyui-linkbutton c1"
       onclick="submitForm()" style="width:100px;">
      提 交
    </a>
    <a href="javascript:void(0)" class="easyui-linkbutton c2"
       onclick="clearForm()" style="width:100px;">
      重 置
    </a>
  </div>

  <div id="dlg" class="easyui-dialog" title="商品类目选择"
       style="width:400px;height:360px;"
       data-options="closed:true" >
    <ul id="async-tree" class="easyui-tree" url="/goods/type" lines="true" ></ul>
  </div>

</div>

<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
        src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript">
    var goodsAddEditor ;
    //页面初始化完毕后执行此方法
    $(function(){
        //创建富文本编辑器
        // itemAddEditor = KindEditor.create("#itemAddForm [name=desc]");
        goodsAddEditor = KindEditor.create('textarea[name="desc"]');

    });

    $("#dlg").dialog({
        modal:true,
        iconCls:'icon-save',
        // 当对话框打开的时候 初始化数据：
        onOpen:function(){
            var _dlg = this;
            $("#async-tree").tree({
                onClick:function (node) {
                    if ($(this).tree("isLeaf", node.target)){

                        $("#goodsTypeId").val(node.id);
                        $("#type_span").html(node.text);

                        $("#dlg").dialog('close');
                    }
                }
            });
        }
    });

    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#goodsAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        // 同步文本框中的商品描述
        goodsAddEditor.sync();
//        // 取商品的规格
//        var paramJson = [];
//        $("#itemAddForm .params li").each(function(i,e){
//            var trs = $(e).find("tr");
//            var group = trs.eq(0).text();
//            var ps = [];
//            for(var i = 1;i<trs.length;i++){
//                var tr = trs.eq(i);
//                ps.push({
//                    "k" : $.trim(tr.find("td").eq(0).find("span").text()),
//                    "v" : $.trim(tr.find("input").val())
//                });
//            }
//            paramJson.push({
//                "group" : group,
//                "params": ps
//            });
//        });
//        //把json对象转换成字符串
//        paramJson = JSON.stringify(paramJson);
//        $("#itemAddForm [name=itemParams]").val(paramJson);

        // ajax的post方式提交表单
        // $("#goodsAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/goods/add",$("#goodsAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增商品成功!');
            }
        });
    }

    // 清空 form 表单里的数据内容
    function clearForm(){
        $('#type_span').html('');
        $('#goodsAddForm').form('reset');
        goodsAddEditor.html('');
    }
</script>

</body>
</html>
