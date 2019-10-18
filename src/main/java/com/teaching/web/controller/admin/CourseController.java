package com.teaching.web.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import com.teaching.dto.QiNiuPutRet;
import com.teaching.mapper.ConstsClassifyMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.ConstsClassify;
import com.teaching.pojo.Course;
import com.teaching.service.CourseService;
import com.teaching.service.QiNiuService;
import com.teaching.utils.ApiResponse;
import com.teaching.utils.IDUtils;
import com.teaching.utils.UtilFuns;
import com.teaching.utils.VideoUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/19 21:50
 */
@Controller
@Slf4j
public class CourseController {

    @Value("${qiniu.cdn.prefix}")
    private String prefix;


    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private CourseService courseService;

    @Autowired
    private QiNiuService qiNiuService;

    @Autowired
    private Gson gson;

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
     *  添加课程-基本信息页面
     * @param model
     * @return
     */
    @GetMapping("admin/course/courseAdd")
    public String courseAddPage(Model model) {

        Example example=new Example(ConstsClassify.class);
        example.createCriteria().andEqualTo("parentId",0);
        List<ConstsClassify> classifyList=constsClassifyMapper.selectByExample(example);
        model.addAttribute("classifyList",classifyList);

        Example example2=new Example(ConstsClassify.class);
        example2.createCriteria().andNotEqualTo("parentId",0);
        List<ConstsClassify> subClassifyList=constsClassifyMapper.selectByExample(example2);
        model.addAttribute("subClassifyList",subClassifyList);

        return "admin/course/course-add";
    }

    /**
     * 新增课程-先上传图片，再插入数据
     * @param course
     */
    @PostMapping(value="admin/course/addCourse",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse addCourse(Course course,MultipartFile pictureImg){

        String fileName = IDUtils.getImageName()+"/"+pictureImg.getOriginalFilename();//设置文件名路径名字：courseid/userid/文件名字
        QiNiuPutRet ret;

        //1.先上传图片
        if (pictureImg.isEmpty()) {//判断是否有选择图片
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }
        try {
            InputStream inputStream = pictureImg.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream,fileName);//上传文件用inputStream方式到七牛云，失败就重复3次
            if (response.isOK()) {
                ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);//使用自定义的qiNiuPutRet【如果上传成功返回gson数据，内含重要的图片信息key】
                log.info("七牛云图片上传："+ret);
                //return ApiResponse.ofSuccess(defaultPutRet);
            } else {
                return ApiResponse.ofMessage(response.statusCode, response.getInfo());//失败返回错误码和错误信息
            }
        } catch (QiniuException e) {
            Response response = e.response;
            try {
                return ApiResponse.ofMessage(response.statusCode, response.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
                return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
        }

        //2.添加课程到数据库
        Course newCourse=modelMapper.map(course,Course.class);
        newCourse.setUserId(1);//TODO
        newCourse.setClassifyName(constsClassifyMapper.selectByPrimaryKey(Integer.valueOf(course.getClassify())).getName());
        newCourse.setSubClassifyName(constsClassifyMapper.selectByPrimaryKey(Integer.valueOf(course.getSubClassify())).getName());
        newCourse.setPicture(prefix+ret.getKey());
        newCourse.setStatus(2);//管理员新增默认审核通过
        log.info("新增课程数据："+newCourse);

        courseMapper.insertSelective(newCourse);
        //3.获取最新插入的课程id
        Integer id=courseMapper.selectMaxId();

        return ApiResponse.ofSuccess(id);
    }


    /**
     * 查看用户详情
     * @param model
     * @param videoUrl
     * @return
     */
    @GetMapping(value="admin/course/playVideo/{videoUrl}")
    public String userDetail(Model model,@PathVariable("videoUrl") String videoUrl){


        model.addAttribute("videoUrl","http://learn.wushirui.cn/20191014_173145.mp4");


        return "admin/course/video";
    }


























}
