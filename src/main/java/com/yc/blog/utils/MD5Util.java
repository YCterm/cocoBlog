package com.yc.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/**
	 * MD5 32位加密工具
	 * @param text 待加密的文本内容 
	 * @return
	 */
	public String MD5(String text) {
		try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(text.getBytes());
            byte b[] = md5.digest();

            StringBuffer stringBuffer = new StringBuffer("");
            for (int n = 0; n < b.length; n++) {
              int i = b[n];
              if (i < 0) i += 256;
              if (i < 16) stringBuffer.append("0");
              stringBuffer.append(Integer.toHexString(i));
            }
            //返回32位加密后的密文
            return stringBuffer.toString();  
          } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
          }
	}
	
}
