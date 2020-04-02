package com.yc.blog.dao;

import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
	List<Article> getGroupArtSize(@Param("array") List<Integer> array);

	List<Article> getGroupArt(@Param("array") List<Integer> array, @Param("page") int page,@Param("artnumber") int artnumber);

	List<Article> getGroupHotArt(@Param("array") List<Integer> array,@Param("hotartnumber") int hotartnumber);
	
	long countByExample(ArticleExample example);

	int deleteByExample(ArticleExample example);

	int deleteByPrimaryKey(Integer artid);

	int insert(Article record);

	int insertSelective(Article record);

	List<Article> selectByExampleWithBLOBs(ArticleExample example);

	List<Article> selectByExample(ArticleExample example);

	Article selectByPrimaryKey(Integer artid);

	int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(Article record);

	int updateByPrimaryKey(Article record);
}