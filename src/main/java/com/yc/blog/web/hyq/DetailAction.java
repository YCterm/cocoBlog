package com.yc.blog.web.hyq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.Comment;
import com.yc.blog.bean.CommentExample;
import com.yc.blog.bean.User;
import com.yc.blog.bean.container.LabelBean;
import com.yc.blog.bean.container.TimeBean;
import com.yc.blog.biz.BizUtil;
import com.yc.blog.biz.CommonBiz;
import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;
import com.yc.blog.dao.CommentMapper;

/**
 * 
 * @author Hooy
 *
 */
@RestController
public class DetailAction {

	@Resource
	private CommonBiz cb;

	@Resource
	private BizUtil bu;

	@Resource
	private ArticleMapper am;

	@Resource
	private CategoryMapper cm;

	@Resource
	private CommentMapper cmm;

	@ModelAttribute
	public ModelAndView init(ModelAndView mav) {
		List<Category> header = cb.getHeader();
		mav.addObject("groupList", header);
		return mav;
	}

	@GetMapping("detail/{numberStr}")
	public ModelAndView getDetail(@PathVariable("numberStr") String numberStr, ModelAndView mav) {
		ModelMap mavMap = mav.getModelMap();

		// 输入非数字字符
		Integer number = 0;
		try {
			number = Integer.parseInt(numberStr);
		} catch (Exception e) {
			mav.setViewName("index.html");
			return mav;
		}

		ArticleExample ae = new ArticleExample();
		ae.createCriteria().andArtidEqualTo(number).andArtstatusEqualTo(1);
		List<Article> artList = am.selectByExampleWithBLOBs(ae);
		if (artList.size() < 1) {
			mav.setViewName("index.html");
			return mav;
		}

		// 文章主体
		Article article = artList.get(0);
		
		//增加点击量
		am.updateReadcnt(number);

		// clone
		Article articleClone = new Article();
		articleClone.setContent(article.getContent());
		List<Article> articleCloneList = new ArrayList<Article>();
		articleCloneList.add(articleClone);
		// 文章摘要
		String artAbstract = bu.cleanHTML(articleCloneList).get(0).getContent();

		// 随机内容
		List<Article> randomArticle = am.getRandomArticle();

		// 上一篇
		Article prevArticle = am.getPrevArticle(number);
		// 下一篇
		Article nextArticle = am.getNextArticle(number);

		// 热门标签
		// 由于url路径问题，创建了一个新LabelBean实体类来存放对象，并对所需数据整合
		@SuppressWarnings("unchecked")
		List<Category> header = (List<Category>) mavMap.get("groupList");
		List<LabelBean> hotLabel = new ArrayList<LabelBean>();
		for (Category group : header) {
			for (Category menu : group.getMenuList()) {
				// 拼接url，放入实体类。在前端直接调用url即可获得url值
				LabelBean lb = new LabelBean(menu.getCatename(),
						"/catalog/" + group.getCatename() + "/" + menu.getCatename());
				hotLabel.add(lb);
			}
		}

		// 同类推荐文章
		Integer cateid = article.getCateid();
		List<Article> recommendArticle = am.getRecommendArticle(cateid);

		// 同类文章归档
		List<TimeBean> timeArtList = cb.getTimeList(cateid, "");
		// 获得/{group}/{menu}
		String timeArtListUrl = null;
		Category menuCate = cm.selectByPrimaryKey(cateid);
		if (menuCate.getSupercateid() == null) {
			timeArtListUrl = menuCate.getCatename();
		} else {
			Category groupCate = cm.selectByPrimaryKey(menuCate.getSupercateid());
			timeArtListUrl = groupCate.getCatename() + "/" + menuCate.getCatename();
		}

		// 评论
		CommentExample cme = new CommentExample();
		cme.createCriteria().andArtidEqualTo(number).andComstatusEqualTo(1);
		List<Comment> commentList = cmm.selectByExample(cme);
		Integer commentListSize = commentList.size();

		mav.addObject("number", number);
		mav.addObject("article", article);
		mav.addObject("artAbstract", artAbstract);
		mav.addObject("randomArticle", randomArticle);
		mav.addObject("prevArticle", prevArticle);
		mav.addObject("nextArticle", nextArticle);
		mav.addObject("hotLabel", hotLabel);
		mav.addObject("recommendArticle", recommendArticle);
		mav.addObject("timeArtList", timeArtList);
		mav.addObject("timeArtListUrl", timeArtListUrl);
		mav.addObject("commentList", commentList);
		mav.addObject("commentListSize", commentListSize);

		mav.setViewName("detail.html");
		return mav;
	}

	@PostMapping("detail/{numberStr}/sendComment")
	public ModelAndView sendComment(@SessionAttribute("loginedUser") User user,
			@PathVariable("numberStr") String numberStr, Comment comment, ModelAndView mav) {
		// 后端判断是否登录
		if (user == null) {
			mav.setViewName("login.html");
			return mav;
		}

		// 输入非数字字符
		Integer number = 0;
		try {
			number = Integer.parseInt(numberStr);
		} catch (Exception e) {
			mav.setViewName("index.html");
			return mav;
		}

		comment.setArtid(number);
		comment.setComtime(new Date());
		comment.setUid(user.getUid());
		comment.setComstatus(1);
		System.out.println(comment.toString());
		cmm.insert(comment);
		
		mav.setViewName("redirect:/detail/" + number);

		return mav;
	}

}
