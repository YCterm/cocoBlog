package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.Comment;
import com.yc.blog.bean.CommentShow;
import com.yc.blog.dao.CommentMapper;
import com.yc.blog.vo.Result;


@Service
public class BackMessageBiz {

	@Resource
	private CommentMapper cm;
	
	/**
	 * 查询所有的评论
	 */
	public List<Comment> selectComments (){
		CommentShow cs = new CommentShow();
		return cm.getCommentDetail(cs);
	}
	
	/**
	 * 修改评论状态
	 * @throws BizException 
	 */
	public int updateComstate( Comment comment) throws BizException {
		if(comment.getComid() == 0) {
			throw new BizException(new Result(1002,"未选择任何留言！！！"));
		}
		return cm.updateByPrimaryKeySelective(comment);
	}
}
