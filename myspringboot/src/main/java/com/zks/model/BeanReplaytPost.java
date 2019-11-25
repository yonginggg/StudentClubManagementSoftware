package com.zks.model;

import java.util.Date;

public class BeanReplaytPost {
    private Integer replaypostid;

    private String replaypostcontent;

    private Date replayposttime;

    private Integer likenum;

    private Integer subjectpostid;

    private String userid;

    public Integer getReplaypostid() {
        return replaypostid;
    }

    public void setReplaypostid(Integer replaypostid) {
        this.replaypostid = replaypostid;
    }

    public String getReplaypostcontent() {
        return replaypostcontent;
    }

    public void setReplaypostcontent(String replaypostcontent) {
        this.replaypostcontent = replaypostcontent == null ? null : replaypostcontent.trim();
    }

    public Date getReplayposttime() {
        return replayposttime;
    }

    public void setReplayposttime(Date replayposttime) {
        this.replayposttime = replayposttime;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
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