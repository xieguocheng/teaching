package com.teaching.web.controller.website;

import com.qiniu.util.Auth;
import com.teaching.dto.CourseSectionVO;
import com.teaching.enums.CourseCommentStatus;
import com.teaching.enums.UserBehaviorStatus;
import com.teaching.mapper.*;
import com.teaching.pojo.*;
import com.teaching.service.CourseSectionService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebCourseController {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private AuthUserMapper authUserMapper;
    @Autowired
    private  UserCourseSectionMapper userCourseSectionMapper;
    @Autowired
    private CourseSectionMapper courseSectionMapper;
    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private CourseSectionService courseSectionService;
    @Autowired
    private UserFollowMapper userFollowMapper;
    @Autowired
    private UserBehaviorMapper userBehaviorMapper;


    /**
     * 查看课程表基本详情
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value="/website/course/courseDetail/{id}")
    public String courseDetail(HttpServletRequest request,Model model, @PathVariable("id") String id){

        //1.获取课程
        Course course=courseMapper.selectByPrimaryKey(new Course(Integer.valueOf(id)));
        if(null == course)
            return "404";
        model.addAttribute("course",course);

        //2.获取课程章节
        List<CourseSectionVO> chaptSections = courseSectionService.queryCourseSection(Integer.valueOf(id));
        model.addAttribute("chaptSections", chaptSections);

        //3.获取教师信息
        AuthUser authUser=authUserMapper.selectByPrimaryKey(new AuthUser(course.getUserId()));
        School school=schoolMapper.selectByPrimaryKey(new School(authUser.getSchool()));
        model.addAttribute("courseTeacher",authUser);
        if(school==null){
            model.addAttribute("schoolName",null);
        }else {
            model.addAttribute("schoolName",school.getName());
        }

        //4.获取推荐课程
        Example example=new Example(Course.class);
        Example.Criteria criteria=example.createCriteria();
        if(UtilFuns.isNotEmpty(course.getSubClassify())){
            criteria.andEqualTo("subClassify",course.getSubClassify());
        }
        example.orderBy("weight").desc();
        List<Course> courseList=courseMapper.selectByExample(example);
        if(UtilFuns.isNotEmpty(courseList)&&courseList.size()>=6){//放6个
            List<Course> temp=new ArrayList<>();
            for(int i=0;i<6;i++){
                temp.add(courseList.get(i));
            }
            model.addAttribute("recomdCourseList",temp);
        }else{
            model.addAttribute("recomdCourseList",courseList);
        }

        //5.查看是否关注了
        // 5.1获取登录用户，如果未登录直接返回页面
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            if (auth instanceof AnonymousAuthenticationToken) {
                model.addAttribute("collectionFlag",null);
                model.addAttribute("followFlag",null);
                model.addAttribute("curCourseSection",null);
                return "website/course-detail";
            }
        }
        //5.2设置是否关注了
        AuthUser loginUser= (AuthUser) auth.getPrincipal();
        Example e=new Example(UserFollow.class);
        Example.Criteria c=e.createCriteria();
        c.andEqualTo("userId",loginUser.getId()).andEqualTo("followId",authUser.getId());
        List<UserFollow> userFollowList=userFollowMapper.selectByExample(e);
        if(UtilFuns.isNotEmpty(userFollowList)){
            model.addAttribute("followFlag",true);
        }else {
            model.addAttribute("followFlag",null);
        }
        //6.设置是否收藏了
        Example example1=new Example(UserBehavior.class);
        Example.Criteria criteria1=example1.createCriteria();
        criteria1.andEqualTo("userId",loginUser.getId()).
                andEqualTo("courseId",id).
                andEqualTo("type",UserBehaviorStatus.TYPE_COLLECTION.getValue());
        List<UserBehavior> userBehaviorList=userBehaviorMapper.selectByExample(example1);
        if(UtilFuns.isNotEmpty(userBehaviorList)){
            model.addAttribute("collectionFlag",true);
        }else {
            model.addAttribute("collectionFlag",null);
        }

        //7.设置当前学习的章节
        Example em=new Example(UserCourseSection.class);
        Example.Criteria cr=em.createCriteria();
        cr.andEqualTo("courseId",course.getId())
                .andEqualTo("userId",loginUser.getId());
        em.orderBy("updateTime").desc();
        List<UserCourseSection> list=userCourseSectionMapper.selectByExample(em);
        if(UtilFuns.isNotEmpty(list)){
            CourseSection curCourseSection=courseSectionMapper.
                    selectByPrimaryKey(new CourseSection(list.get(0).getSectionId()));
            model.addAttribute("curCourseSection",curCourseSection);
        }

        return "website/course-detail";
    }


}
