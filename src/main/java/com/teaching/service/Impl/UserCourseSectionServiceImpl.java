package com.teaching.service.Impl;

import com.teaching.mapper.CourseSectionMapper;
import com.teaching.mapper.UserCourseSectionMapper;
import com.teaching.pojo.CourseSection;
import com.teaching.pojo.UserCourseSection;
import com.teaching.service.UserCourseSectionService;
import com.teaching.service.UserFollowsService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2020/3/12 22:25
 */
@Service
public class UserCourseSectionServiceImpl implements UserCourseSectionService {


    @Autowired
    private UserCourseSectionMapper userCourseSectionMapper;
    @Autowired
    private CourseSectionMapper courseSectionMapper;

    @Override
    public void addUserCourseSection(Integer userId, Integer sectionId) {
        //1、先查courseId
        CourseSection courseSection=courseSectionMapper.selectByPrimaryKey(new CourseSection(sectionId));
        //2、判断是否有存在的记录
        Boolean flag=existRecord(userId,sectionId);
        //3、插入用户课程记录
        if(!flag){
            UserCourseSection userCourseSection=new UserCourseSection();
            userCourseSection.setUserId(userId);
            userCourseSection.setSectionId(sectionId);
            userCourseSection.setCourseId(courseSection.getCourseId());
            userCourseSection.setRate(10);//TODO 待完善，用户课程学习记录进度
            userCourseSectionMapper.insertSelective(userCourseSection);
        }

    }

    @Override
    public Boolean existRecord(Integer userId, Integer sectionId) {
        Example example=new Example(UserCourseSection.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("sectionId",sectionId);
        List<UserCourseSection> userCourseSectionList=userCourseSectionMapper.selectByExample(example);
        if(UtilFuns.isNotEmpty(userCourseSectionList)){
            return true;
        }
        return false;
    }
}
