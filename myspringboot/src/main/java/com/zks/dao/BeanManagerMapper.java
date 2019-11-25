package com.zks.dao;

import com.zks.model.BeanManager;

public interface BeanManagerMapper {
    int deleteByPrimaryKey(String managerid);

    int insert(BeanManager record);

    int insertSelective(BeanManager record);

    BeanManager selectByPrimaryKey(String managerid);

    int updateByPrimaryKeySelective(BeanManager record);

    int updateByPrimaryKey(BeanManager record);
}