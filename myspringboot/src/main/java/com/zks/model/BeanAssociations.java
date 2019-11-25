package com.zks.model;

import java.util.Date;

public class BeanAssociations {
    private Integer associationsid;

    private String associationsname;

    private Date associationstime;

    private String associationstype;

    private String associationsintroduction;

    private String associationsnumber;

    private String associationsleader;

    private Date associationsapplicationtime;

    private String associationsapplicationstate;

    public Integer getAssociationsid() {
        return associationsid;
    }

    public void setAssociationsid(Integer associationsid) {
        this.associationsid = associationsid;
    }

    public String getAssociationsname() {
        return associationsname;
    }

    public void setAssociationsname(String associationsname) {
        this.associationsname = associationsname == null ? null : associationsname.trim();
    }

    public Date getAssociationstime() {
        return associationstime;
    }

    public void setAssociationstime(Date associationstime) {
        this.associationstime = associationstime;
    }

    public String getAssociationstype() {
        return associationstype;
    }

    public void setAssociationstype(String associationstype) {
        this.associationstype = associationstype == null ? null : associationstype.trim();
    }

    public String getAssociationsintroduction() {
        return associationsintroduction;
    }

    public void setAssociationsintroduction(String associationsintroduction) {
        this.associationsintroduction = associationsintroduction == null ? null : associationsintroduction.trim();
    }

    public String getAssociationsnumber() {
        return associationsnumber;
    }

    public void setAssociationsnumber(String associationsnumber) {
        this.associationsnumber = associationsnumber == null ? null : associationsnumber.trim();
    }

    public String getAssociationsleader() {
        return associationsleader;
    }

    public void setAssociationsleader(String associationsleader) {
        this.associationsleader = associationsleader == null ? null : associationsleader.trim();
    }

    public Date getAssociationsapplicationtime() {
        return associationsapplicationtime;
    }

    public void setAssociationsapplicationtime(Date associationsapplicationtime) {
        this.associationsapplicationtime = associationsapplicationtime;
    }

    public String getAssociationsapplicationstate() {
        return associationsapplicationstate;
    }

    public void setAssociationsapplicationstate(String associationsapplicationstate) {
        this.associationsapplicationstate = associationsapplicationstate == null ? null : associationsapplicationstate.trim();
    }
}