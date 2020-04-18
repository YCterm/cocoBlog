package com.yc.blog.web.tml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.Comment;
import com.yc.blog.bean.User;
import com.yc.blog.bean.container.LabelBean;
import com.yc.blog.bean.container.TimeBean;
import com.yc.blog.biz.BizException;
import com.yc.blog.biz.BizUtil;
import com.yc.blog.biz.CommonBiz;

import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;
import com.yc.blog.dao.CommentMapper;
import com.yc.blog.vo.Result;

@RestController
@SessionAttributes("loginedUser")
public class IndexAction {
	
	@Resource
	private BizUtil bu;
	
	@Resource
	private ArticleMapper am;
	
	@Resource
	public CommentMapper cm;
	
	@Resource
	private CategoryMapper cgm;
	
	@Resource
	private CommonBiz cb;
	
	
	@ModelAttribute
	public ModelAndView init(ModelAndView mav) {
		List<Category> header = cb.getHeader();
		mav.addObject("groupList", header);
		return mav;
	}
	
	
	
	
	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView getIndex(@RequestParam(defaultValue = "1") Integer page ,ModelAndView mav) {
		
		ModelMap mavMap = mav.getModelMap();
		PageHelper.startPage(page,10);
		
		List<Article> artList = bu.cleanHTML(am.selectByExampleWithBLOBs(null));
		
		List<Comment> latestComment = cm.getCommentLatest();
		
		// 随机内容
		List<Article> randomArticle = am.getRandomArticle();
		
		// 热门文章
		List<Article> mostArticle = bu.cleanHTML1(am.getMostArticle());
		
		// 文章主体
		Article article = artList.get(0);
		
		// 热门标签
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
		
		
		
		mav.addObject("hotLabel", hotLabel);
		mav.addObject("mostArticle", mostArticle);
		mav.addObject("article", article);
		mav.addObject("recommendArticle", recommendArticle);
		mav.addObject("alist",artList);
		mav.addObject("latestComment",latestComment);
		mav.addObject("randomArticle",randomArticle);
		
		mav.setViewName("index.html");
		return mav;
	}
	
	
	@GetMapping("about.html")
	public ModelAndView getAbout(ModelAndView mav) {
		mav.setViewName("about.html");
		return mav;
	}
	
	@GetMapping("aboutauthor.html")
	public ModelAndView getAboutauhor(ModelAndView mav) {
		mav.setViewName("aboutauthor.html");
		return mav;
	}
	
	
	@GetMapping("init.html")
	public ModelAndView getInit(ModelAndView mav) {
		mav.setViewName("init.html");
		return mav;
	}
	
	@PostMapping("init/sendInit")
	public ModelAndView sendInit(@SessionAttribute("loginedUser") User user,
			Comment comment,ModelAndView mav) {
		//登录状态
		if(user == null) {
			mav.setViewName("login.html");
			return mav;
		}
		comment.setArtid(null);
		comment.setComtime(new Date());
		comment.setUid(user.getUid());
		comment.setComstatus(2);
		
		cm.insert(comment);

		return getInit(mav);
		
	}
	

}
