package com.teaching.service;

import com.teaching.utils.ServiceResult;

import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/28 11:11
 */

public interface CommonService {

    /**
     *通用计算Course,AuthUser,BbsArticle表的数量
     * @param o
     * @return
     * @throws Exception
     */
    public ServiceResult<Integer> count(Object o) throws Exception;

    /**
     *通用计算Course,AuthUser,BbsArticle日增量
     * @param o
     * @return
     * @throws Exception
     */
    public ServiceResult<Integer> dayVisit(Object o) throws Exception;









}
