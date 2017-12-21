package com.lbyx.controller;

import com.lbyx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUiDataGrid;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/admin/list")
    public EasyUiDataGrid getAdminList(Integer page, Integer pageSize){
        return adminService.getAdminListDataGrid(page, pageSize);
    }


























}

