package com.teaching.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by xo
 */
@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        //TODO 待改善
        return "redirect:admin/center";
        //return "index.html";
    }

    @GetMapping("/logout/page")
    public String logoutPage() {
        return "logout";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }









}
