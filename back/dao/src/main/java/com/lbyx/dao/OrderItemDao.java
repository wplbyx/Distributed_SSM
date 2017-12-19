package com.lbyx.dao;

import com.lbyx.pojo.OrderItem;
import com.lbyx.pojo.OrderItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemDao {
    long countByExample(OrderItemQuery example);

    int deleteByExample(OrderItemQuery example);

    int deleteByPrimaryKey(Integer orderGoodsId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemQuery example);

    OrderItem selectByPrimaryKey(Integer orderGoodsId);

    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemQuery example);

    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemQuery example);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    int insertBatchSelective(List<OrderItem> records);

    int updateBatchByPrimaryKeySelective(List<OrderItem> records);
}