package com.zks.model;

import java.util.Date;

public class BeanActivitySign {
    private Integer activitysignid;

    private Date studentsigntime;

    private String userid;

    private Integer associationsid;

    public Integer getActivitysignid() {
        return activitysignid;
    }

    public void setActivitysignid(Integer activitysignid) {
        this.activitysignid = activitysignid;
    }

    public Date getStudentsigntime() {
        return studentsigntime;
    }

    public void setStudentsigntime(Date studentsigntime) {
        this.studentsigntime = studentsigntime;
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