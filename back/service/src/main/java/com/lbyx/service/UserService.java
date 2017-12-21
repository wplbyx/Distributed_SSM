package com.lbyx.service;

import pojo.EasyUiDataGrid;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
public interface UserService {

    // 获得用户数据并且转换成 Datagrid 格式的数据，提供给 EasyUI后台使用
    EasyUiDataGrid getUserListDataGrid(int page, int size);
}
