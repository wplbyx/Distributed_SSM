package com.lbyx.dao;

import com.lbyx.pojo.Car;
import com.lbyx.pojo.CarQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarDao {
    long countByExample(CarQuery example);

    int deleteByExample(CarQuery example);

    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarQuery example);

    Car selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarQuery example);

    int updateByExample(@Param("record") Car record, @Param("example") CarQuery example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    int insertBatchSelective(List<Car> records);

    int updateBatchByPrimaryKeySelective(List<Car> records);
}