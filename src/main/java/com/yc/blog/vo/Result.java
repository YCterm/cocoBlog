package com.yc.blog.vo;

public class Result {
	//结果码
	private int resultCode;
	//需要传递的消息
	private String message;
	//需要传输的数据
	private Object Data;
	

	public Result() {
		super();
	}
	
	public Result(Object data) {
		super();
		Data = data;
	}
	
	public Result(int resultCode) {
		super();
		this.resultCode = resultCode;
	}

	public Result(String message) {
		super();
		this.message = message;
	}

	public Result(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = message;
	}

	public Result(int resultCode, String message, Object data) {
		super();
		this.resultCode = resultCode;
		this.message = message;
		Data = data;
	}
	@Override
	public String toString() {
		return "Result [resultCode=" + resultCode + ", message=" + message + ", Data=" + Data + "]";
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
}
