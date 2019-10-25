package com.teaching.web.controller.admin;



import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.BbsArticleMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.BbsArticle;
import com.teaching.pojo.Course;
import com.teaching.service.ChartService;
import com.teaching.service.CommonService;
import com.teaching.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/3/31 11:06
 */

@Controller
public class AdminController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private ChartService chartService;



    /**
     * 管理员登录页,如果登录过的用户重新访问登录会跳转到管理中心页面
     * 除非用户退出才可以重新登录
     * @return
     */
    @GetMapping("/admin/login")
    public String adminLogin() {
        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth instanceof AnonymousAuthenticationToken){
            return "admin/login";
        }else{
            return "redirect:/admin/center";
        }*/
        return "/admin/login";
    }

    /**
     * 切换账号页面，同时会退出当前账号，我也不知道为什么
     * 可以防止已经登录的账号想要进入登录界面被跳转到后台中心
     * @return
     */
    @GetMapping("/admin/switchAccount")
    public String switchAccount() {

       // return "redirect:/logout";
        return "/admin/login";
    }

    /**
     * 进入后台管理中心
     * @return
     */
    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }


    /**
     * 进入后台页面，测试用的，后面要删了
     * @return
     */
    /*@PostMapping("login")
    public String admin() {
        return "admin/center";
    }*/


    /*@GetMapping(value = "sms/code")
    @ResponseBody
    public ApiResponse smsCode(@RequestParam("telephone") String telephone) {

        if (!LoginUserUtil.checkTelephone(telephone)) {
            return ApiResponse.ofMessage(HttpStatus.BAD_REQUEST.value(),
                    "请输入正确的手机号");
        }

        UserSuper userSuper=userSuperService.findUserSuperByTelephone(telephone);
        if (userSuper == null) { // 如果没有该管理员，就直接抛出异常
            //user = userService.addUserByPhone(telephone);
            return ApiResponse.ofMessage(HttpStatus.BAD_REQUEST.value(),
                    "没有该账号,省点钱，就不发短信浪费你时间了");
        }
        ServiceResult<String> result = smsService.sendSms(telephone);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess("");
        } else {
            return ApiResponse.ofMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
        }

    }*/




    /**
     * 进入后台管理中-欢迎页
     * @return
     */
    @GetMapping("/admin/welcome")
    public String welcomePage(Model model) throws Exception{

        //统计数量
        ServiceResult<Integer> courseResult= commonService.count(new Course());
        ServiceResult<Integer> authUserResult= commonService.count(new AuthUser());
        ServiceResult<Integer> bbsResult= commonService.count(new BbsArticle());
        model.addAttribute("courseCount",courseResult.getResult());
        model.addAttribute("authUserCount",authUserResult.getResult());
        model.addAttribute("bbsArticleCount",bbsResult.getResult());

        //统计日增量
        ServiceResult<Integer> courseVisit= commonService.dayVisit(new Course());
        ServiceResult<Integer> authUserVisit= commonService.dayVisit(new AuthUser());
        ServiceResult<Integer> bbsVisit= commonService.dayVisit(new BbsArticle());
        model.addAttribute("courseVisit",courseVisit.getResult());
        model.addAttribute("authUserVisit",authUserVisit.getResult());
        model.addAttribute("bbsVisit",bbsVisit.getResult());

        //柱状图
        Integer course[]=chartService.getChartCourse();
        model.addAttribute("course",course);

        Integer user[]=chartService.getChartUser();
        model.addAttribute("user",user);



        return "admin/welcome";
    }

    @GetMapping("admin/feedback/feedbackList")
    public String questionListPage(){

        return "admin/feedback/feedback-list";
    }



}
