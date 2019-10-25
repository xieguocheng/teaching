package com.teaching.service;

public interface ChartService {

    /**
     * 课程月均量
     * @return
     */
    public Integer[] getChartCourse();

    /**
     * 用户日均量
     * @return
     */
    public Integer[] getChartUser();



}
