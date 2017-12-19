package com.lbyx.dao;

import com.lbyx.pojo.GoodsImg;
import com.lbyx.pojo.GoodsImgQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsImgDao {
    long countByExample(GoodsImgQuery example);

    int deleteByExample(GoodsImgQuery example);

    int deleteByPrimaryKey(Integer goodsImgId);

    int insert(GoodsImg record);

    int insertSelective(GoodsImg record);

    List<GoodsImg> selectByExample(GoodsImgQuery example);

    GoodsImg selectByPrimaryKey(Integer goodsImgId);

    int updateByExampleSelective(@Param("record") GoodsImg record, @Param("example") GoodsImgQuery example);

    int updateByExample(@Param("record") GoodsImg record, @Param("example") GoodsImgQuery example);

    int updateByPrimaryKeySelective(GoodsImg record);

    int updateByPrimaryKey(GoodsImg record);

    int insertBatchSelective(List<GoodsImg> records);

    int updateBatchByPrimaryKeySelective(List<GoodsImg> records);
}