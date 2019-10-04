package com.teaching.service.Impl;

import com.teaching.enums.CommonStatus;
import com.teaching.enums.CourseStatus;
import com.teaching.mapper.ConstsClassifyMapper;
import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.ConstsClassify;
import com.teaching.pojo.Course;
import com.teaching.service.CourseService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/28 10:59
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;


    @Override
    public List<Course> findAllCourseFree() {
        //查询所有免费课程 free-1，del-0 ,status-2申请成功
        Example courseExample=new Example(Course.class);
        courseExample.createCriteria()
                .andEqualTo("free",CourseStatus.FREE_YES.getValue())
                .andEqualTo("del",CommonStatus.DEL_NO.getValue())
                .andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue())
        ;
        List<Course> courseList=courseMapper.selectByExample(courseExample);

        return courseList;
    }

    @Override
    public List<Course> findAllCourseMoney() {
        //查询所有要钱的课程 free-0，del-0,,status-申请成功
        Example courseExample=new Example(Course.class);
        courseExample.createCriteria()
                .andEqualTo("free",CourseStatus.FREE_NO.getValue())
                .andEqualTo("del",CommonStatus.DEL_NO.getValue())
                .andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue())
        ;
        List<Course> courseList=courseMapper.selectByExample(courseExample);

        return courseList;
    }

    @Override
    public List<Course> findAllCourseDelete() {
        //查询所有被删除的课程 del-1,status-申请成功
        Example courseExample=new Example(Course.class);
        courseExample.createCriteria()
                .andEqualTo("del",CommonStatus.DEL_YES.getValue())
                .andEqualTo("status",CourseStatus.STATUS_VERIFY_SUCC.getValue())
        ;
        List<Course> courseList=courseMapper.selectByExample(courseExample);

        return courseList;
    }

    @Override
    public List<Course> findCourseByClassify(Integer id) {

        //根据类目id搜索所有课程
        Example example=new Example(Course.class);
        Example.Criteria criteria=example.createCriteria();
        ConstsClassify constsClassify=constsClassifyMapper.selectByPrimaryKey(new ConstsClassify(id));//获取分类对象
        //1.如果是父亲节点,直接查询classify
        if(constsClassify.getParentId()==0){
            criteria.andEqualTo("classify",constsClassify.getId());
        }else{
            //2.如果是子节点
            criteria.andEqualTo("subClassify",constsClassify.getId());
        }
        List<Course> courseList=courseMapper.selectByExample(example);

        return courseList;
    }

    @Override
    public List<Course> findCourseByTimeAndNameAndClassify(String startTime, String endTime, String name, Integer Classify) {

        //查询类目
        ConstsClassify constsClassify=constsClassifyMapper.selectByPrimaryKey(new ConstsClassify(Classify));//获取分类对象

        //开始搜索,封装搜索条件
        Example example=new Example(Course.class);
        Example.Criteria criteria=example.createCriteria();
        //1.如果是父亲节点,直接查询classify
        if(constsClassify.getParentId()==0){
            criteria.andEqualTo("classify",constsClassify.getId());
        }else{
            //2.如果是子节点,直接查询subClassify
            criteria.andEqualTo("subClassify",constsClassify.getId());
        }
        if(UtilFuns.isNotEmpty(endTime)){//4.开始时间
            criteria.andGreaterThanOrEqualTo("createTime",startTime);
        }
        if(UtilFuns.isNotEmpty(endTime)){//5.结束时间
            criteria.andLessThanOrEqualTo("createTime",endTime);
        }
        if(UtilFuns.isNotEmpty(name)){//6.课程名称
            criteria.andLike("name",name);
        }
        List<Course> courseList=courseMapper.selectByExample(example);

        return courseList;
    }
}
