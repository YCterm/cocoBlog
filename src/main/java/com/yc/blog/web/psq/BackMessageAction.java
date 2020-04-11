package com.yc.blog.web.psq;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.blog.bean.Comment;
import com.yc.blog.biz.BackMessageBiz;
import com.yc.blog.biz.BizException;
import com.yc.blog.vo.Result;

@Controller
public class BackMessageAction {

	@Resource
	private BackMessageBiz bmb;
	
	/**
	 * 留言管理显示
	 */
	@GetMapping("backMessage")
	public String selectAll(Model m) {
		m.addAttribute("commentList",bmb.selectComments());
		return "back/book";
	}
	
	/**
	 * 修改留言状态
	 */
	@PostMapping("changeComstatus")
	@ResponseBody
	public Result changeComstate(String comstate,String comid,Model m) {
		Comment comment = new Comment();
		comment.setComid(Integer.parseInt(comid));
		comment.setComstatus(Integer.parseInt(comstate));
		try {
			if(bmb.updateComstate(comment) <= 0 ) {
				return new Result(1000,"修改失败！！！");
			}
			return new Result(1,"修改成功！！！");
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}
}
