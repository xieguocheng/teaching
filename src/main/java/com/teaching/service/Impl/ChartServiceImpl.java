package com.teaching.service.Impl;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.Course;
import com.teaching.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    public CourseMapper courseMapper;

    @Autowired
    public AuthUserMapper authUserMapper;

    @Override
    public Integer[] getChartCourse() {

        List<String> CreateTimeList=new ArrayList<String>();
        List<Course> courseList=courseMapper.selectAll();
        courseList.forEach(course -> {
            CreateTimeList.add(new SimpleDateFormat("yyyy-MM").
                    format(course.getCreateTime()));
        });
        Integer time[]={0,0,0,0,0,0,0,0,0,0,0,0};
        CreateTimeList.forEach(createTime->{
            switch (createTime){
                case "2018-01":time[0]++;break;
                case "2019-02":time[1]++;break;
                case "2019-03":time[2]++;break;
                case "2019-04":time[3]++;break;
                case "2019-05":time[4]++;break;
                case "2019-06":time[5]++;break;
                case "2019-07":time[6]++;break;
                case "2019-08":time[7]++;break;
                case "2019-09":time[8]++;break;
                case "2019-10":time[9]++;break;
                case "2019-11":time[10]++;break;
                case "2019-12":time[11]++;break;
            }
        });

        return time;
    }

    @Override
    public Integer[] getChartUser() {
        List<String> CreateTimeList=new ArrayList<String>();
        List<AuthUser> userList=authUserMapper.selectAll();
        userList.forEach(user -> {
            CreateTimeList.add(new SimpleDateFormat("yyyy-MM").
                    format(user.getCreateTime()));
        });
        Integer time[]={0,0,0,0,0,0,0,0,0,0,0,0};
        CreateTimeList.forEach(createTime->{
            switch (createTime){
                case "2019-01":time[0]++;break;
                case "2019-02":time[1]++;break;
                case "2019-03":time[2]++;break;
                case "2019-04":time[3]++;break;
                case "2019-05":time[4]++;break;
                case "2019-06":time[5]++;break;
                case "2019-07":time[6]++;break;
                case "2019-08":time[7]++;break;
                case "2019-09":time[8]++;break;
                case "2019-10":time[9]++;break;
                case "2019-11":time[10]++;break;
                case "2019-12":time[11]++;break;
            }
        });
        return time;
    }
}
