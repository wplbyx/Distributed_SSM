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

import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
public class GoodsServiceTest extends BaseSpringJunit4Test {

    @Autowired
    private GoodsDao goodsDao;


    @Test
    public void PageTest(){
        GoodsQuery goodsQuery = new GoodsQuery();
        PageHelper.startPage(1, 10);
        List<Goods> goodss = goodsDao.selectByExample(goodsQuery);
        for (Goods goods : goodss) {
            System.out.println(goods);
        }
    }


}






























