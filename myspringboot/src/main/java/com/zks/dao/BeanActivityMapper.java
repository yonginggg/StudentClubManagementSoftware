package com.zks.dao;

import com.zks.model.BeanActivity;

public interface BeanActivityMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(BeanActivity record);

    int insertSelective(BeanActivity record);

    BeanActivity selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(BeanActivity record);

    int updateByPrimaryKey(BeanActivity record);
}