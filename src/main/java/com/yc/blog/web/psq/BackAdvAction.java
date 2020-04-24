package com.yc.blog.web.psq;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BackAdvAction {

	/**
	 * 轮播
	 */
	@GetMapping("backAdv")
	public String selectAll(Model m) {
		return "back/adv";
	}
}
