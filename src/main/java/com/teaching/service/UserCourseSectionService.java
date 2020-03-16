package com.teaching.service;

/**
 * @Author： XO
 * @Description：
 * @Date： 2020/3/12 22:17
 */

public interface UserCourseSectionService {

    /**
     * 添加用户学习记录
     * @param userId
     * @param sectionId
     * @return
     */
    void addUserCourseSection(Integer userId,Integer sectionId);

    /**
     * 是否存在一条记录
     * @param userId
     * @param sectionId
     * @return
     */
    Boolean existRecord(Integer userId,Integer sectionId);

}
