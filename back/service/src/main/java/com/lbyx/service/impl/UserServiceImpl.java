package com.lbyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbyx.dao.UserDao;
import com.lbyx.pojo.User;
import com.lbyx.pojo.UserQuery;
import com.lbyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUiDataGrid;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public EasyUiDataGrid getUserListDataGrid(int page, int size) {
        UserQuery userQuery = new UserQuery();
        PageHelper.startPage(page, size);
        List<User> users = userDao.selectByExample(userQuery);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        EasyUiDataGrid easyUiDataGrid = new EasyUiDataGrid();
        easyUiDataGrid.setTotal(userPageInfo.getTotal());
        easyUiDataGrid.setRows(users);
        return easyUiDataGrid;
    }
}
