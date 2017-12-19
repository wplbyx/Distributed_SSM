package com.lbyx.dao;

import com.lbyx.pojo.GoodsType;
import com.lbyx.pojo.GoodsTypeQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeDao {
    long countByExample(GoodsTypeQuery example);

    int deleteByExample(GoodsTypeQuery example);

    int deleteByPrimaryKey(Integer goodsTypeId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    List<GoodsType> selectByExample(GoodsTypeQuery example);

    GoodsType selectByPrimaryKey(Integer goodsTypeId);

    int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeQuery example);

    int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeQuery example);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    int insertBatchSelective(List<GoodsType> records);

    int updateBatchByPrimaryKeySelective(List<GoodsType> records);
}