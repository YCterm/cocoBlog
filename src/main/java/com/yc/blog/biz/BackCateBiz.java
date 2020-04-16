package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.dao.CategoryMapper;
import com.yc.blog.vo.Result;
import com.yc.blog.vo.Ztree;

@Service
public class BackCateBiz {

	@Resource
	private CategoryMapper cam;
	@Resource
	private BackCateBiz bcb;
	
	/**
	 * 查询所有的类型数据
	 */
	public List<Category> selectCates( CategoryExample category) {
		return cam.selectByExample(category);
	}
	/**
	 * 修改分类状态
	 * @throws BizException 
	 */
	public int updateState(String state,String cateid) throws BizException {
		if(  cateid == null || cateid.isEmpty()) {
			throw new BizException(new Result(1001,"未选择任何数据！！！"));
		}
		Category cate = cam.selectByPrimaryKey(Integer.parseInt(cateid));
		if( cate.getSupercateid() == null || cate.getSupercateid() ==0) {
			throw new BizException(new Result(1005,"不能修改主分类状态！！！"));
		}
		Category category = new Category();
		category.setCateid(Integer.parseInt(cateid));
		category.setCatestatus(Integer.parseInt(state));
		return cam.updateByPrimaryKeySelective(category);
		
	}
	/**
	 * 修改分类
	 * @throws BizException 
	 */
	public int update(Category category) throws BizException {
		CategoryExample ce;
		List<Category> list ;
		if(category.getSupercateid()!= null && category.getSupercateid() != 0)  {
			ce = new CategoryExample();
			ce.createCriteria().andCateidEqualTo(category.getSupercateid());
			list = bcb.selectCates(ce);
			if(list.size() <= 0 ) {
				throw new BizException(new Result(1004,"父类型不存在！！！"));
			}
		}
		if(!category.getCatename().isEmpty() && category.getCatename() != null) {
			ce = new CategoryExample();
			ce.createCriteria().andCatenameEqualTo(category.getCatename());
			list = bcb.selectCates(ce);
			if(list.size() > 1 ) {
				throw new BizException(new Result(1004,"该类型已存在！！！"));
			}
		}
		return cam.updateByPrimaryKeySelective(category);
	}
	
	/**
	 * 查询所有类型并返回ztree结果集
	 */
	public String selectAll() {
		CategoryExample example = new CategoryExample();
		Ztree ztree = new Ztree();
		return ztree.getZtree(cam.selectByExample(example));
	}
	/**
	 * 添加分类
	 * @throws BizException 
	 */
	public int insert(String surid,String kidname) throws BizException {
		CategoryExample ce;
		List<Category> list ;
		Category category = new Category();
		if(!surid.isEmpty() &&surid != null) {
			ce = new CategoryExample();
			ce.createCriteria().andCateidEqualTo(Integer.parseInt(surid));
			list = bcb.selectCates(ce);
			if(list.size() <= 0 ) {
				throw new BizException(new Result(1004,"父类型不存在！！！"));
			}
			category.setSupercateid(list.get(0).getCateid());
		}
		if(!kidname.isEmpty() &&kidname != null) {
			ce = new CategoryExample();
			ce.createCriteria().andCatenameEqualTo(kidname);
			list = bcb.selectCates(ce);
			if(list.size() > 0 ) {
				throw new BizException(new Result(1004,"该类型已存在！！！"));
			}
			category.setCatename(kidname);
		}
		category.setCatestatus(1);
		return cam.insert(category);
	}
}
