package com.teaching.service.Impl;

import com.teaching.enums.AuthUserStatus;
import com.teaching.enums.CommonStatus;
import com.teaching.enums.CourseStatus;
import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.CourseSectionMapper;
import com.teaching.mapper.UserCourseSectionMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.Course;
import com.teaching.pojo.CourseSection;
import com.teaching.pojo.UserCourseSection;
import com.teaching.service.AuthUserService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/2 23:06
 */

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    private UserCourseSectionMapper userCourseSectionMapper;

    @Override
    public List<AuthUser> findCommonUser() {

        Example example=new Example(AuthUser.class);
        example.createCriteria()
                .andEqualTo("role","USER")
                .andNotEqualTo("teacher",AuthUserStatus.TEACHER_SUCC.getValue());

        return authUserMapper.selectByExample(example);
    }

    @Override
    public List<AuthUser> findTeacherUser() {
        Example example=new Example(AuthUser.class);
        example.createCriteria()
                .andEqualTo("role","USER")
                .andEqualTo("teacher",AuthUserStatus.TEACHER_SUCC.getValue());

        return authUserMapper.selectByExample(example);
    }

    @Override
    public List<AuthUser> findAdminUser() {
        Example example=new Example(AuthUser.class);
        example.createCriteria()
                .andEqualTo("role","ADMIN");

        return authUserMapper.selectByExample(example);
    }

    @Override
    public List<AuthUser> findUserByCourseId(Integer courseId) {
        //先查询所有UserCourseSection
        Example example=new Example(UserCourseSection.class);
        example.selectProperties("userId");
        example.createCriteria().andEqualTo("courseId",courseId);
        example.setDistinct(true);
        List<UserCourseSection> userCourseSectionList=userCourseSectionMapper.selectByExample(example);

        if(!UtilFuns.isNotEmpty(userCourseSectionList)){
            return null;
        }
        //获取所有用户id
        List<Integer> userIds=new ArrayList<>();
        userCourseSectionList.forEach(userCourseSection -> {
            userIds.add(userCourseSection.getUserId());
        });

        //批量查询
        Example example1=new Example(AuthUser.class);
        example1.createCriteria().andIn("id",userIds);
        List<AuthUser> authUserList=authUserMapper.selectByExample(example1);

        return authUserList;
    }
}







