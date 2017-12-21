package com.lbyx.controller;

import com.lbyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUiDataGrid;

import javax.servlet.http.HttpServletRequest;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/list")
    public EasyUiDataGrid getUserListDataGrid(Integer page, Integer rows){
        EasyUiDataGrid userListDataGrid = userService.getUserListDataGrid(page, rows);
        return userListDataGrid;
    }

























}
