package com.lbyx.dao;

import com.lbyx.pojo.UserCoupon;
import com.lbyx.pojo.UserCouponQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCouponDao {
    long countByExample(UserCouponQuery example);

    int deleteByExample(UserCouponQuery example);

    int deleteByPrimaryKey(Integer couponId);

    int insert(UserCoupon record);

    int insertSelective(UserCoupon record);

    List<UserCoupon> selectByExample(UserCouponQuery example);

    UserCoupon selectByPrimaryKey(Integer couponId);

    int updateByExampleSelective(@Param("record") UserCoupon record, @Param("example") UserCouponQuery example);

    int updateByExample(@Param("record") UserCoupon record, @Param("example") UserCouponQuery example);

    int updateByPrimaryKeySelective(UserCoupon record);

    int updateByPrimaryKey(UserCoupon record);

    int insertBatchSelective(List<UserCoupon> records);

    int updateBatchByPrimaryKeySelective(List<UserCoupon> records);
}