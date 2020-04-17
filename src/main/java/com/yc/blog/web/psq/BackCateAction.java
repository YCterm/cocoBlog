package com.yc.blog.web.psq;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.biz.BackCateBiz;
import com.yc.blog.biz.BizException;
import com.yc.blog.vo.Result;

@Controller
public class BackCateAction {

	@Resource
	private BackCateBiz bcb;

	/**
	 * 查询所有分类
	 * 
	 * @param m
	 * @return
	 */

	@GetMapping("backCate")
	public String selectAll(Model m) {
		CategoryExample cExample = new CategoryExample();
		List<Category> cList = new ArrayList<Category>();
		for (Category cate : bcb.selectCates(cExample)) {
			if (cate.getSupercateid() == null || cate.getSupercateid() == 0) {
				cList.add(cate);
			}
		}
		m.addAttribute("cateList", bcb.selectCates(cExample));
		m.addAttribute("cateParList", cList);
		return "back/cate";
	}

	/**
	 * 添加类型状态
	 */
	@PostMapping("addCates")
	@ResponseBody
	public Result addCate(String parid, String kidname,Model m) {
		try {
			if (bcb.insert(parid, kidname) > 0) {
				CategoryExample cExample = new CategoryExample();
				cExample.createCriteria().andCatenameEqualTo(kidname);
				CategoryExample cExample2 = new CategoryExample();
				m.addAttribute("cateList", bcb.selectCates(cExample2));
				return new Result(1, "添加成功！！！",bcb.selectCates(cExample).get(0));
			}
			return new Result(1000, "添加失败！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}

	/**
	 * 修改类型状态
	 */
	@PostMapping("changeCatestatus")
	@ResponseBody
	public Result changeState(String state, String cateid,Model m) {
		try {
			if (bcb.updateState(state, cateid) > 0) {
				CategoryExample cExample = new CategoryExample();
				m.addAttribute("cateList", bcb.selectCates(cExample));
				return new Result(1, "修改成功！！！");
			}
			return new Result(1000, "修改失败！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}

	/**
	 * 更新分类信息
	 */
	@PostMapping("updateCate")
	@ResponseBody
	public Result updateCate(String parid, String kidname, String cateid,Model m) {
		Category category = new Category();
		category.setSupercateid(Integer.parseInt(parid));
		category.setCatename(kidname);
		category.setCateid(Integer.parseInt(cateid));

		try {
			if (bcb.update(category) > 0) {
				CategoryExample cExample = new CategoryExample();
				m.addAttribute("cateList", bcb.selectCates(cExample));
				return new Result(1, "修改成功！！！");
			}
			return new Result(1000, "修改失败！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}

	/**
	 * 验证分类名
	 */
	@PostMapping("checkCatename")
	@ResponseBody
	public Result checkCatename(String name) {
		// 链接名正则：中文、英文
		String regFname = "^[\\u4E00-\\u9FA5A-Za-z]+$";
		if (name != null && !name.isEmpty()) {
			if (!name.matches(regFname)) {
				return new Result(1003, "请输入中文或英文！！！");
			}
			return new Result(1, "输入正确！！！");
		} else {
			return new Result(1001, "数据为空！！！");
		}
	}
}
