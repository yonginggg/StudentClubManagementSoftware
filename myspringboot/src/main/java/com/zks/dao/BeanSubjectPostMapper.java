package com.zks.dao;

import com.zks.model.BeanSubjectPost;

public interface BeanSubjectPostMapper {
    int deleteByPrimaryKey(Integer subjectpostid);

    int insert(BeanSubjectPost record);

    int insertSelective(BeanSubjectPost record);

    BeanSubjectPost selectByPrimaryKey(Integer subjectpostid);

    int updateByPrimaryKeySelective(BeanSubjectPost record);

    int updateByPrimaryKey(BeanSubjectPost record);
}