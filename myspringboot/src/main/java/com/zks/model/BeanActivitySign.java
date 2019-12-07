package com.zks.model;

import java.util.Date;

public class BeanActivitySign {
    private Integer activitysignid;

    private Date studentsigntime;

    private String activitysignstate;

    private String userid;

    private Integer activityId;

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

    public String getActivitysignstate() {
        return activitysignstate;
    }

    public void setActivitysignstate(String activitysignstate) {
        this.activitysignstate = activitysignstate == null ? null : activitysignstate.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getActivityid() {
        return activityId;
    }

    public void setActivityid(Integer activityId) {
        this.activityId = activityId;
    }
}
