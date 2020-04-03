package com.yc.blog;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.blog.bean.Comment;
import com.yc.blog.bean.CommentExample;
import com.yc.blog.bean.container.TimeBean;
import com.yc.blog.biz.BizUtil;
import com.yc.blog.dao.ArticleMapper;
import com.yc.blog.dao.CategoryMapper;
import com.yc.blog.dao.CommentMapper;

@SpringBootTest
public class CocoBlogApplicationTests {
	
	@Resource
	private BizUtil bu;
	@Resource
	private ArticleMapper am;
	@Resource
	private CategoryMapper cm;
	
//	@Test
//	public void test1() {
//		CommentExample ce = new CommentExample();
//		//ce.createCriteria().andComidEqualTo(null);
//		List<Comment> comlist = cm.selectByExample(ce);
//		System.out.println(comlist.size());
//	}
	
//	@Test
//	public void test2() {
//		List<TimeBean> list = am.getTimeList(7);
//		System.out.println(list.toString());
//	}
}
