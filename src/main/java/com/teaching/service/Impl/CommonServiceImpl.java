package com.teaching.service.Impl;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.BbsArticleMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.BbsArticle;
import com.teaching.pojo.Course;
import com.teaching.service.CommonService;
import com.teaching.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： XO
 * @Description： 通用service
 * @Date： 2019/9/28 11:11
 */

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private AuthUserMapper authUserMapper;
    @Autowired
    private BbsArticleMapper bbsArticleMapper;



    @Override
    public ServiceResult<Integer> count(Object o) throws Exception{
        //计算到的数量
        int count=0;

        //使用放射机制动态加载使用
        if(Course.class.isInstance(o)){
            count=courseMapper.selectCount(Course.class.newInstance());//计算课程数量
            return ServiceResult.of(count);
        }
        if(AuthUser.class.isInstance(o)){
            count=authUserMapper.selectCount(AuthUser.class.newInstance());//计算用户数量
            return ServiceResult.of(count);
        }
        if(BbsArticle.class.isInstance(o)){
            count=bbsArticleMapper.selectCount(BbsArticle.class.newInstance());//计算bbs文章数量
            return ServiceResult.of(count);
        }

        //没有该表的计算，获取不到该表的资源
        return ServiceResult.notFound();
    }

    @Override
    public ServiceResult<Integer> dayVisit(Object o) throws Exception {
        //计算日增量
        int count=0;
        //使用放射机制动态加载使用
        if(Course.class.isInstance(o)){
            count=courseMapper.selectDayVisit();//计算课程日增量
            return ServiceResult.of(count);
        }
        if(AuthUser.class.isInstance(o)){
            count=authUserMapper.selectDayVisit();//计算用户日增量
            return ServiceResult.of(count);
        }
        if(BbsArticle.class.isInstance(o)){
            count=bbsArticleMapper.selectDayVisit();//计算bbs文章日增量
            return ServiceResult.of(count);
        }

        //没有该表的计算，获取不到该表的资源
        return ServiceResult.notFound();
    }


}
