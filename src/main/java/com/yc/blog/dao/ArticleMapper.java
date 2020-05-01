package com.yc.blog.dao;

import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.bean.container.TimeBean;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Query;

public interface ArticleMapper {
	@Select("select * from article where title like concat('%',#{title},'%')")
	  Object selectByName(@Param("title") String title);

	
	@Update("UPDATE article SET readcnt = readcnt + 1 WHERE artid = #{artid}")
	void updateReadcnt(@Param("artid") int artid);
	
	List<Article> getGroupArtArticle(@Param("array") List<Integer> array, @Param("page") int page,
			@Param("ART_NUMBER") int ART_NUMBER, @Param("time") String time);

	List<Article> getGroupAllArtSize(@Param("array") List<Integer> array, @Param("time") String time);

	List<Article> getGroupHotArticle(@Param("array") List<Integer> array, @Param("HOTRANKING") int HOTRANKING);

	List<TimeBean> getTimeList(@Param("cateid") int cateid, @Param("TIMECLASSIFICATION") int TIMECLASSIFICATION);

	List<TimeBean> getGroupTimeList(@Param("array") List<Integer> array,
			@Param("TIMECLASSIFICATION") int TIMECLASSIFICATION);
	
	List<Article> getRandomArticle();
	
	List<Article> getMostArticle();
	
	@Select(value = { "SELECT * FROM article WHERE cateid = #{cateid,jdbcType=INTEGER} ORDER BY RAND() LIMIT 5" })
	List<Article> getRecommendArticle(@Param("cateid") int cateid);
	
	Article getPrevArticle(@Param("number") int number);
	
	Article getNextArticle(@Param("number") int number);

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