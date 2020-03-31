package com.yc.blog;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.blog.bean.Comment;
import com.yc.blog.bean.CommentExample;
import com.yc.blog.dao.CommentMapper;

@SpringBootTest
public class CocoBlogApplicationTests {
	
	@Resource
	private CommentMapper cm;
	
	@Test
	public void test1() {
		CommentExample ce = new CommentExample();
		//ce.createCriteria().andComidEqualTo(null);
		List<Comment> comlist = cm.selectByExample(ce);
		System.out.println(comlist.size());
	}

}
