package com.lbyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbyx.dao.GoodsDao;
import com.lbyx.dao.GoodsDescDao;
import com.lbyx.dao.GoodsTypeDao;
import com.lbyx.pojo.*;
import com.lbyx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.EasyUITreeNode;
import pojo.EasyUiDataGrid;
import pojo.GoodsAddInfo;
import util.DateUtil;

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
    @Autowired
    private GoodsDescDao goodsDescDao;

    /**
     * 商品类目的查询方法，根据商品类目的主键查询商品类目，在数据库里有 三级类目
     * 库表里有一条 字段：记录着父类目的主键id，因此 id 就做为查询条件
     * @param id 查询这个id下有多少个子类目，父类目的主键id
     * @return  返回查询到的结果集
     */
    @Override
    @Transactional(readOnly = true)
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

    /**
     * 商品信息查询方法，只读的事务是为了提高 数据库的性能
     * @param page 待查询的页数
     * @param size 每页需要的记录数
     * @return
     */
    @Override
    @Transactional(readOnly = true)
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

    /**
     * 发生任何一个异常，事务都统一回滚，保证数据的一致性！
     * @param goodsAddInfo 控制器接收到后台前端传来的数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void AddGoods(GoodsAddInfo goodsAddInfo) {
        Goods goods = goodsAddInfoToGoods(goodsAddInfo);
        int insert = goodsDao.insert(goods);
        // System.out.println("the return num of mathord insert is "+ insert);

        // 创建查询条件对象：
        GoodsQuery goodsQuery = new GoodsQuery();
        GoodsQuery.Criteria criteria = goodsQuery.createCriteria();

        // 添加查询条件：
        criteria.andGoodsTypeIdEqualTo(goods.getGoodsTypeId());
        criteria.andGoodsdescEqualTo(goods.getGoodsdesc());
        criteria.andGoodsnameEqualTo(goods.getGoodsname());
        criteria.andGoodspriceEqualTo(goods.getGoodsprice());

        // 执行查询条件：得到刚插入的记录的主键
        List<Goods> goodss = goodsDao.selectByExample(goodsQuery);

        Integer newId = goodss.get(0).getGoodsId();

        GoodsDesc goodsDesc = new GoodsDesc();
        goodsDesc.setGoodsdesc(goodsAddInfo.getGoodsdesc());
        goodsDesc.setGoodsId(newId);
        goodsDesc.setUploadtime(DateUtil.getNowDate());
        goodsDescDao.insert(goodsDesc);

        // 事务的测试：手动抛出一个异常测试数据库插入的结果：
        //  抛出 RuntimeException 异常，触发事物，回滚
        //throw new RuntimeException("test");

    }




    /**
     * 这个类实际上是一个工具类，但是放到 util 包里有点鸡肋，所以就放到了 Service 层里
     * 将 GoodsAddInfo 实体类对象转换成 Goods 实体类对象(Mybatis逆向生成的对象)，
     * 目的是为了兼容 Mybatis工程创建的类对象
     *
     * @param goodsAddInfo 带转换的实体类对象
     * @return Goods 实体类对象
     */
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
