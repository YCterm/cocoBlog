package com.yc.blog.bean;

import java.io.Serializable;
import java.util.Date;

public class CommentShow extends Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer comid;
	private Integer artid;
	private Integer recomid;
	private Date comtime;
	private Integer uid;
	private String comcontent;
	private Integer comstatus;
	private String comtemp;
	private User user;
	private User reUser;
	private String title;
	private String nickname;
	
	public Integer getComid() {
		return comid;
	}
	public void setComid(Integer comid) {
		this.comid = comid;
	}
	public Integer getArtid() {
		return artid;
	}
	public void setArtid(Integer artid) {
		this.artid = artid;
	}
	public Integer getRecomid() {
		return recomid;
	}
	public void setRecomid(Integer recomid) {
		this.recomid = recomid;
	}
	public Date getComtime() {
		return comtime;
	}
	public void setComtime(Date comtime) {
		this.comtime = comtime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getComcontent() {
		return comcontent;
	}
	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}
	public Integer getComstatus() {
		return comstatus;
	}
	public void setComstatus(Integer comstatus) {
		this.comstatus = comstatus;
	}
	public String getComtemp() {
		return comtemp;
	}
	public void setComtemp(String comtemp) {
		this.comtemp = comtemp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getReUser() {
		return reUser;
	}
	public void setReUser(User reUser) {
		this.reUser = reUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "CommentShow [comid=" + comid + ", artid=" + artid + ", recomid=" + recomid + ", comtime=" + comtime
				+ ", uid=" + uid + ", comcontent=" + comcontent + ", comstatus=" + comstatus + ", comtemp=" + comtemp
				+ ", user=" + user + ", reUser=" + reUser + ", title=" + title + ", nickname=" + nickname + "]";
	}
}
