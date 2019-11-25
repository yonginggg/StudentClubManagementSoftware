package com.zks.model;

import java.util.Date;

public class BeanRecruitNotice {
    private Integer recruitnoticeid;

    private String recruitnoticecontent;

    private Date recruitnoticestarttime;

    private Date recruitnoticeendtime;

    private Date recruitnoticereleasetime;

    private Integer associationsid;

    public Integer getRecruitnoticeid() {
        return recruitnoticeid;
    }

    public void setRecruitnoticeid(Integer recruitnoticeid) {
        this.recruitnoticeid = recruitnoticeid;
    }

    public String getRecruitnoticecontent() {
        return recruitnoticecontent;
    }

    public void setRecruitnoticecontent(String recruitnoticecontent) {
        this.recruitnoticecontent = recruitnoticecontent == null ? null : recruitnoticecontent.trim();
    }

    public Date getRecruitnoticestarttime() {
        return recruitnoticestarttime;
    }

    public void setRecruitnoticestarttime(Date recruitnoticestarttime) {
        this.recruitnoticestarttime = recruitnoticestarttime;
    }

    public Date getRecruitnoticeendtime() {
        return recruitnoticeendtime;
    }

    public void setRecruitnoticeendtime(Date recruitnoticeendtime) {
        this.recruitnoticeendtime = recruitnoticeendtime;
    }

    public Date getRecruitnoticereleasetime() {
        return recruitnoticereleasetime;
    }

    public void setRecruitnoticereleasetime(Date recruitnoticereleasetime) {
        this.recruitnoticereleasetime = recruitnoticereleasetime;
    }

    public Integer getAssociationsid() {
        return associationsid;
    }

    public void setAssociationsid(Integer associationsid) {
        this.associationsid = associationsid;
    }
}