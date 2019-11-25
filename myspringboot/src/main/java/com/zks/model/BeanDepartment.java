package com.zks.model;

public class BeanDepartment {
    private Integer departmentid;

    private String departmentname;

    private String departmentleader;

    private Integer associationsid;

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getDepartmentleader() {
        return departmentleader;
    }

    public void setDepartmentleader(String departmentleader) {
        this.departmentleader = departmentleader == null ? null : departmentleader.trim();
    }

    public Integer getAssociationsid() {
        return associationsid;
    }

    public void setAssociationsid(Integer associationsid) {
        this.associationsid = associationsid;
    }
}