package com.lbyx.dao;

import com.lbyx.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    long countByExample(AdminQuery example);

    int deleteByExample(AdminQuery example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminQuery example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminQuery example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminQuery example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int insertBatchSelective(List<Admin> records);

    int updateBatchByPrimaryKeySelective(List<Admin> records);
}