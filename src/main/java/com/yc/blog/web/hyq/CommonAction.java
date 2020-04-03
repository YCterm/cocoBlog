package com.yc.blog.web.hyq;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.container.TimeBean;
import com.yc.blog.biz.CommonBiz;

@RestController
public class CommonAction {

	@Resource
	private CommonBiz cb;

	@ModelAttribute
	public ModelAndView init(ModelAndView mav) {
		List<Category> header = cb.getHeader();
		mav.addObject("groupList", header);
		return mav;
	}

	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView getIndex(ModelAndView mav) {
		mav.setViewName("index.html");
		return mav;
	}

	@GetMapping("catalog/{grouplabel}/{menulabel}")
	public ModelAndView getMenuData(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(required = false) String time, ModelAndView mav,
			@PathVariable("grouplabel") String grouplabel, @PathVariable("menulabel") String menulabel) {

		Integer cateid = cb.getCateCateid(menulabel);
		List<Article> mainArtList = cb.getArtArticle(cateid, page, time);

		Integer mainAllArtSize = cb.getAllArtSize(cateid, time);
		Map<String, Integer> pageMap = cb.getPageMap(page, mainAllArtSize);

		List<Article> hotArtList = cb.getHotArticle(cateid);

		List<TimeBean> timeArtList = cb.getTimeList(cateid, time);

		// 推送包------------------------------------------------
		// 类型
		mav.addObject("type", menulabel);
		// 主文章
		mav.addObject("artcleList", mainArtList);
		// 频道点击排行
		mav.addObject("hotArtList", hotArtList);
		// 文章归档
		mav.addObject("timeArtList", timeArtList);
		// 页码
		mav.addObject("artcleSize", pageMap.get("artcleSize"));
		mav.addObject("allPage", pageMap.get("allPage"));
		mav.addObject("prevPage", pageMap.get("prevPage"));
		mav.addObject("nextPage", pageMap.get("nextPage"));
		// 当前信息
		mav.addObject("page", page);
		mav.addObject("time", time);
		mav.setViewName("common.html");
		return mav;
	}

	@GetMapping("catalog/{grouplabel}")
	public ModelAndView getGroupData(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(required = false) String time, ModelAndView mav,
			@PathVariable("grouplabel") String grouplabel) {

		Integer groupCateid = cb.getCateCateid(grouplabel);
		List<Integer> menuCateid = cb.getCateCateid(groupCateid);
		// group没有menu
		if (menuCateid.size() < 1) {
			return getMenuData(page, time, mav, null, grouplabel);
		}

		List<Article> mainArtList = cb.getArtArticle(menuCateid, page, time);

		Integer mainAllArtSize = cb.getAllArtSize(menuCateid, time);
		Map<String, Integer> pageMap = cb.getPageMap(page, mainAllArtSize);

		List<Article> hotArtList = cb.getHotArticle(menuCateid);

		List<TimeBean> timeArtList = cb.getTimeList(menuCateid, time);

		// 推送包------------------------------------------------
		// 类型
		mav.addObject("type", grouplabel);
		// 主文章
		mav.addObject("artcleList", mainArtList);
		// 频道点击排行
		mav.addObject("hotArtList", hotArtList);
		// 文章归档
		mav.addObject("timeArtList", timeArtList);
		// 页码
		mav.addObject("artcleSize", pageMap.get("artcleSize"));
		mav.addObject("allPage", pageMap.get("allPage"));
		mav.addObject("prevPage", pageMap.get("prevPage"));
		mav.addObject("nextPage", pageMap.get("nextPage"));
		// 当前信息
		mav.addObject("page", page);
		mav.addObject("time", time);
		mav.setViewName("common.html");
		return mav;
	}
}
