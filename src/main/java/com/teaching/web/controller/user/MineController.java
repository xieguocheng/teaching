package com.teaching.web.controller.user;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/11/03 11:06
 */

@Controller
public class MineController {



    /**
     * 主页
     * @return
     */
    @GetMapping("/user/home")
    public ModelAndView index(Map<String, Object> map,Model model) {

        model.addAttribute("msg","fads");

        return new ModelAndView("user/home", map);
    }

    /**
     * 我的设置
     * @return
     */
    @GetMapping("/user/setting")
    public ModelAndView setting(Map<String, Object> map,Model model) {

        model.addAttribute("msg","fads");

        return new ModelAndView("user/setting", map);
    }




}
