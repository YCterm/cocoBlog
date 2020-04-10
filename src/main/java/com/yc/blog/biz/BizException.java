package com.yc.blog.biz;

import com.yc.blog.vo.Results;

/**
 * @author Hooy
 * 异常类
 */
public class BizException extends Exception {

	private static final long serialVersionUID = 1L;
	private  Results result;

	public Results getResult() {
		return result;
	}
	public void setResult(Results result) {
		this.result = result;
	}
	public BizException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BizException( Results result) {
		super(result.getMsg());
		this.result = result ;
		// TODO Auto-generated constructor stub
	}

	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BizException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BizException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
