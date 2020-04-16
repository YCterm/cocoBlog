package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.dao.ArticleMapper;

/**
 * 博文管理
 * @author psq
 *
 */
@Service
public class BackAritleBiz {

	@Resource
	private ArticleMapper am;
	/**
	 * 查看草稿
	 */
	public List<Article> selectDraft() {
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andArtstatusEqualTo(2);
		return am.selectByExample(ae);
	}
	/**
	 * 查看博文
	 */
	public List<Article> selectArticles() {
		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andArtstatusEqualTo(1).andArtstatusEqualTo(0);
		return am.selectByExample(ae);
	}
}
