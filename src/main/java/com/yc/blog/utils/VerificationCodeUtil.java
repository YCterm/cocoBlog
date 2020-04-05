package com.yc.blog.utils;

import java.util.Random;

public class VerificationCodeUtil {
	/**
	 * 获取四位随机验证码
	 * @return 返回
	 */
	public String generateVerificationCode() {
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder objStringBuilder=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
		     char ch=str.charAt(new Random().nextInt(str.length()));
		     objStringBuilder.append(ch);
		}
		return objStringBuilder.toString();
	}
}
