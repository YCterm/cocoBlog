package com.yc.blog.web.psq;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.blog.vo.Result;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.biz.BackAritleBiz;
import com.yc.blog.dao.CategoryMapper;


/**
 * 查看博文
 * @author zyc
 */
@Controller
public class BackListAction {
	@Resource
	private BackAritleBiz bbiz;
	@Resource
	private CategoryMapper cm;
	
	
	@GetMapping("backList")
	public String backList(Model m, @RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<Article> backList1 = bbiz.showPageInfo(page);
		//m.addAttribute("blist1",backList1);

		List<Category> backList = bbiz.selectCategory();
		m.addAttribute("backList",backList);
 		return "back/list";
	}	
	
	
	 
	@ResponseBody
	@RequestMapping("showPageInfo")
	public PageInfo<Article> ShowPageInfo(@RequestParam(defaultValue = "6") Integer limit,
			@RequestParam(defaultValue = "1") Integer pageNumber){
		PageInfo<Article> showPageInfo = bbiz.showPageInfo(pageNumber, limit);
		
		return showPageInfo;
	}
 	
	/**
	 * 删除（多选）
	 * @param ids
	 * @return
	 */
	@ResponseBody
    @RequestMapping("delMany")
    public Result deleteArticle(@RequestParam String[] ids) {
	try {
		for(String id:ids) {
			
			bbiz.deleteById(Integer.valueOf(id));
		}
		return new Result(1,"删除成功！");
	} catch (Exception e) {
		e.printStackTrace();
		return new Result(1000,"该文章已评论，外键约束，删除失败！");
	}
	
	}
	
	/**
	 * 删除单条
	 * @param artid
	 * @return
	 */
	@RequestMapping("delOne")
	@ResponseBody
	public Result deleteOne(Integer artid) {
		System.out.println("-----------"+artid);

		try {
			bbiz.deleteById(artid);
			return new Result(1, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(1000, "删除失败！");
		}
	}
	
	/**
	 * 修改
	 * @param article
	 * @return
	 */
	@RequestMapping("updateArticle")
	@ResponseBody
	public Result updateArticle(Article article) {
		try {
			bbiz.update(article);
			return new Result(1, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(1000, "修改失败！");
		}

	}
	

	@RequestMapping("selectByName")
	@ResponseBody
	public Result selectByName(String title) {
		System.out.println("__查询__"+title);
		try {
			bbiz.selectByName(title);
			return new Result(1, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(1000, "修改失败！");
		}

	}
	
}
