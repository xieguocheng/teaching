package com.teaching.web.controller.website;



import com.teaching.enums.ConstsSiteCarouselStatus;
import com.teaching.enums.CourseStatus;
import com.teaching.mapper.ConstsClassifyMapper;
import com.teaching.mapper.ConstsSiteCarouselMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.ConstsClassify;
import com.teaching.pojo.ConstsSiteCarousel;
import com.teaching.pojo.Course;
import com.teaching.pojo.CourseSection;
import com.teaching.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/3/31 11:06
 */

@Controller
public class IndexController {

    @Autowired
    private ConstsSiteCarouselMapper constsSiteCarouselMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;

    /**
     * 网站首页
     * @return
     */
    @GetMapping("/website/index")
    public ModelAndView index(Map<String, Object> map,Model model) {
        //免费课程
       List<ConstsSiteCarousel> freeCourse1=new ArrayList<>();
        List<ConstsSiteCarousel> freeCourse2=new ArrayList<>();

        Example example=new Example(ConstsSiteCarousel.class);
        example.createCriteria().andEqualTo("type",ConstsSiteCarouselStatus.TYPE_FREE.getValue());//免费课程
        example.orderBy("status").asc();
        example.orderBy("weight").asc();
        List<ConstsSiteCarousel> freeCourseList=constsSiteCarouselMapper.selectByExample(example);
        for(int i=0;i<4;i++){
            freeCourse1.add(freeCourseList.get(i));
        }
        model.addAttribute("freeCourse1",freeCourse1);
        model.addAttribute("freeCourse2",freeCourse1);

        //实战课程
        List<ConstsSiteCarousel> moneyCourseList1=new ArrayList<>();
        List<ConstsSiteCarousel> moneyCourseList2=new ArrayList<>();
        Example example1=new Example(ConstsSiteCarousel.class);
        example1.createCriteria().andEqualTo("type",3);//实战课程
        example1.orderBy("status").asc();
        example1.orderBy("weight").asc();
        List<ConstsSiteCarousel> moneyCourseList=constsSiteCarouselMapper.selectByExample(example1);
        for(int i=0;i<4;i++){
            moneyCourseList1.add(moneyCourseList.get(i));
        }
        model.addAttribute("moneyCourseList1",moneyCourseList1);
        model.addAttribute("moneyCourseList2",moneyCourseList1);

        //系统推荐
        List<Course> systemCourseList1=new ArrayList<>();
        Example example2=new Example(Course.class);
        example2.createCriteria().andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue());//审核成功
        example2.orderBy("studyCount").asc();
        List<Course> systemCourseList=courseMapper.selectByExample(example2);
        for(int i=0;i<5;i++){
            systemCourseList1.add(systemCourseList.get(i));
        }
        model.addAttribute("systemCourseList1",systemCourseList1);

        return new ModelAndView("website/index", map);
    }

    /**
     * 网站所有课程
     * @return
     */
    @GetMapping("/website/course")
    public ModelAndView course(Map<String, Object> map,Model model) {

        //类目
        List<ConstsClassify> treeList=constsClassifyMapper.getTree();
        model.addAttribute("treeList",treeList);
        //
        //系统推荐
        Example example2=new Example(Course.class);
        example2.createCriteria().andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue());//审核成功
        example2.orderBy("studyCount").asc();
        List<Course> courseList=courseMapper.selectByExample(example2);
        model.addAttribute("courseList",courseList);

        return new ModelAndView("website/course", map);
    }

    @RequestMapping("website/course/list")
    @ResponseBody
    public ApiResponse courseSectionList(Model model) {

        Example example2=new Example(Course.class);
        example2.createCriteria().andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue());//审核成功
        example2.orderBy("studyCount").asc();
        List<Course> courseList=courseMapper.selectByExample(example2);

        return new ApiResponse(0,"ok",courseList);
    }


    /**
     * 网站课程智慧推荐
     * @return
     */
    @GetMapping("/website/recommend")
    public ModelAndView recommend(Map<String, Object> map,Model model) {

        return new ModelAndView("website/recommend", map);
    }

    /**
     * 网站课程智慧推荐
     * @return
     */
    @GetMapping("/website/bbs")
    public ModelAndView bbs(Map<String, Object> map,Model model) {

        return new ModelAndView("website/bbs", map);
    }

    /**
     * 网站课程智慧推荐
     * @return
     */
    @GetMapping("/website/about")
    public ModelAndView about(Map<String, Object> map,Model model) {

        return new ModelAndView("website/about", map);
    }


    /**
     * 网站登录页面
     * @return
     */
    @GetMapping("/website/login")
    public ModelAndView login(Map<String, Object> map) {


        return new ModelAndView("website/login", map);
    }

    /**
     * 网站注册页面
     * @return
     */
    @GetMapping("/website/register")
    public ModelAndView register(Map<String, Object> map) {


        return new ModelAndView("website/register", map);
}


    /**
     * 网站注册页面
     * @return
     */
    @GetMapping("/website/shopcart")
    public ModelAndView shopcart(Map<String, Object> map) {


        return new ModelAndView("website/shopcart", map);
    }




}
