package com.lbyx.controller;

import com.lbyx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITreeNode;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/20 0020.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/type")
    public List<EasyUITreeNode> getGoodsType(@RequestParam(value="id",defaultValue="0") Integer id){
        List<EasyUITreeNode> easyUiTreeNode = goodsService.getEasyUiTreeNode(id);
        return easyUiTreeNode;
    }

}
