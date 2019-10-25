package com.teaching.web.controller.admin;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.Course;
import com.teaching.service.ChartService;
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

    @Autowired
    private ChartService chartService;

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
        Integer time[]=chartService.getChartUser();
        model.addAttribute("time",time);
        return "admin/chart/chart-user";
    }


    /**
     *chart-03
     * @return
     */
    @RequestMapping(value="admin/chart/chartCourse")
    public String chartCourse(Model model){

        Integer time[]=chartService.getChartCourse();

        model.addAttribute("time",time);

        return "admin/chart/chart-course";
    }







}
