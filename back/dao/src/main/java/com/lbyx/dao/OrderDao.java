package com.lbyx.dao;

import com.lbyx.pojo.Order;
import com.lbyx.pojo.OrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    long countByExample(OrderQuery example);

    int deleteByExample(OrderQuery example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderQuery example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderQuery example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderQuery example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int insertBatchSelective(List<Order> records);

    int updateBatchByPrimaryKeySelective(List<Order> records);
}