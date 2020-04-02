package com.yc.blog.web.hyq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("catalog/{grouplabel}/{menulabel}")
	public ModelAndView getMenuData(@RequestParam(defaultValue = "1") Integer page, ModelAndView mav,
			@PathVariable("grouplabel") String grouplabel, @PathVariable("menulabel") String menulabel) {

		List<Category> menuList = cb.getMenu(menulabel);

		// 安全检验
		if (menuList.size() < 1) {
			mav.setViewName("redirect:/");
			return mav;
		}

		int cateid = menuList.get(0).getCateid();
		// 获取页面全部文章数量
		int artcleSize = cb.getArtcleSize(cateid);

		// 计算页码
		Map<String, Integer> pageMap = cb.getPageMap(page, artcleSize);
		// 分页 当前页几条记录
		List<Article> articleList = cb.getShorArt(cateid, pageMap.get("currentPage"));

		// 频道点击排行
		List<Article> hotArtList = cb.getHotArt(cateid);

		// TODO：其他模块数据

		// 推送包------------------------------------------------
		// 类型
		mav.addObject("type", menulabel);
		// 主文章
		mav.addObject("artcleList", articleList);
		// 频道点击排行
		mav.addObject("hotArtList", hotArtList);
		// 页码
		mav.addObject("artcleSize", pageMap.get("artcleSize"));
		mav.addObject("allPage", pageMap.get("allPage"));
		mav.addObject("prevPage", pageMap.get("prevPage"));
		mav.addObject("nextPage", pageMap.get("nextPage"));
		mav.addObject("page", page);
		mav.setViewName("common.html");
		return mav;
	}

	@GetMapping("catalog/{grouplabel}")
	public ModelAndView getGroupData(@RequestParam(defaultValue = "1") Integer page, ModelAndView mav,
			@PathVariable("grouplabel") String grouplabel) {

		List<Category> groupList = cb.getMenu(grouplabel);
		int groupid = groupList.get(0).getCateid();
		List<Category> menuList = cb.getMenu(groupid);

		// 安全检验
		if (groupList.size() < 1 || menuList.size() < 1) {
			mav.setViewName("redirect:/");
			return mav;
		}

		List<Integer> menuCateidList = new ArrayList<Integer>();
		for (Category menu : menuList) {
			menuCateidList.add(menu.getCateid());
		}
		// 获取页面全部文章数量
		int artcleSize = cb.getGroupArtcleSize(menuCateidList);

		// 计算页码
		Map<String, Integer> pageMap = cb.getPageMap(page, artcleSize);

		// 分页 当前页几条记录
		List<Article> articleList = cb.getGroupShorArt(menuCateidList, page);

		// 频道点击排行
		List<Article> hotArtList = cb.getGroupHotArt(menuCateidList);

		// 推送包------------------------------------------------
		// 类型
		mav.addObject("type", grouplabel);
		// 主文章
		mav.addObject("artcleList", articleList);
		// 频道点击排行
		mav.addObject("hotArtList", hotArtList);
		// 页码
		mav.addObject("artcleSize", pageMap.get("artcleSize"));
		mav.addObject("allPage", pageMap.get("allPage"));
		mav.addObject("prevPage", pageMap.get("prevPage"));
		mav.addObject("nextPage", pageMap.get("nextPage"));
		mav.addObject("page", page);
		mav.setViewName("common.html");
		return mav;
	}
}
