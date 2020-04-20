package com.yc.blog.web.psq;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.dao.CategoryMapper;
import com.yc.blog.vo.Result;

@Controller
public class BackAddAction {
	
	@Resource
	CategoryMapper cm;
	
	@GetMapping("backAdd")
	public String getAdd(ModelMap m) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andSupercateidIsNull().andCatestatusEqualTo(1);
		List<Category> cateList = cm.selectByExample(ce);
		m.addAttribute("cateList",cateList);
		return "back/add";
	}

	@ResponseBody
	@PostMapping("getSelectMenu")
	public Result getSelectMenu(String supercateid) {
		System.out.println(supercateid);
		Integer sid = 0;
		try {
			sid = Integer.parseInt(supercateid);
		}catch(Exception e) {
			return new Result(0,"参数错误！");
		}
		if(sid <= 0) {
			return new Result(0,"请选择分类！");
		}
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andSupercateidEqualTo(sid).andCatestatusEqualTo(1);
		List<Category> cateList = cm.selectByExample(ce);
		return new Result(1,"成功！",cateList);
	}
	
}
