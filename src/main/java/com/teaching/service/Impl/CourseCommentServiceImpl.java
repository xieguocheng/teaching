package com.teaching.service.Impl;

import com.teaching.enums.CommonStatus;
import com.teaching.enums.CourseCommentStatus;
import com.teaching.mapper.CourseCommentMapper;
import com.teaching.pojo.CourseComment;
import com.teaching.pojo.UserCourseSection;
import com.teaching.service.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CourseCommentServiceImpl implements CourseCommentService {

    @Autowired
    private CourseCommentMapper courseCommentMapper;

    @Override
    public List<CourseComment> findCourseCommentByCourseId(Integer courseId) {
        Example example=new Example(CourseComment.class);
        example.orderBy("sectionId").desc();
        example.createCriteria().andEqualTo("courseId",courseId)
                .andEqualTo("type",CourseCommentStatus.TYPE_COMMENT.getValue());
        return courseCommentMapper.selectByExample(example);
    }

    @Override
    public List<CourseComment> findCourseAnswerByCourseId(Integer courseId) {
        Example example=new Example(CourseComment.class);
        example.orderBy("sectionId").desc();
        example.createCriteria().andEqualTo("courseId",courseId)
                .andEqualTo("type",CourseCommentStatus.TYPE_ANSWER.getValue());
        return courseCommentMapper.selectByExample(example);
    }
}
