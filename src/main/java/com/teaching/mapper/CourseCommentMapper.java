package com.teaching.mapper;


import com.teaching.pojo.CourseComment;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseCommentMapper extends MyMapper<CourseComment> {
}