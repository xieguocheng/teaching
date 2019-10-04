package com.teaching.web.controller.admin;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/2 20:08
 */

@Controller
public class ChartController {


    @Autowired
    public CourseMapper courseMapper;

    @Autowired
    public AuthUserMapper authUserMapper;

    /**
     *chartConstsClassify
     * @return
     */
    @RequestMapping(value="admin/chart/chartConstsClassify")
    public String chartConstsClassify(Model model){

        Map<String,Integer> map=courseMapper.selectForChartConstsClassify();

        model.addAttribute("yjsdsj",map.get("yjsdsj"));
        model.addAttribute("hdkf",map.get("hdkf"));
        model.addAttribute("qdkf",map.get("qdkf"));
        model.addAttribute("sfkf",map.get("sfkf"));
        model.addAttribute("ydkf",map.get("ydkf"));
        model.addAttribute("sjk",map.get("sjk"));
        model.addAttribute("ywcs",map.get("ywcs"));
        model.addAttribute("uisjdmt",map.get("uisjdmt"));
        model.addAttribute("qyjs",map.get("qyjs"));
        model.addAttribute("jsjjc",map.get("jsjjc"));

        return "admin/chart/chart-constsClassify";
    }


    /**
     *chart-01
     * @return
     */
    @RequestMapping(value="admin/chart/chartUser")
    public String charUser(Model model){
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
        model.addAttribute("time",time);
        return "admin/chart/chart-user";
    }


    /**
     *chart-03
     * @return
     */
    @RequestMapping(value="admin/chart/chartCourse")
    public String chartCourse(Model model){

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
        model.addAttribute("time",time);

        return "admin/chart/chart-course";
    }

}
