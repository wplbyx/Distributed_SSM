package com.lbyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Created by Administrator on 2017/12/13 0013.
 */
@Controller
@RequestMapping("/back")
public class BackController {

    /**
     * 跳转到后台首页，返回一个逻辑视图
     * @return
     */
    @RequestMapping("/index")
    public String jumpToBackIndex(){
        return "index";
    }
}
