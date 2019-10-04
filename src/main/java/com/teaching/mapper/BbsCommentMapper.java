package com.teaching.mapper;


import com.teaching.pojo.BbsComment;
import com.teaching.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsCommentMapper extends MyMapper<BbsComment> {
}