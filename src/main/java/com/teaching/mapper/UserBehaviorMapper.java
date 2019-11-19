package com.teaching.mapper;


import com.teaching.pojo.UserBehavior;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserBehaviorMapper extends MyMapper<UserBehavior> {

    public List<UserBehavior> getUserBehavior();



}