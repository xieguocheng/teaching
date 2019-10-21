package com.teaching.service;

import com.teaching.pojo.CourseComment;
import com.teaching.pojo.CourseSection;

import java.util.List;

public interface CourseCommentService {

    /**
     * 根据课程id查询所有课程评论
     * @param courseId
     * @return
     */
    public List<CourseComment> findCourseCommentByCourseId(Integer courseId);

    /**
     * 根据课程id查询所有课程答疑
     * @param courseId
     * @return
     */
    public List<CourseComment> findCourseAnswerByCourseId(Integer courseId);

}
