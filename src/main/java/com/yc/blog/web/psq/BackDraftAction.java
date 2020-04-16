package com.yc.blog.web.psq;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.blog.biz.BackAritleBiz;

@Controller
public class BackDraftAction {

	@Resource
	private BackAritleBiz bab;
	/**
	 * 查询草稿
	 */
	@GetMapping("backDraft")
	public String selectAll(Model m) {
		m.addAttribute("draft",bab.selectDraft());
		return "back/cate";
	}
}
