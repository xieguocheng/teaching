package com.teaching.mapper;


import com.teaching.pojo.CourseSection;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseSectionMapper extends MyMapper<CourseSection> {


    /**
     * 获取课程章最大的sort
     */
    public Integer getMaxSort(Integer courseId);

    //查询最新插入的id（最大）
    public Integer selectMaxId();


}