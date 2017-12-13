package com.lbyx.controller;

import com.lbyx.pojo.Admin;
import com.lbyx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  Created by Administrator on 2017/12/12 0012.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("item/{id}")
    @ResponseBody
    public Admin getItemById(@PathVariable int id){
        Admin adminById = itemService.getAdminById(id);
        return adminById;
    }

}
























