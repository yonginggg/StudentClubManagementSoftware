package com.zks.dao;

import com.zks.model.BeanLog;

public interface BeanLogMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(BeanLog record);

    int insertSelective(BeanLog record);

    BeanLog selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(BeanLog record);

    int updateByPrimaryKey(BeanLog record);
}