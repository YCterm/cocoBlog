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
		return lm.updateByPrimaryKeySelective(links);
	}
}
