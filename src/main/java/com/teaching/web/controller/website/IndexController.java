package com.teaching.web.controller.website;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/3/31 11:06
 */

@Controller
public class IndexController {



    /**
     * 网站首页
     * @return
     */
    @GetMapping("/website/index")
    public ModelAndView index(Map<String, Object> map,Model model) {

        model.addAttribute("msg","fads");

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
