package com.lbyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbyx.dao.GoodsDao;
import com.lbyx.dao.GoodsTypeDao;
import com.lbyx.pojo.Goods;
import com.lbyx.pojo.GoodsQuery;
import com.lbyx.pojo.GoodsType;
import com.lbyx.pojo.GoodsTypeQuery;
import com.lbyx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITreeNode;
import pojo.EasyUiDataGrid;
import pojo.GoodsAddInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao; // 商品信息dao
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<EasyUITreeNode> getEasyUiTreeNode(long id) {
        // 创建查询条件：
        GoodsTypeQuery goodsTypeQuery = new GoodsTypeQuery();
        GoodsTypeQuery.Criteria criteria = goodsTypeQuery.createCriteria();
        criteria.andFatherTypeIdEqualTo(new Long(id).intValue());

        // 执行查询条件：
        List<GoodsType> goodsTypes = goodsTypeDao.selectByExample(goodsTypeQuery);

        // 将查询结果 包装成 EasyUITreeNode 类型的数据：
        ArrayList<EasyUITreeNode> listTreeNodes = new ArrayList<>();
        for (GoodsType goodsType : goodsTypes) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(goodsType.getGoodsTypeId().longValue());
            easyUITreeNode.setText(goodsType.getTypename().toString());
            easyUITreeNode.setState(goodsType.getIsleaf()?"open":"closed");
            listTreeNodes.add(easyUITreeNode);
        }
        return listTreeNodes;
    }

    @Override
    public EasyUiDataGrid getGoodsListDataGrid(int page, int size){
        GoodsQuery goodsQuery = new GoodsQuery();
        PageHelper.startPage(page, size);
        List<Goods> goodss = goodsDao.selectByExample(goodsQuery);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodss);
        EasyUiDataGrid easyUiDataGrid = new EasyUiDataGrid();
        easyUiDataGrid.setTotal(goodsPageInfo.getTotal());
        easyUiDataGrid.setRows(goodss);
        return easyUiDataGrid;
    }


    @Override
    public Goods goodsAddInfoToGoods(GoodsAddInfo goodsAddInfo){
        Goods goods = new Goods();
        goods.setGoodsTypeId(goodsAddInfo.getGoodsTypeId());
        goods.setGoodsname(goodsAddInfo.getGoodsname());
        goods.setGoodsdesc(goodsAddInfo.getGoodsdesc());
        goods.setGoodsprice(goodsAddInfo.getGoodsprice());
        goods.setGoodsnumber(goodsAddInfo.getGoodsnumber());
        goods.setProvider(goodsAddInfo.getProvider());
        goods.setOntime(goodsAddInfo.getOntime());
        goods.setOfftime(goodsAddInfo.getOfftime());
        goods.setStatus(goodsAddInfo.getStatus());
        goods.setGivepoints(goodsAddInfo.getGivepoints());
        return goods;
    }
}
