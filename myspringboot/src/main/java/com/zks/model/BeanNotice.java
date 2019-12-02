package com.zks.model;

import java.util.Date;

public class BeanNotice {
    private Integer noticeid;

    private String noticerange;

    private String noticename;

    private String noticecontent;

    private Date noticetime;

    private Integer associationsid;

    private Integer departmentid;

    private String noticestate;

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticerange() {
        return noticerange;
    }

    public void setNoticerange(String noticerange) {
        this.noticerange = noticerange == null ? null : noticerange.trim();
    }

    public String getNoticename() {
        return noticename;
    }
    public void setNoticename(String noticename) {
        this.noticename = noticename == null ? null : noticename.trim();
    }
    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent == null ? null : noticecontent.trim();
    }

    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
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

    public String getNoticestate() {
        return noticestate;
    }

    public void setNoticestate(String noticestate) {
        this.noticestate = noticestate;
    }
}
