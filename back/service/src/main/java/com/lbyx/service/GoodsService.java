package com.lbyx.service;

import pojo.EasyUITreeNode;
import pojo.EasyUiDataGrid;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
public interface GoodsService {

    // 获得商品类目的 Service，根据类目节点的父类型 id 查询其这类目，并返回 EasyUI 需要的类型的 entity
    List<EasyUITreeNode> getEasyUiTreeNode(long id);

    // 获得商品数据并且转换成 Datagrid 格式的数据，提供给 EasyUI后台使用
    EasyUiDataGrid getGoodsListDataGrid(int page, int size);
}
