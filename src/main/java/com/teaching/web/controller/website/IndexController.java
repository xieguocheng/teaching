package com.teaching.web.controller.website;



import com.teaching.enums.ConstsSiteCarouselStatus;
import com.teaching.mapper.ConstsSiteCarouselMapper;
import com.teaching.pojo.ConstsSiteCarousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

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

    /**
     * 网站首页
     * @return
     */
    @GetMapping("/website/index")
    public ModelAndView index(Map<String, Object> map,Model model) {

        Example example=new Example(ConstsSiteCarousel.class);
        example.createCriteria().andEqualTo("type",ConstsSiteCarouselStatus.TYPE_FREE.getValue());//免费课程
        example.orderBy("status").asc();
        example.orderBy("weight").asc();
        List<ConstsSiteCarousel> freeCourseList=constsSiteCarouselMapper.selectByExample(example);
        model.addAttribute("freeCourseList",freeCourseList);

        Example example1=new Example(ConstsSiteCarousel.class);
        example.createCriteria().andEqualTo("type",3);//实战课程
        example1.orderBy("status").asc();
        example1.orderBy("weight").asc();
        List<ConstsSiteCarousel> moneyCourseList=constsSiteCarouselMapper.selectByExample(example);
        model.addAttribute("moneyCourseList",moneyCourseList);

        return new ModelAndView("website/index", map);
    }

    /**
     * 网站所有课程
     * @return
     */
    @GetMapping("/website/course")
    public ModelAndView course(Map<String, Object> map,Model model) {

        return new ModelAndView("website/course", map);
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
