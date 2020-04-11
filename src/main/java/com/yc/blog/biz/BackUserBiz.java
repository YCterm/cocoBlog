package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.User;
import com.yc.blog.bean.UserExample;
import com.yc.blog.dao.UserMapper;
import com.yc.blog.vo.Result;

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
	/**
	 * 修改游客状态
	 * @throws BizException 
	 */
	public int  updateState(User user) throws BizException {
		if(user.getUid() ==0 ) {
			throw new BizException(new Result( 1002,"未选择任何粉丝！！！"));
		}
		return um.updateByPrimaryKeySelective(user);
	}
}
