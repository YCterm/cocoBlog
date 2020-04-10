package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.Comment;
import com.yc.blog.bean.CommentExample;
import com.yc.blog.dao.CommentMapper;


@Service
public class BackMessageBiz {

	@Resource
	private CommentMapper cm;
	
	/**
	 * 查询所有的评论
	 */
	public List<Comment> selectComments (){
		CommentExample ce = new CommentExample();
		return cm.selectByExample(ce);
	}
}
