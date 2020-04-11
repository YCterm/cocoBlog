package com.yc.blog.vo;

public class Results {
	// 返回的消息
	
		private String msg;
		/*
		 *  返回的结果码  1 成功
		 *   1000 失败
		 *    1001数据为零
		 *  1002,"未选择任何友情链接
		 *  1003,"请输入中文、英文或数字！！！"
		 *  1004,"该数据已存在！！！"
		 */
		private int code;
		// 返回的数据
		private Object data;
		
		
		public Results() {
			super();
		}
		
		public Results(int code,String msg) {
			super();
			this.msg = msg;
			this.code = code;
		}
		public Results(int code,String msg,  Object data) {
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
		public static Results success(String msg){
			Results result = new Results();
			result.code = 1;
			result.msg = msg;
			return result;
		}
		public static Results success(String msg,Object data){
			Results result = new Results();
			result.code = 1;
			result.msg = msg;
			result.data = data;
			return result;
		}
		/**
		 * 默认失败的结果对象
		 * @param msg
		 * @return
		 */
		public static Results failure(String msg){
			Results result = new Results();
			result.code = 1000;
			result.msg = msg;
			return result;
		}
		
		public static Results failure(String msg ,Object data){
			Results result = new Results();
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
