package com.yc.blog.bean;

public class Category {
    private Integer cateid;

    private String catename;

    private String label;

    private Integer catestatus;

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename == null ? null : catename.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public Integer getCatestatus() {
        return catestatus;
    }

    public void setCatestatus(Integer catestatus) {
        this.catestatus = catestatus;
    }
}