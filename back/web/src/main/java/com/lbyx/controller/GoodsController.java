package com.lbyx.controller;

import com.lbyx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITreeNode;
import pojo.EasyUiDataGrid;
import pojo.GoodsAddInfo;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/20 0020.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品类目表
     * @param id 点击这个节点的主键 id，默认是为 0 ，表示是最高级的类目
     * @return 返回一个列表集合，包裹着 EasyUITreeNode 类型的数据，
     *         这个类型的数据是 Tree 控件需要的数据类型
     */
    @ResponseBody
    @RequestMapping("/type")
    public List<EasyUITreeNode> getGoodsType(@RequestParam(value="id",defaultValue="0") Integer id){
        List<EasyUITreeNode> easyUiTreeNode = goodsService.getEasyUiTreeNode(id);
        return easyUiTreeNode;
    }

    /**
     * 商品的列表查询
     * @param page 将要查询的页数
     * @param rows 每页的记录数
     * @return 返回一个自定义的 pojo 类，这个pojo类是根据 DataGrid 控件的数据类型定义的
     */
    @ResponseBody
    @RequestMapping("/list")
    public EasyUiDataGrid getGoodsList(Integer page, Integer rows){
        EasyUiDataGrid goodsListDataGrid = goodsService.getGoodsListDataGrid(page, rows);
        return goodsListDataGrid;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String goodsAdd(GoodsAddInfo goodsAddInfo){
        System.out.println("[GoodsController method]: goodsAdd()->  successful");
        return null;
    }

}
