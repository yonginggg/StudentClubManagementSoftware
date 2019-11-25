package com.zks.dao;

import com.zks.model.BeanRecruitNotice;

public interface BeanRecruitNoticeMapper {
    int deleteByPrimaryKey(Integer recruitnoticeid);

    int insert(BeanRecruitNotice record);

    int insertSelective(BeanRecruitNotice record);

    BeanRecruitNotice selectByPrimaryKey(Integer recruitnoticeid);

    int updateByPrimaryKeySelective(BeanRecruitNotice record);

    int updateByPrimaryKey(BeanRecruitNotice record);
}