package com.zks.model;

import java.util.Date;

public class BeanRecruitSign {
    private Integer recruitsignid;

    private Date recruitsigntime;

    private String userid;

    private Integer associationsid;

    public Integer getRecruitsignid() {
        return recruitsignid;
    }

    public void setRecruitsignid(Integer recruitsignid) {
        this.recruitsignid = recruitsignid;
    }

    public Date getRecruitsigntime() {
        return recruitsigntime;
    }

    public void setRecruitsigntime(Date recruitsigntime) {
        this.recruitsigntime = recruitsigntime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getAssociationsid() {
        return associationsid;
    }

    public void setAssociationsid(Integer associationsid) {
        this.associationsid = associationsid;
    }
}