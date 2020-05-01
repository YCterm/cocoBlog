package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.Category;
import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;

/**
 * 博文管理
 * @author psq
 *
 */
@Service
public class BackAritleBiz {

	@Resource
	private ArticleMapper am;
	
	@Resource
	private CategoryMapper cm;
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
	/**
	 * 分页展示
	 * @author zyc
	 * @param page
	 * @return
	 */
	public List<Article> showPageInfo(int page) {
		PageHelper.startPage(page,8);
		return am.selectByExample(null);
	}
	
	public PageInfo<Article> showPageInfo(int page,int pageSize) {
		PageHelper.startPage(page,pageSize);
		return new PageInfo<Article>(am.selectByExample(null));
	}
	/**
	 * 删除文章
	 * @param artid
	 * @author zyc
	 */
	public void deleteById(Integer artid) {
		 am.deleteByPrimaryKey(artid);
		 System.out.println("++++"+artid);
		
	}
	
	/**
	 * 修改
	 * @param article
	 * @author zyc
	 */
	public Article update(Article article) {
		am.updateByPrimaryKeySelective(article);
		return article;
		
	}
	/**
	 * 查询文章类型
	 * @return
	 * @author zyc
	 */
	public List<Category> selectCategory(){
		return cm.selectByExample(null);
	}
	 
	/**
	 * 根据标题查询文章
	 * @param title
	 * @return 
	 * @return
	 */
	  public Object selectByName(String title) { 
		  System.out.println("__查询__"+title);
		  return am.selectByName(title); 
	  }
	 
}
