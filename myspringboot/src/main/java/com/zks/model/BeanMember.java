package com.zks.model;

import java.util.Date;

public class BeanMember {
    private Integer memberid;

    private String memberpost;

    private Date membertime;

    private String memberintroduction;

    private String userid;

    private Integer associationsid;

    private  Integer departmentid;

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getMemberpost() {
        return memberpost;
    }

    public void setMemberpost(String memberpost) {
        this.memberpost = memberpost == null ? null : memberpost.trim();
    }

    public Date getMembertime() {
        return membertime;
    }

    public void setMembertime(Date membertime) {
        this.membertime = membertime;
    }

    public String getMemberintroduction() {
        return memberintroduction;
    }

    public void setMemberintroduction(String memberintroduction) {
        this.memberintroduction = memberintroduction == null ? null : memberintroduction.trim();
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
