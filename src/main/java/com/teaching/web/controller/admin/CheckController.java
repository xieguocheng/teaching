package com.teaching.web.controller.admin;

import com.teaching.enums.CommonStatus;
import com.teaching.mapper.AuthTeacherMapper;
import com.teaching.pojo.AuthTeacher;
import com.teaching.pojo.Course;
import com.teaching.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Controller
public class CheckController {

    @Autowired
    private AuthTeacherMapper authTeacherMapper;


    /**
     * 审核课程列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/check/courseList")
    public String courselList(Model model){

        /*    Example example=new Example(ConstsSiteCarousel.class);
        example.createCriteria().andEqualTo("type",ConstsSiteCarouselStatus.TYPE_RECOMMEND.getValue());//免费课程
        example.orderBy("status").asc();
        example.orderBy("weight").asc();
        List<ConstsSiteCarousel> constsSiteCarouselList=constsSiteCarouselMapper.selectByExample(example);
        model.addAttribute("constsSiteCarouselList",constsSiteCarouselList);*/

        return "admin/check/check-course-list";
    }

    /**
     * 审核教师列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/check/teacherList")
    public String teacherList(Model model){

        Example example=new Example(AuthTeacher.class);
        example.createCriteria().andEqualTo("status",0);//查询所有未审核教师
        example.orderBy("createTime").asc();
        List<AuthTeacher> authTeacherList=authTeacherMapper.selectByExample(example);

        model.addAttribute("authTeacherList",authTeacherList);

        return "admin/check/check-teacher-list";

    }


    /**
     *  视频播放页面
     * @param model
     * @return
     */
    @GetMapping("admin/check/playVideo/{id}")
    public String playVideo(Model model,@PathVariable(name = "id") String id) {

        AuthTeacher authTeacher=new AuthTeacher();
        authTeacher.setId(Integer.valueOf(id));
        String video=authTeacherMapper.selectByPrimaryKey(authTeacher).getVideo();

        model.addAttribute("video",video);
        return "admin/course/video";
    }


    /**
     *  审核页面
     * @param model
     * @return
     */
    @GetMapping("admin/check/checkTeacher/{id}")
    public String checkTeacher(Model model,@PathVariable(name = "id") String id) {



        return "admin/check/check";
    }


    /**
     * 审核
     * @param id
     * @return
     */
    @PostMapping(value="admin/check/doCheck")
    @ResponseBody
    public ApiResponse courseLogicDelete(String id){

        /*try{
            Course course=courseService.findCourseById(Integer.valueOf(id));
            course.setDel(CommonStatus.DEL_YES.getValue());
            courseMapper.updateByPrimaryKey(course);
            return ApiResponse.ofSuccess(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }*/
        return null;
    }




}
