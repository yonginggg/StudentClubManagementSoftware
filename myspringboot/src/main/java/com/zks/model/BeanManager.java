package com.zks.model;

public class BeanManager {
    private String managerid;

    private String managerpwd;

    private String managername;

    private String managerpalce;

    private String managertel;

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid == null ? null : managerid.trim();
    }

    public String getManagerpwd() {
        return managerpwd;
    }

    public void setManagerpwd(String managerpwd) {
        this.managerpwd = managerpwd == null ? null : managerpwd.trim();
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    public String getManagerpalce() {
        return managerpalce;
    }

    public void setManagerpalce(String managerpalce) {
        this.managerpalce = managerpalce == null ? null : managerpalce.trim();
    }

    public String getManagertel() {
        return managertel;
    }

    public void setManagertel(String managertel) {
        this.managertel = managertel == null ? null : managertel.trim();
    }
}