package com.teaching.service;

import com.teaching.pojo.AuthUser;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/2 23:06
 */

public interface AuthUserService {

    /**
     * 查询所有普通用户
     * @return
     */
    public List<AuthUser> findCommonUser();

    /**
     * 查询所有教师资格的用户
     * @return
     */
    public List<AuthUser> findTeacherUser();

    /**
     * 查询所有管理员
     * @return
     */
    public List<AuthUser> findAdminUser();
}
