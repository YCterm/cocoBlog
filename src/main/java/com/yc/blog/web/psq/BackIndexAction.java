package com.yc.blog.web.psq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackIndexAction {
	/**
	 * 主页显示
	 */
	@GetMapping("backIndex")
	public String selectAll(Model m) {
		return "back/index";
	}
}
