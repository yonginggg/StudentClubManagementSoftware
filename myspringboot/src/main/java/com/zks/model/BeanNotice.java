package com.zks.model;

import java.util.Date;

public class BeanNotice {
    private Integer noticeid;

    private String noticerange;

    private String noticecontent;

    private Date noticetime;

    private Integer associationsid;

    private Boolean noticestate;

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

    public Boolean getNoticestate() {
        return noticestate;
    }

    public void setNoticestate(Boolean noticestate) {
        this.noticestate = noticestate;
    }
}