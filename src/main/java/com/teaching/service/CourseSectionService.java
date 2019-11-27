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
     * 通过课程id查看章节,包含未上架,上架的
     * @param courseId
     * @return
     */
    public List<CourseSection> findCourseSectionByCourseId(Integer courseId);

    /**
     * 通过课程id查看章节是否上架
     * @param courseId
     * @param onsale
     * @return
     */
    public List<CourseSection> findCourseSectionOnsale(Integer courseId,Integer onsale);

    /**
     * 获取课程章节,用于渲染
     */
    List<CourseSectionVO> queryCourseSection(Integer courseId);

}
