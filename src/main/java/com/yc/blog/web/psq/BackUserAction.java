package com.yc.blog.web.psq;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.blog.bean.User;
import com.yc.blog.biz.BackUserBiz;
import com.yc.blog.biz.BizException;
import com.yc.blog.vo.Result;

@Controller
public class BackUserAction {
	@Resource
	private BackUserBiz bub;

	/**
	 * 游客管理显示
	 */
	@GetMapping("backUser")
	public String selectAll(Model m) {
		m.addAttribute("userList",bub.selectUsers());
		return "back/column";
	}
	/**
	 * 修改游客状态
	 */
	@PostMapping("changeUstatus")
	@ResponseBody
	public Result changeState(String ustate, String uid,Model m) {
		User user = new User();
		user.setUid(Integer.parseInt(uid));
		user.setUstatus(Integer.parseInt(ustate));
		try {
			if(bub.updateState(user) > 0 ) {
				return new Result(1,"修改成功！！！");
			}
			return new Result(1000,"修改失败！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
		
	}
}
