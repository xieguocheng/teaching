package com.teaching.mapper;


import com.teaching.pojo.Course;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper extends MyMapper<Course> {


    //查询日增长量
    public Integer selectDayVisit();

    //根据classifyName统计课程数量
    public Map<String,Integer> selectForChartConstsClassify();


}