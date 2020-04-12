package com.yc.blog.vo;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.yc.blog.bean.Category;

/**
 * ztree节点初始化
 * 
 * @author psq
 *
 */
public class Ztree {

	private String id;
	private String name;
	private String pid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getZtree(List<Category> category) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		// 第一级数据（根节点）
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("open", true); // 根节点展开
		map.put("id", 1);// 根节点的ID
		map.put("pId", 0);// 根节点的ID
		map.put("name", "博文分类列表"); // 根节点的名字
		resultList.add(map); // 列表中先添加第一级的数据
		// 第二级数据（下级）
		Map<String, Object> map1 ;
		for (Category c : category) {
			map1 = new HashMap<String, Object>();
			if (c.getSupercateid() == null || c.getSupercateid() == 0) {
				map1.put("id", c.getCateid());
				map1.put("pId", 1);
				map1.put("name", c.getCatename());
				resultList.add(map1);
			} else {
				map1.put("id", c.getCateid());
				map1.put("pId", c.getSupercateid());
				map1.put("name", c.getCatename());
				resultList.add(map1);
			}
		}
		return JSON.toJSONString(resultList);
	}
}
