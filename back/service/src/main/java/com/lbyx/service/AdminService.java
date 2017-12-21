package com.lbyx.service;

import pojo.EasyUiDataGrid;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
public interface AdminService {

    // 获得管理员数据并且转换成 Datagrid 格式的数据，提供给 EasyUI后台使用
    EasyUiDataGrid getAdminListDataGrid(int page, int size);
}
