package com.teaching.web.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.teaching.mapper.ConstsClassifyMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.ConstsClassify;
import com.teaching.pojo.Course;
import com.teaching.service.CourseService;
import com.teaching.utils.ApiResponse;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/19 21:50
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;

    @Autowired
    private CourseMapper courseMapper;



/******************************查询课程一些列操作************************************/

    /**
     *  免费课程页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseFreeList")
    public String courseFreeListPage(Model model) {
        List<Course> courseList=courseService.findAllCourseFree();
        model.addAttribute("courseList",courseList);
        return "admin/course/course-free-list";
    }
    /**
     *  实战课程页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseMoneyList")
    public String courseMoneyListPage(Model model) {
        List<Course> courseList=courseService.findAllCourseMoney();
        model.addAttribute("courseList",courseList);
        return "admin/course/course-money-list";
    }

    /**
     *  已删除的课程页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseRemoveList")
    public String courseRemoveListPage(Model model) {
        List<Course> courseList=courseService.findAllCourseDelete();
        model.addAttribute("courseList",courseList);
        return "admin/course/course-remove-list";
    }


    /**
     *  课程分类管理-整体页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseCategoryList/{id}")
    public String courseCategoryList(Model model,@PathVariable(name = "id",required = false) String id) {

        //渲染左边树
        List<ConstsClassify> constsClassifyList= constsClassifyMapper.selectAll();
        model.addAttribute("list",JSONArray.toJSON(constsClassifyList));
        //model.addAttribute("classify",id);//隐藏类目id
        //根据id查询类目下的所有课程
       // List<Course> courseList=courseService.findCourseByClassify(Integer.valueOf(id));
        //model.addAttribute("courseList",courseList);

        return "admin/course/category-course-list";
    }

    /**
     *  课程分类管理页面->右边表格页面iframe
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseCategoryIframe/{id}")
    public String courseCategoryIframe(Model model,@PathVariable(name = "id",required = false) String id) {

        model.addAttribute("classify",id);//隐藏类目id
        //根据id查询类目下的所有课程
        List<Course> courseList=courseService.findCourseByClassify(Integer.valueOf(id));

        model.addAttribute("courseList",courseList);
        return "admin/course/category-course-iframe";
    }


    /**
     * 搜索课程页面
     * @param model
     * @param course
     * @param request
     * @return
     */
    @GetMapping("/admin/course/search")
    public String search(Model model,Course course,HttpServletRequest request) throws Exception{

        model.addAttribute("classify",course.getClassify());//隐藏input类目id

        //开始搜索,封装service
        String startTime=request.getParameter("start_time");
        String endTime=request.getParameter("end_time");
        Integer classify=Integer.valueOf(course.getClassify());

        List<Course> courseList=courseService.findCourseByTimeAndNameAndClassify(startTime,endTime,course.getName(),classify);

        model.addAttribute("courseList",courseList);
        return "admin/course/category-course-iframe";
    }

    /**
     * 查看课程表基本详情
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value="admin/course/courseDetail/{id}")
    public String courseDetail(Model model,@PathVariable("id") String id){

        Course course=courseMapper.selectByPrimaryKey(new Course(Integer.valueOf(id)));
        model.addAttribute("course",course);
        return "admin/course/course-detail";
    }



    /***********************************************修改课程信息一系列操作*****************************************************************/


    /**
     * 修改课程权重
     * @param id
     * @param weight
     * @return
     */
    @GetMapping("/admin/course/updateWeight/{id}/{weight}")
    @ResponseBody
    public ApiResponse remove(@PathVariable(name = "id",required = false) String id,
                              @PathVariable(name = "weight",required = false) String weight){

        if(!UtilFuns.isNumeric(weight)){//不是数字
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }

        try{//格式错误
            Course course= new Course();
            course.setId(Integer.valueOf(id));
            course.setWeight(Integer.valueOf(weight));
            courseMapper.updateByPrimaryKeySelective(course);
            return ApiResponse.ofSuccess("");

        }catch (Exception e){

            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }

    }



    /**
     *  添加课程页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseAdd")
    public String courseAddPage(Model model) {

        return "admin/course/course-add";
    }

    /**
     * 课程图片上传页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/course-image")
    public String courseImage(Model model) {


        return "admin/course/image-upload";
    }




















}
