package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.User;
import com.yc.blog.bean.UserExample;
import com.yc.blog.dao.UserMapper;

@Service
public class BackUserBiz {

	@Resource
	private UserMapper um;
	
	/**
	 * 显示所有游客
	 */
	public List<User> selectUsers() {
		UserExample ue= new  UserExample();
		return um.selectByExample(ue);
	}
}
