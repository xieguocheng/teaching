package com.teaching.mapper;

import com.teaching.pojo.ConstsClassify;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConstsClassifyMapper extends MyMapper<ConstsClassify> {

    //查询日增长量
    public List<ConstsClassify> getTree();

}