package com.lbyx.dao;

import com.lbyx.pojo.UserAddress;
import com.lbyx.pojo.UserAddressQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAddressDao {
    long countByExample(UserAddressQuery example);

    int deleteByExample(UserAddressQuery example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressQuery example);

    UserAddress selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressQuery example);

    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressQuery example);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    int insertBatchSelective(List<UserAddress> records);

    int updateBatchByPrimaryKeySelective(List<UserAddress> records);
}