package com.yc.blog.web.hyq;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.biz.BizUtil;
import com.yc.blog.biz.CommonBiz;
import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;

@RestController
public class CommonAction {
	
	@Resource
	private CommonBiz cb;

	@ModelAttribute
	public ModelAndView init(ModelAndView mav) {
		List<Category> groupList = cb.getGroup();
		mav.addObject("groupList", groupList);
		return mav;
	}

	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView getIndex(ModelAndView mav) {
		mav.setViewName("index.html");
		return mav;
	}
				
	@GetMapping({"html","css","js","xml","php","mysql","java","c","spring"})
	public ModelAndView getMenuData(@RequestParam(defaultValue = "1")Integer page, ModelAndView mav,HttpServletRequest rq) {		
		String requestPath = rq.getServletPath();
		String label = requestPath.substring(requestPath.indexOf("/")+1); 
		List<Category> menuList = cb.getMenu(label);
		//如果不存在，跳回index
		if(menuList.size()<1) {
			mav.setViewName("redirect:/");
			return mav;
		}		
		int cateid = menuList.get(0).getCateid();		
		int artcleSize = cb.getArtcleSize(cateid);
		// 计算页码
		Map<String, Integer> pageMap = cb.getPageMap(page, artcleSize);
		List<Article> artcleList = cb.getShorArt(cateid,pageMap.get("currentPage"));		
		
		//TODO：其他模块数据
		
		//类型
		mav.addObject("type", label);
		//文章
		mav.addObject("artcleList", artcleList);
		//页码
		mav.addObject("artcleSize", pageMap.get("artcleSize"));
		mav.addObject("allPage", pageMap.get("allPage"));
		mav.addObject("prevPage", pageMap.get("prevPage"));
		mav.addObject("nextPage", pageMap.get("nextPage"));
		mav.addObject("page", page);	
		mav.setViewName("common.html");
		return mav;
	}
	
	@GetMapping({""})
	public ModelAndView getGroupData(@RequestParam(defaultValue = "1")Integer page, ModelAndView mav,HttpServletRequest rq) {		
		return mav;
	}
	
	
	
	

}
