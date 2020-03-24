package com.teaching.web.controller.user;

import com.teaching.dto.CourseSectionVO;
import com.teaching.enums.CourseCommentStatus;
import com.teaching.enums.UserBehaviorStatus;
import com.teaching.mapper.*;
import com.teaching.pojo.*;
import com.teaching.service.CourseSectionService;
import com.teaching.service.CourseService;
import com.teaching.service.UserCourseSectionService;
import com.teaching.service.UserFollowsService;
import com.teaching.utils.ApiResponse;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2020/3/14 18:13
 */
@Controller
public class CollectionsController {


    @Autowired
    private UserBehaviorMapper userBehaviorMapper;

    /**
     * 收藏
     * @param courseId
     * @return
     */
    @PostMapping(value = "/user/collectons/doCollection")
    @ResponseBody
    public ApiResponse doCollection(Integer courseId){

        //获取当前登录的用户
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser= (AuthUser) auth.getPrincipal();
        //添加收藏记录
        UserBehavior userBehavior=new UserBehavior();
        userBehavior.setUserId(authUser.getId());
        userBehavior.setCourseId(courseId);
        userBehavior.setType(UserBehaviorStatus.TYPE_COLLECTION.getValue());
        userBehaviorMapper.insertSelective(userBehavior);
        return ApiResponse.ofMessage(0,null);
    }

    /**
     * 取消收藏
     * @param courseId
     * @return
     */
    @PostMapping(value = "/user/collectons/isCollection")
    @ResponseBody
    public ApiResponse isCollection(Integer courseId){

        //获取当前登录的用户
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser= (AuthUser) auth.getPrincipal();
        //删除收藏记录
        UserBehavior userBehavior=new UserBehavior();
        userBehavior.setUserId(authUser.getId());
        userBehavior.setCourseId(courseId);
        userBehavior.setType(UserBehaviorStatus.TYPE_COLLECTION.getValue());
        userBehaviorMapper.delete(userBehavior);
        return ApiResponse.ofMessage(1,null);

    }

}
