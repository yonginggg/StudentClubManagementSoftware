package com.zks.model;

import java.util.Date;

public class BeanActivity {
    private Integer activityid;

    private String activityrange;

    private String activityname;

    private String activityintroduction;

    private Date activitystarttime; //活动开始时间

    private Date activityendtime; //活动结束时间

    private Date activityreleasetime; //活动公布时间（审核通过时间）

    private Date activitydeadline; //活动报名截止时间

    private Integer activitypalce;

    private Integer associationsid;

    private Integer departmentid;

    private Date activitiesapplicationtime; //活动申请时间

    private String activitiesapplicationstate;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getActivityrange() {
        return activityrange;
    }

    public void setActivityrange(String activityrange) {
        this.activityrange = activityrange == null ? null : activityrange.trim();
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public String getActivityintroduction() {
        return activityintroduction;
    }

    public void setActivityintroduction(String activityintroduction) {
        this.activityintroduction = activityintroduction == null ? null : activityintroduction.trim();
    }

    public Date getActivitystarttime() {
        return activitystarttime;
    }

    public void setActivitystarttime(Date activitystarttime) {
        this.activitystarttime = activitystarttime;
    }

    public Date getActivityendtime() {
        return activityendtime;
    }

    public void setActivityendtime(Date activityendtime) {
        this.activityendtime = activityendtime;
    }

    public Date getActivityreleasetime() {
        return activityreleasetime;
    }

    public void setActivityreleasetime(Date activityreleasetime) {
        this.activityreleasetime = activityreleasetime;
    }

    public Date getActivitydeadline() {
        return activitydeadline;
    }

    public void setActivitydeadline(Date activitydeadline) {
        this.activitydeadline = activitydeadline;
    }

    public Integer getActivitypalce() {
        return activitypalce;
    }

    public void setActivitypalce(Integer activitypalce) {
        this.activitypalce = activitypalce;
    }

    public Integer getAssociationsid() {
        return associationsid;
    }

    public void setAssociationsid(Integer associationsid) {
        this.associationsid = associationsid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Date getActivitiesapplicationtime() {
        return activitiesapplicationtime;
    }

    public void setActivitiesapplicationtime(Date activitiesapplicationtime) {
        this.activitiesapplicationtime = activitiesapplicationtime;
    }

    public String getActivitiesapplicationstate() {
        return activitiesapplicationstate;
    }

    public void setActivitiesapplicationstate(String activitiesapplicationstate) {
        this.activitiesapplicationstate = activitiesapplicationstate == null ? null : activitiesapplicationstate.trim();
    }
}