package com.teaching.mapper;


import com.teaching.pojo.AuthUser;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthUserMapper extends MyMapper<AuthUser> {

    //查询日增长量
    public Integer selectDayVisit();


}