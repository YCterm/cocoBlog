package com.yc.blog.web.psq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.blog.biz.BackUserBiz;

@Controller
public class BackUserAction {
	private BackUserBiz bub;

	/**
	 * 游客管理显示
	 */
	@GetMapping("backUser")
	public String selectAll(Model m) {
		m.addAttribute("userList",bub.selectUsers());
		return "back/column";
	}
}
