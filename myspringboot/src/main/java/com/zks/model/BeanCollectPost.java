package com.zks.model;

import java.util.Date;

public class BeanCollectPost {
    private Integer collectpostid;

    private Date collectposttime;

    private Integer subjectpostid;

    private String userid;

    public Integer getCollectpostid() {
        return collectpostid;
    }

    public void setCollectpostid(Integer collectpostid) {
        this.collectpostid = collectpostid;
    }

    public Date getCollectposttime() {
        return collectposttime;
    }

    public void setCollectposttime(Date collectposttime) {
        this.collectposttime = collectposttime;
    }

    public Integer getSubjectpostid() {
        return subjectpostid;
    }

    public void setSubjectpostid(Integer subjectpostid) {
        this.subjectpostid = subjectpostid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}