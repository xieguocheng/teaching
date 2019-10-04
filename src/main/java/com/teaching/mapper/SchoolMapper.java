package com.teaching.mapper;


import com.teaching.pojo.School;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchoolMapper extends MyMapper<School> {
}