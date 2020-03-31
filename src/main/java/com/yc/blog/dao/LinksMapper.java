package com.yc.blog.dao;

import com.yc.blog.bean.Links;
import com.yc.blog.bean.LinksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinksMapper {
    long countByExample(LinksExample example);

    int deleteByExample(LinksExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Links record);

    int insertSelective(Links record);

    List<Links> selectByExample(LinksExample example);

    Links selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Links record, @Param("example") LinksExample example);

    int updateByExample(@Param("record") Links record, @Param("example") LinksExample example);

    int updateByPrimaryKeySelective(Links record);

    int updateByPrimaryKey(Links record);
}