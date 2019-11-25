package com.zks.dao;

import com.zks.model.BeanCollectPost;

public interface BeanCollectPostMapper {
    int deleteByPrimaryKey(Integer collectpostid);

    int insert(BeanCollectPost record);

    int insertSelective(BeanCollectPost record);

    BeanCollectPost selectByPrimaryKey(Integer collectpostid);

    int updateByPrimaryKeySelective(BeanCollectPost record);

    int updateByPrimaryKey(BeanCollectPost record);
}