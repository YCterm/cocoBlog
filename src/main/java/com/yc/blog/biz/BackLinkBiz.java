package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.Links;
import com.yc.blog.bean.LinksExample;
import com.yc.blog.dao.LinksMapper;
import com.yc.blog.vo.Result;

@Service
public class BackLinkBiz {

	@Resource
	private LinksMapper lm;
	
	@Resource
	private BackLinkBiz backLinkBiz ;
	/**
	 * 查询所有的友情链接
	 * @return 
	 * @throws BizException 
	 */
	public List<Links> selectAllLinks(){
		LinksExample le = new LinksExample();
		le.setOrderByClause("fid desc");
		return lm.selectByExample(le);
	}
	/**
	 * 修改链接状态
	 * @throws BizException 
	 */
	public int updateFstatus(Links links) throws BizException {
		if(links.getFid() == 0) {
			throw new BizException(new Result(1002,"未选择任何友情链接！！！"));
		}
		return lm.updateByPrimaryKeySelective(links);
	}
	/**
	 * 修改链接信息
	 */
	public int updateLink(Links links) throws BizException {
		if(links.getFid() == 0) {
			throw new BizException(new Result(1002,"未选择任何友情链接！！！"));
		}
		if(backLinkBiz.selectLink(links).size() > 1) {
			throw new  BizException(new Result(1004,"该数据已存在！！！"));
		}
		return lm.updateByPrimaryKeySelective(links);
	}
	/**
	 * 添加链接信息
	 * @throws BizException 
	 */
	public int insertLink(Links links) throws BizException {
		if(!links.getFname().isEmpty() && links.getFname() != null && !links.getFurl().isEmpty() && links.getFurl() != null ) {
		}else {
			throw new  BizException(new Result(1001,"没有任何数据！！！"));
		}
		if(backLinkBiz.selectLink(links).size() > 0) {
			throw new  BizException(new Result(1004,"该数据已存在！！！"));
		}
		return lm.insertSelective(links);
	}
	/**
	 * 查询单条记录
	 * @throws BizException 
	 */
	public List<Links> selectLink(Links links) throws BizException {
		LinksExample lExample = new LinksExample();
		lExample.setOrderByClause("fid desc");
		lExample.createCriteria().andFnameEqualTo(links.getFname());
		lExample.createCriteria().andFurlEqualTo(links.getFurl());
		lExample.createCriteria().andFstatusEqualTo(1);
		 List<Links> list = lm.selectByExample(lExample);
		 return list;
	}
}
