package com.teaching.web.controller.admin;

import com.teaching.enums.ConstsSiteCarouselStatus;
import com.teaching.mapper.ConstsSiteCarouselMapper;
import com.teaching.pojo.ConstsSiteCarousel;
import com.teaching.pojo.Course;
import com.teaching.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ConstsSiteCarouselController {
    @Autowired
    private ConstsSiteCarouselMapper constsSiteCarouselMapper;
    @Autowired
    private CourseService courseService;


    /**
     * 轮播列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/homepage/carouselList")
    public String carouselList(Model model){
        List<Course> courseList=courseService.findAllCourseFree();
        model.addAttribute("courseList",courseList);
        return "admin/homepage/carousel-list";

    }

    /**
     * 推荐课程列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/homepage/courseList")
    public String courselList(Model model,String type){

        if(type==null||type.equals("")){
            type="1";//默认查询免费课程
        }

        Example example=new Example(ConstsSiteCarousel.class);
        if(type.equals("1")){
            example.createCriteria().andEqualTo("type",ConstsSiteCarouselStatus.TYPE_FREE.getValue());//免费课程
        }
        if(type.equals("3")){
            example.createCriteria().andEqualTo("type",3);//实战课程
        }
        example.orderBy("status").asc();
        example.orderBy("weight").asc();
        List<ConstsSiteCarousel> constsSiteCarouselList=constsSiteCarouselMapper.selectByExample(example);
        model.addAttribute("constsSiteCarouselList",constsSiteCarouselList);

        return "admin/homepage/course-list";

    }

    /**
     * 推荐教师列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/homepage/teacherList")
    public String teacherList(Model model){

        Example example=new Example(ConstsSiteCarousel.class);
        example.createCriteria().andEqualTo("type",ConstsSiteCarouselStatus.TYPE_RECOMMEND.getValue());//免费课程
        example.orderBy("status").asc();
        example.orderBy("weight").asc();
        List<ConstsSiteCarousel> constsSiteCarouselList=constsSiteCarouselMapper.selectByExample(example);
        model.addAttribute("constsSiteCarouselList",constsSiteCarouselList);
        return "admin/homepage/teacher-list";

    }




}
