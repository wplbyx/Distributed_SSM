package com.lbyx.service.impl;

import com.lbyx.dao.AdminDao;
import com.lbyx.pojo.Admin;
import com.lbyx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Created by Administrator on 2017/12/12 0012.
 */
@Service
public class ItemServiceImpl implements ItemService {

    // 需要 Dao 接口的实例，就要注入进来
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminById(int id) {
        Admin admin = adminDao.selectByPrimaryKey(id);
        return admin;
    }
}
