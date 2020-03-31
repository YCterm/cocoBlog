package com.yc.blog.bean;

public class Links {
    private Integer fid;

    private String fname;

    private String furl;

    private Integer fstatus;

    private String ftemp;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl == null ? null : furl.trim();
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFtemp() {
        return ftemp;
    }

    public void setFtemp(String ftemp) {
        this.ftemp = ftemp == null ? null : ftemp.trim();
    }
}