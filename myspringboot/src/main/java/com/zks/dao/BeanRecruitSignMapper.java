package com.zks.dao;

import com.zks.model.BeanRecruitSign;

public interface BeanRecruitSignMapper {
    int deleteByPrimaryKey(Integer recruitsignid);

    int insert(BeanRecruitSign record);

    int insertSelective(BeanRecruitSign record);

    BeanRecruitSign selectByPrimaryKey(Integer recruitsignid);

    int updateByPrimaryKeySelective(BeanRecruitSign record);

    int updateByPrimaryKey(BeanRecruitSign record);
}