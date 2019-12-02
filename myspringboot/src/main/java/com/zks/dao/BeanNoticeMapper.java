package com.zks.dao;

import com.zks.model.BeanNotice;

import java.util.List;

public interface BeanNoticeMapper {
    int deleteByPrimaryKey(Integer noticeid);

    List<BeanNotice> selectAllNotice();

    List<BeanNotice> selectNoticeBySchool();
    int insert(BeanNotice record);

    int insertSelective(BeanNotice record);

    BeanNotice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(BeanNotice record);

    int updateByPrimaryKey(BeanNotice record);
}
