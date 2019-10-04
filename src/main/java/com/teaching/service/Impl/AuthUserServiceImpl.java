package com.teaching.service.Impl;

import com.teaching.enums.AuthUserStatus;
import com.teaching.enums.CommonStatus;
import com.teaching.enums.CourseStatus;
import com.teaching.mapper.AuthUserMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.Course;
import com.teaching.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
}
