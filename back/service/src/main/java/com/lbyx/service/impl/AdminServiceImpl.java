package com.lbyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbyx.dao.AdminDao;
import com.lbyx.pojo.Admin;
import com.lbyx.pojo.AdminQuery;
import com.lbyx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUiDataGrid;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public EasyUiDataGrid getAdminListDataGrid(int page, int size) {
        AdminQuery adminQuery = new AdminQuery();
        PageHelper.startPage(page, size);
        List<Admin> admins = adminDao.selectByExample(adminQuery);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        EasyUiDataGrid easyUiDataGrid = new EasyUiDataGrid();
        easyUiDataGrid.setTotal(adminPageInfo.getTotal());
        easyUiDataGrid.setRows(admins);
        return easyUiDataGrid;
    }
}
