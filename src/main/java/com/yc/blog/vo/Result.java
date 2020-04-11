package com.yc.blog.vo;

public class Result {
	
	// 返回的消息
		private String msg;
		/*
		 *  返回的结果码  0 成功
		 *   1000 失败
		 *    1001数据为零
		 *  1002,"未选择任何友情链接
		 *  1003,"请输入中文、英文或数字！！！"
		 */
		private int code;
		// 返回的数据
		private Object data;
		public Result() {
			super();
		}
		public Result(int code) {
			super();
			this.code = code;
		}
		public Result(int code,String msg) {
			super();
			this.msg = msg;
			this.code = code;
		}
		public Result(int code,String msg,  Object data) {
			super();
			this.msg = msg;
			this.code = code;
			this.data = data;
		}
		/**
		 * 默认成功的结果对象
		 * @param msg
		 * @return
		 */
		public static Result success(String msg){
			Result result = new Result();
			result.code = 0;
			result.msg = msg;
			return result;
		}
		public static Result success(String msg,Object data){
			Result result = new Result();
			result.code = 0;
			result.msg = msg;
			result.data = data;
			return result;
		}
		/**
		 * 默认失败的结果对象
		 * @param msg
		 * @return
		 */
		public static Result failure(String msg){
			Result result = new Result();
			result.code = 1000;
			result.msg = msg;
			return result;
		}
		
		public static Result failure(String msg ,Object data){
			Result result = new Result();
			result.code = 1000;
			result.msg = msg;
			result.data =data;
			return result;
		}
		
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}
}
