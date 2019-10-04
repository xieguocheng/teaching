package com.teaching.mapper;


import com.teaching.pojo.BbsArticle;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsArticleMapper extends MyMapper<BbsArticle> {


    //查询日增长量
    public Integer selectDayVisit();
}