package com.yc.blog.web.psq;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.blog.biz.BackCateBiz;
import com.yc.blog.biz.BizException;
import com.yc.blog.vo.Result;

@Controller
public class BackCateAction {

	@Resource
	private BackCateBiz bcb;
	/**
	 * 分类显示
	 */
	@GetMapping("backCate")
	public String selectAll(Model m,HttpSession session) {
		session.setAttribute("ztree", bcb.selectAll());
		return "back/cate";
	}
	/**
	 * 添加类型状态
	 */
	@PostMapping("addCate")
	@ResponseBody
	public Result addCate(String parname,String kidname){
		try {
			if(bcb.insert(parname, kidname) > 0 ) {
				return new Result(1,"添加成功！！！");
			}
			return new Result(1000,"添加失败！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}
	/**
	 * 修改类型状态
	 */
	@PostMapping("changeCateState")
	@ResponseBody
	public Result changeState(String parname,String kidname,String state){
		try {
			if(bcb.update(parname, kidname, state) > 0) {
				return  new Result(1,"修改成功！！！");
			}
			return new Result(1000,"修改失败！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}
}
