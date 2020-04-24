package com.yc.blog.web.psq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BackListAction {

	/**
	 * 查看博文
	 */
	@GetMapping("backList")
	public String selectAll(Model m) {
		return "back/list";
	}
}
