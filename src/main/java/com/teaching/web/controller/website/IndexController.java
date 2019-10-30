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
     *
     * @return
     */
    @GetMapping("/website/index")
    public ModelAndView index(Map<String, Object> map,Model model) {

        model.addAttribute("msg","fads");

        return new ModelAndView("website/index", map);
    }


    /**
     *
     * @return
     */
    @GetMapping("/website/login")
    public ModelAndView login(Map<String, Object> map) {


        return new ModelAndView("website/login", map);
    }






}
