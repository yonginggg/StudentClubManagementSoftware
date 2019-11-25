package com.zks.dao;

import com.zks.model.BeanReplaytPost;

public interface BeanReplaytPostMapper {
    int deleteByPrimaryKey(Integer replaypostid);

    int insert(BeanReplaytPost record);

    int insertSelective(BeanReplaytPost record);

    BeanReplaytPost selectByPrimaryKey(Integer replaypostid);

    int updateByPrimaryKeySelective(BeanReplaytPost record);

    int updateByPrimaryKey(BeanReplaytPost record);
}