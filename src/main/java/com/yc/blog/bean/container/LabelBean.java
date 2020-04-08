package com.yc.blog.bean.container;

public class LabelBean {
	
	private String labelName;
	
	private String url;

	public LabelBean() {
		super();
	}

	public LabelBean(String labelName, String url) {
		super();
		this.labelName = labelName;
		this.url = url;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
