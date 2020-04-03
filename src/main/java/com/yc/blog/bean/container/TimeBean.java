package com.yc.blog.bean.container;

public class TimeBean {
	private String time;
	private Integer amount;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TimeBean [time=" + time + ", amount=" + amount + "]";
	}
		
}