package com.teaching.service;

import com.teaching.dto.CourseSectionVO;

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

}
