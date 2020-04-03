package com.yc.blog.biz;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.ArticleExample.Criteria;
import com.yc.blog.bean.container.TimeBean;
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

	// header标签内的数据
	public List<Category> getHeader() {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andSupercateidIsNull().andCatestatusEqualTo(1);
		return cm.selectByExample(ce);
	}

	// 根据catename返回cateid
	public Integer getCateCateid(String catename) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andCatenameEqualTo(catename).andCatestatusEqualTo(1);
		List<Category> catenameList = cm.selectByExample(ce);
		// TODO:exception
		return catenameList.get(0).getCateid();
	}

	// 根据supercateid返回menucateid集合
	public List<Integer> getCateCateid(Integer supercateid) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andSupercateidEqualTo(supercateid).andCatestatusEqualTo(1);
		List<Category> menuList = cm.selectByExample(ce);
		List<Integer> menuCateid = new ArrayList<Integer>();
		for (Category temp : menuList) {
			menuCateid.add(temp.getCateid());
		}
		return menuCateid;
	}

	// 主要文章目录
	public List<Article> getArtArticle(Integer cateid, Integer page, String time) {
		ArticleExample ae = new ArticleExample();
		Criteria aecc = ae.createCriteria();
		aecc.andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		if (time != null) {
			List<Date> timeDateList = bu.transTime(time);
			aecc.andArttimeBetween(timeDateList.get(0), timeDateList.get(1));
		}
		PageHelper.startPage(page, BizUtil.ART_NUMBER);
		return bu.cleanHTML(am.selectByExampleWithBLOBs(ae));
	}

	// 主要文章目录
	public List<Article> getArtArticle(List<Integer> cateid, Integer page, String time) {
		String flag = time == null ? time : time + "%";
		return bu.cleanHTML(am.getGroupArtArticle(cateid, (page - 1) * BizUtil.ART_NUMBER, BizUtil.ART_NUMBER, flag));
	}

	// 获取主要文章所有文章数量/数据库符合条件的条数
	public Integer getAllArtSize(Integer cateid, String time) {
		ArticleExample ae = new ArticleExample();
		Criteria aecc = ae.createCriteria();
		aecc.andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		if (time != null) {
			List<Date> timeDateList = bu.transTime(time);
			aecc.andArttimeBetween(timeDateList.get(0), timeDateList.get(1));
		}
		return am.selectByExample(ae).size();
	}

	// 获取主要文章所有文章数量/数据库符合条件的条数
	public Integer getAllArtSize(List<Integer> cateid, String time) {
		String flag = time == null ? time : time + "%";
		return am.getGroupAllArtSize(cateid, flag).size();
	}

	// 页码
	public Map<String, Integer> getPageMap(Integer page, Integer mainAllArtSize) {
		return bu.getPageNumber(page, mainAllArtSize);
	}

	// 频道点击排行
	public List<Article> getHotArticle(Integer cateid) {
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		ae.setOrderByClause("readcnt desc");
		PageHelper.startPage(0, BizUtil.HOTRANKING);
		return am.selectByExample(ae);
	}

	// 频道点击排行
	public List<Article> getHotArticle(List<Integer> cateid) {
		return am.getGroupHotArticle(cateid, BizUtil.HOTRANKING);
	}

	// 文章归档
	public List<TimeBean> getTimeList(Integer cateid, String time) {
		return am.getTimeList(cateid, BizUtil.TIMECLASSIFICATION);
	}

	// 文章归档
	public List<TimeBean> getTimeList(List<Integer> cateid, String time) {
		return am.getGroupTimeList(cateid, BizUtil.TIMECLASSIFICATION);
	}

}
