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
		ce.createCriteria().andLabelIsNull().andCatestatusEqualTo(1);
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
	private static final int ART_NUMBER = 4;
	@GetMapping({"html","css","js","xml","php","mysql","java","c","spring"})
	public ModelAndView getData(@RequestParam(defaultValue = "1")Integer page, ModelAndView mav,HttpServletRequest rq) {		
		String requestPath = rq.getServletPath();
		String label = requestPath.substring(requestPath.indexOf("/")+1); 
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andLabelEqualTo(label).andCatestatusEqualTo(1);
		List<Category> menuList = cm.selectByExample(ce);
		//如果不存在，跳回index
		if(menuList.size()<1) {
			mav.setViewName("redirect:/");
			return mav;
		}		
		int cateid = menuList.get(0).getCateid();		
		//计算页码
		Map<String,Integer> pageMap = getPageNumber(page,cateid);
		//获取文章数据
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		PageHelper.startPage(pageMap.get("currentPage"), ART_NUMBER);
		List<Article> artcleList = am.selectByExampleWithBLOBs(ae);
		//清洗html标签
		artcleList = cleanHTML(artcleList);
		
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
		mav.setViewName("lead.html");
		return mav;
	}
	
	/* content文字内容html标签清洗方法 
	 * 参数：需要被清洗文章(Article)组(List)
	 */
	private List<Article> cleanHTML(List<Article> originalList){
		for(Article temp : originalList) {
			String tempStr = Jsoup.parse(temp.getContent()).text();
			//过长的文本被省略
			int tempStrLen = tempStr.length();
			if(tempStrLen > CONTENT) {
				tempStr = tempStr.substring(0, CONTENT) + "...";
			}
			temp.setContent(tempStr);
		}
		return originalList;
	}
	
	/* 获取页码
	 * 参数：1.当前页码(currentPage)
	 *     2.类型id(cateid)
	 */
	private Map<String,Integer> getPageNumber(int currentPage,int cateid){
		Map<String,Integer> pageMap = new HashMap<String,Integer>();
		ArticleExample aelen = new ArticleExample();
		aelen.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);		
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
		currentPage = currentPage > 0 && currentPage < allPage + 1 ? currentPage : 1 ;
		int prevPage = currentPage - 1 <= 1 ? 1 : (currentPage > allPage ? 1 : currentPage - 1);
		int nextPage = currentPage + 1 >= allPage ? allPage : (currentPage < 1 ? 1 : currentPage + 1);				
		pageMap.put("artcleSize", artcleSize);
		pageMap.put("allPage", allPage);
		pageMap.put("prevPage", prevPage);
		pageMap.put("nextPage", nextPage);
		pageMap.put("currentPage", currentPage);		
		return pageMap;
	}

}
