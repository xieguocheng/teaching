package com.teaching.web.controller.admin;

import com.teaching.enums.CommonStatus;
import com.teaching.enums.CourseStatus;
import com.teaching.mapper.AuthTeacherMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.AuthTeacher;
import com.teaching.pojo.Course;
import com.teaching.service.CourseService;
import com.teaching.utils.ApiResponse;
import com.teaching.utils.MailUtil;
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

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;


    /**
     * 待审核课程列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/check/courseList")
    public String courselList(Model model){

        List<Course> courseList=courseService.findAllCheckCourse();
        model.addAttribute("courseList",courseList);

        return "admin/check/check-course-list";
    }

    /**
     * 待审核教师列表
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
     * 查看待审核课程表基本详情
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value="admin/check/courseDetail/{id}")
    public String courseDetail(Model model,@PathVariable("id") String id){

        Course course=courseMapper.selectByPrimaryKey(new Course(Integer.valueOf(id)));
        model.addAttribute("course",course);
        return "admin/check/course-detail";
    }


    /**
     *  查看教师待审核视频播放页面
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

    /*****************************************************审核页面操作***************************************************/
    /**
     *  审核教师是否通过页面
     * @param model
     * @return
     */
    @GetMapping("admin/check/checkTeacher/{id}")
    public String checkTeacher(Model model,@PathVariable(name = "id") String id) {

        AuthTeacher authTeacher=new AuthTeacher(Integer.valueOf(id));
        authTeacher=authTeacherMapper.selectByPrimaryKey(authTeacher);
        model.addAttribute("email",authTeacher.getEmail());
        model.addAttribute("id",authTeacher.getId());

        return "admin/check/check";
    }


    /**
     * 审核教师
     * @param id
     * @param email
     * @param brief
     * @param status
     * @return
     */
    @PostMapping(value="admin/check/doCheckTeacher")
    @ResponseBody
    public ApiResponse doCheck(String id,String email,String brief,String status){
        try{
            //查询记录
            AuthTeacher authTeacher=new AuthTeacher(Integer.valueOf(id));
            authTeacher=authTeacherMapper.selectByPrimaryKey(authTeacher);
            //更新
            authTeacher.setStatus(Integer.valueOf(status));
            authTeacherMapper.updateByPrimaryKey(authTeacher);
            //发送邮件
            MailUtil.sendMessage(email,"智慧教学视频网站审核通知",brief);
            return ApiResponse.ofSuccess(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }

    }

    /**
     * 审核课程
     * @param id
     * @return
     */
    @PostMapping(value="admin/check/doCheckCourse")
    @ResponseBody
    public ApiResponse doCheckCourse(String id,String status){
        try{

            Course course=new Course(Integer.valueOf(id));
            course=courseMapper.selectByPrimaryKey(course);

            course.setStatus(Integer.valueOf(status));
            courseMapper.updateByPrimaryKey(course);

            return ApiResponse.ofSuccess(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }

    }




}
