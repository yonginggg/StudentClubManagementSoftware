package com.zks.dao;

import com.zks.model.BeanMember;

import java.util.List;

public interface BeanMemberMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(BeanMember record);

    int insertSelective(BeanMember record);

    BeanMember selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(BeanMember record);

    int updateByPrimaryKey(BeanMember record);

    List<BeanMember> selectMember(BeanMember member);
}
