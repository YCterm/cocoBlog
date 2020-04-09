package com.yc.blog.bean;

import java.util.List;

public class Category {
    private Integer cateid;

    private String catename;

    private Integer supercateid;

    private Integer catestatus;
    
    private List<Category> menuList;

    public List<Category> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Category> menuList) {
		this.menuList = menuList;
	}

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

    public Integer getSupercateid() {
        return supercateid;
    }

    public void setSupercateid(Integer supercateid) {
        this.supercateid = supercateid;
    }

    public Integer getCatestatus() {
        return catestatus;
    }

    public void setCatestatus(Integer catestatus) {
        this.catestatus = catestatus;
    }

	@Override
	public String toString() {
		return "Category [cateid=" + cateid + ", catename=" + catename + ", supercateid=" + supercateid
				+ ", catestatus=" + catestatus + ", menuList=" + menuList + "]";
	}
    
}