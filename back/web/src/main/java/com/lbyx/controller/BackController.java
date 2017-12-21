package com.lbyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Created by Administrator on 2017/12/13 0013.
 */
@Controller
@RequestMapping("/back")
public class BackController {

    @RequestMapping("/login")
    public String loginBack(){
        return "backLogin";
    }

    /**
     * 进入后台首页的 Handler
     * @return "index" 一个逻辑视图
     */
    @RequestMapping("/index_main")
    public String jumpToBackIndex(){
        return "index_main";
    }

    /**
     * 后台页面跳转的 Handler
     * @param path： 传入页面的逻辑视图
     * @return "path" 一个逻辑视图
     */
    @RequestMapping("/{path}")
    public String showPage(@PathVariable String path){
        return path;
    }






}






















