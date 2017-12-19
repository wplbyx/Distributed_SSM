package com.lbyx.dao;

import com.lbyx.pojo.Comment;
import com.lbyx.pojo.CommentQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    long countByExample(CommentQuery example);

    int deleteByExample(CommentQuery example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentQuery example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    int insertBatchSelective(List<Comment> records);

    int updateBatchByPrimaryKeySelective(List<Comment> records);
}