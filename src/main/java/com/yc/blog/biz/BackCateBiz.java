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
	 * 查询所有类型
	 */
	public String selectAll() {
		CategoryExample example = new CategoryExample();
		Ztree ztree = new Ztree();
		return ztree.getZtree(cam.selectByExample(example));
	}
	/**
	 * 查询所有的类型数据
	 */
	public List<Category> selectCates( CategoryExample category) {
		return cam.selectByExample(category);
	}
	/**
	 * 添加分类
	 * @throws BizException 
	 */
	public int insert(String surname,String kidname) throws BizException {
		CategoryExample ce;
		List<Category> list ;
		Category category = new Category();
		if(!surname.isEmpty() &&surname != null) {
			ce = new CategoryExample();
			ce.createCriteria().andCatenameEqualTo(surname);
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
	/**
	 * 修改分类
	 * @throws BizException 
	 */
	public int update(String surname,String kidname,String state) throws BizException {
		CategoryExample ce;
		List<Category> list ;
		Category category = new Category();
		if(!surname.isEmpty() &&surname != null) {
			ce = new CategoryExample();
			ce.createCriteria().andCatenameEqualTo(surname);
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
			if(list.size() > 1 ) {
				throw new BizException(new Result(1004,"该类型已存在！！！"));
			}
			category.setCatename(kidname);
		}
		category.setCatestatus(Integer.parseInt(state));
		return cam.updateByPrimaryKeySelective(category);
	}
}
