package com.teaching.service;

import com.teaching.dto.CourseSectionVO;
import com.teaching.pojo.CourseSection;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/3 17:45
 */

public interface CourseSectionService {

    /**
     * 批量添加
     * @param courseSections
     */
    public void batchAdd(List<CourseSectionVO> courseSections);

    /**
     * 通过课程id查看章节
     * @param courseId
     * @return
     */
    public List<CourseSection> findCourseSectionByCourseId(Integer courseId);

}
