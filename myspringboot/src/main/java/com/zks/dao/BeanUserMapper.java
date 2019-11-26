package com.zks.dao;

import com.zks.model.BeanUser;

public interface BeanUserMapper {
    int deleteUser(String userid);

    int insertUser(BeanUser record);

    int insertSelective(BeanUser record);

    BeanUser selectUser(String userid);

    int updateByPrimaryKeySelective(BeanUser record);

    int updateUser(BeanUser record);
}