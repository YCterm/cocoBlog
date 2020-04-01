package com.yc.blog.web.hyq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;

@RestController
public class Action {

	@Resource
	private CategoryMapper cm;
	@Resource
	private ArticleMapper am;

	@ModelAttribute
	public ModelAndView init(ModelAndView mav) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andLabelIsNull();
		List<Category> groupList = cm.selectByExample(ce);
		mav.addObject("groupList", groupList);
		return mav;
	}

	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView getIndex(ModelAndView mav) {
		mav.setViewName("index.html");
		return mav;
	}
	
	
	//控制显示content文本长度
	private static final int CONTENT = 200;
	//每页多少条文章
	private static final int ART_NUMBER = 5;
	@GetMapping({"html","css","js","xml","php","mysql","java","c","spring"})
	public ModelAndView getData(@RequestParam(defaultValue = "1")Integer page, ModelAndView mav,HttpServletRequest rq) {		
		String requestPath = rq.getServletPath();
		String label = requestPath.substring(requestPath.indexOf("/")+1); 
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andLabelEqualTo(label);
		List<Category> menuList = cm.selectByExample(ce);
		//如果不存在，跳回index
		if(menuList.size()<1) {
			mav.setViewName("redirect:/");
			return mav;
		}		
		int cateid = menuList.get(0).getCateid();
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andCateidEqualTo(cateid);
		PageHelper.startPage(page, ART_NUMBER);
		List<Article> artcleList = am.selectByExampleWithBLOBs(ae);
		//清洗html标签
		for(Article temp : artcleList) {
			String tempStr = Jsoup.parse(temp.getContent()).text();
			//过长的文本被省略
			int tempStrLen = tempStr.length();
			if(tempStrLen > CONTENT) {
				tempStr = tempStr.substring(0, CONTENT) + "...";
			}
			temp.setContent(tempStr);
		}
		//计算页码
		ArticleExample aelen = new ArticleExample();
		aelen.createCriteria().andCateidEqualTo(cateid);		
		int artcleSize = am.selectByExampleWithBLOBs(aelen).size();
		int allPage = 0;
		if((artcleSize % ART_NUMBER) == 0) {
			if(artcleSize == 0) {
				allPage = 1;
			}else {
				allPage = artcleSize / ART_NUMBER;
			}			
		} else {
			allPage = artcleSize / ART_NUMBER + 1;
		}
		
		int prevPage = page-1<1 ? page : page - 1;
		int nextPage = page+1>allPage ? page : page + 1;
		System.out.println(allPage);
		
		//类型
		mav.addObject("type", label);
		//文章
		mav.addObject("artcleList", artcleList);
		//页码
		mav.addObject("artcleSize", artcleSize);
		mav.addObject("allPage", allPage);
		mav.addObject("prevPage", prevPage);
		mav.addObject("nextPage", nextPage);
		mav.addObject("page", page);
		
		mav.setViewName("lead.html");
		return mav;
	}

}
