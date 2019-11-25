package com.zks.dao;

import com.zks.model.BeanNotice;

public interface BeanNoticeMapper {
    int deleteByPrimaryKey(Integer noticeid);

    int insert(BeanNotice record);

    int insertSelective(BeanNotice record);

    BeanNotice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(BeanNotice record);

    int updateByPrimaryKey(BeanNotice record);
}