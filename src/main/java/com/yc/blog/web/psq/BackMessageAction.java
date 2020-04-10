package com.yc.blog.web.psq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.blog.biz.BackMessageBiz;

@Controller
public class BackMessageAction {

	private BackMessageBiz bmb;
	/**
	 * 留言管理显示
	 */
	@GetMapping("backMessage")
	public String selectAll(Model m) {
		m.addAttribute("commentList",bmb.selectComments());
		return "back/book";
	}
}
