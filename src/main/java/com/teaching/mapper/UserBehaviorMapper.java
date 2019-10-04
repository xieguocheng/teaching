package com.teaching.mapper;


import com.teaching.pojo.UserBehavior;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBehaviorMapper extends MyMapper<UserBehavior> {
}