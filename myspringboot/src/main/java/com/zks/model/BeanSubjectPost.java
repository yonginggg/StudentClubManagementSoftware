package com.zks.model;

import java.util.Date;

public class BeanSubjectPost {
    private Integer subjectpostid;

    private String subjectposttitle;

    private String subjectpostcontent;

    private Date subjectposttime;

    private Integer collectnum;

    private Integer looknum;

    private String userid;

    public Integer getSubjectpostid() {
        return subjectpostid;
    }

    public void setSubjectpostid(Integer subjectpostid) {
        this.subjectpostid = subjectpostid;
    }

    public String getSubjectposttitle() {
        return subjectposttitle;
    }

    public void setSubjectposttitle(String subjectposttitle) {
        this.subjectposttitle = subjectposttitle == null ? null : subjectposttitle.trim();
    }

    public String getSubjectpostcontent() {
        return subjectpostcontent;
    }

    public void setSubjectpostcontent(String subjectpostcontent) {
        this.subjectpostcontent = subjectpostcontent == null ? null : subjectpostcontent.trim();
    }

    public Date getSubjectposttime() {
        return subjectposttime;
    }

    public void setSubjectposttime(Date subjectposttime) {
        this.subjectposttime = subjectposttime;
    }

    public Integer getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }

    public Integer getLooknum() {
        return looknum;
    }

    public void setLooknum(Integer looknum) {
        this.looknum = looknum;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}