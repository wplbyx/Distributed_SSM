package com.lbyx.dao;

import com.lbyx.pojo.CarItem;
import com.lbyx.pojo.CarItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarItemDao {
    long countByExample(CarItemQuery example);

    int deleteByExample(CarItemQuery example);

    int deleteByPrimaryKey(Integer carItemId);

    int insert(CarItem record);

    int insertSelective(CarItem record);

    List<CarItem> selectByExample(CarItemQuery example);

    CarItem selectByPrimaryKey(Integer carItemId);

    int updateByExampleSelective(@Param("record") CarItem record, @Param("example") CarItemQuery example);

    int updateByExample(@Param("record") CarItem record, @Param("example") CarItemQuery example);

    int updateByPrimaryKeySelective(CarItem record);

    int updateByPrimaryKey(CarItem record);

    int insertBatchSelective(List<CarItem> records);

    int updateBatchByPrimaryKeySelective(List<CarItem> records);
}