package com.yc.blog.bean;

import java.util.Date;

public class Article {
    private Integer artid;

    private String author;

    private String title;

    private Integer cateid;

    private String imgs;

    private Date arttime;

    private Integer readcnt;

    private Integer artstatus;

    private String arttemp;

    private String content;

    public Integer getArtid() {
        return artid;
    }

    public void setArtid(Integer artid) {
        this.artid = artid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public Date getArttime() {
        return arttime;
    }

    public void setArttime(Date arttime) {
        this.arttime = arttime;
    }

    public Integer getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(Integer readcnt) {
        this.readcnt = readcnt;
    }

    public Integer getArtstatus() {
        return artstatus;
    }

    public void setArtstatus(Integer artstatus) {
        this.artstatus = artstatus;
    }

    public String getArttemp() {
        return arttemp;
    }

    public void setArttemp(String arttemp) {
        this.arttemp = arttemp == null ? null : arttemp.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}