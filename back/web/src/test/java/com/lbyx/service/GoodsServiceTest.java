package com.lbyx.service;

import com.github.pagehelper.PageHelper;
import com.lbyx.BaseSpringJunit4Test;
import com.lbyx.dao.GoodsDao;
import com.lbyx.dao.UserDao;
import com.lbyx.pojo.Goods;
import com.lbyx.pojo.GoodsQuery;
import com.lbyx.pojo.User;
import com.lbyx.pojo.UserQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.GoodsAddInfo;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
public class GoodsServiceTest extends BaseSpringJunit4Test {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void testGoodsAdd(){
        GoodsAddInfo goodsAddInfo = new GoodsAddInfo();
        goodsAddInfo.setDesc("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        goodsAddInfo.setGoodsTypeId(178); // 键盘 三级类目
        goodsAddInfo.setGoodsname("ffffff");
        goodsAddInfo.setGoodsdesc("fffffffffffffffffffffffff");
        goodsAddInfo.setGoodsprice(100.0f);
        goodsAddInfo.setProvider("f");

        // 调用测试类：
        goodsService.AddGoods(goodsAddInfo);


    }


}






























