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
