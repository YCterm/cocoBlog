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
		ce.createCriteria().andLabelIsNull().andCatestatusEqualTo(1);
		return cm.selectByExample(ce);
	}

	public List<Category> getMenu(String label) {
		CategoryExample ce = new CategoryExample();
		ce.createCriteria().andLabelEqualTo(label).andCatestatusEqualTo(1);
		return cm.selectByExample(ce);
	}

	public int getArtcleSize(int cateid) {
		ArticleExample aelen = new ArticleExample();
		aelen.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		return am.selectByExampleWithBLOBs(aelen).size();
	}
	
	public Map<String,Integer> getPageMap(int page,int artcleSize){
		return bu.getPageNumber(page, artcleSize);
	}

	public List<Article> getShorArt(int cateid,int currentPage) {		
		// 获取文章数据
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andCateidEqualTo(cateid).andArtstatusEqualTo(1);
		PageHelper.startPage(currentPage, BizUtil.ART_NUMBER);
		List<Article> artcleList = am.selectByExampleWithBLOBs(ae);
		//清洗html标签
		return bu.cleanHTML(artcleList);				
	}
	

}
