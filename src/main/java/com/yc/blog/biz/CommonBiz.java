package com.yc.blog.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;

@Service
public class CommonBiz {

	@Resource
	private BizUtil bu;
	@Resource
	private ArticleMapper am;
	@Resource
	private CategoryMapper cm;

	public List<Category> getGroup() {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andSupercateidIsNull().andCatestatusEqualTo(1);
		return cm.selectByExample(ce);
	}

	public List<Category> getMenu(String catename) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andCatenameEqualTo(catename).andCatestatusEqualTo(1);
		return cm.selectByExample(ce);
	}

	public List<Category> getMenu(int catestatus) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andSupercateidEqualTo(catestatus).andCatestatusEqualTo(1);
		return cm.selectByExample(ce);
	}

	// menu获取页面文章的数量
	public int getArtcleSize(int cateid) {
		ArticleExample aelen = new ArticleExample();
		aelen.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		return am.selectByExample(aelen).size();
	}

	// group获取页面文章数量
	public int getGroupArtcleSize(List<Integer> menuCateidList) {
		return am.getGroupArtSize(menuCateidList).size();
	}

	public Map<String, Integer> getPageMap(int page, int artcleSize) {
		return bu.getPageNumber(page, artcleSize);
	}

	// menu获取页面文章
	public List<Article> getShorArt(int cateid, int currentPage) {
		// 获取文章数据
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		ae.setOrderByClause("arttime desc");
		PageHelper.startPage(currentPage, BizUtil.ART_NUMBER);
		List<Article> artcleList = am.selectByExampleWithBLOBs(ae);
		// 清洗html标签
		return bu.cleanHTML(artcleList);
	}

	// group获取页面文章
	public List<Article> getGroupShorArt(List<Integer> menuCateidList, int currentPage) {
		List<Article> articleList = am.getGroupArt(menuCateidList, (currentPage - 1) * 4);
		return articleList = bu.cleanHTML(articleList);

	}

	// menu频道点击排行文章
	public List<Article> getHotArt(int cateid) {
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		ae.setOrderByClause("readcnt desc");
		PageHelper.startPage(1, 5);
		return am.selectByExample(ae);
	}

	// group频道点击排行文章
	public List<Article> getGroupHotArt(List<Integer> menuCateidList) {
		return am.getGroupArtSize(menuCateidList);
	}

}
