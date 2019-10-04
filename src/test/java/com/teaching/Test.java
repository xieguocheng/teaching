package com.teaching;

import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.Course;
import com.teaching.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/28 10:34
 */

public class Test extends TeachingApplicationTests{

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CommonService commonService;

    @org.junit.Test
    public void test01() throws  Exception{

        Map<String,Integer> map=courseMapper.selectForChartConstsClassify();
        System.out.println(map.get("qdkf"));







    }



}
