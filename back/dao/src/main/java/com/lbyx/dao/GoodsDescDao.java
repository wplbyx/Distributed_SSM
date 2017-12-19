package com.lbyx.dao;

import com.lbyx.pojo.GoodsDesc;
import com.lbyx.pojo.GoodsDescQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDescDao {
    long countByExample(GoodsDescQuery example);

    int deleteByExample(GoodsDescQuery example);

    int deleteByPrimaryKey(Integer goodsDescId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    List<GoodsDesc> selectByExampleWithBLOBs(GoodsDescQuery example);

    List<GoodsDesc> selectByExample(GoodsDescQuery example);

    GoodsDesc selectByPrimaryKey(Integer goodsDescId);

    int updateByExampleSelective(@Param("record") GoodsDesc record, @Param("example") GoodsDescQuery example);

    int updateByExampleWithBLOBs(@Param("record") GoodsDesc record, @Param("example") GoodsDescQuery example);

    int updateByExample(@Param("record") GoodsDesc record, @Param("example") GoodsDescQuery example);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKeyWithBLOBs(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);

    int insertBatchSelective(List<GoodsDesc> records);

    int updateBatchByPrimaryKeySelective(List<GoodsDesc> records);
}