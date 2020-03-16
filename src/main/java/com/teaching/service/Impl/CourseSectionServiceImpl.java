package com.teaching.service.Impl;

import com.teaching.dto.CourseSectionVO;
import com.teaching.enums.CourseSectionStatus;
import com.teaching.mapper.CourseSectionMapper;
import com.teaching.mapper.UserCourseSectionMapper;
import com.teaching.pojo.CourseComment;
import com.teaching.pojo.CourseSection;
import com.teaching.service.CourseSectionService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/3 17:46
 */
@Service
public class CourseSectionServiceImpl implements CourseSectionService {

        @Autowired
        private CourseSectionMapper courseSectionMapper;


        /**
         *  循环添加和批量添加章节
         * @param courseSections
         */
        @Transactional
        @Override
        public void batchAdd(List<CourseSectionVO> courseSections) {

                if(UtilFuns.isNotEmpty(courseSections)){

                        //先获取最大的排序id
                        Integer maxSort = courseSectionMapper.getMaxSort(courseSections.get(0).getCourseId());

                        for(int i = 0; i < courseSections.size(); i++){
                                CourseSectionVO tmpVO = courseSections.get(i);
                                if(null == maxSort){
                                        maxSort = 0;
                                }
                                maxSort += (i + 1);
                                CourseSection courseSection = new CourseSection();
                                courseSection.setCourseId(tmpVO.getCourseId());
                                courseSection.setName(tmpVO.getName());
                                courseSection.setParentId(0);//章的parentId固定为0
                                courseSection.setSort(maxSort);
                                courseSection.setOnsale("1");

                                //插入一章
                                courseSectionMapper.insertSelective(courseSection);
                                Integer id=courseSectionMapper.selectMaxId();

                                List<CourseSection> subCourseSections = tmpVO.getSections();
                                if(UtilFuns.isNotEmpty(subCourseSections)){
                                        String totalTime = "00:00";
                                        for(int j = 0; j < subCourseSections.size(); j++){

                                                CourseSection courseSectionTmp = subCourseSections.get(j);
                                                courseSectionTmp.setCourseId(courseSection.getCourseId());
                                                courseSectionTmp.setParentId(id);
                                                courseSectionTmp.setSort(j+1);
                                                courseSectionTmp.setOnsale("1");
                                                courseSectionTmp.setCreateTime(new Date());
                                                courseSectionTmp.setUpdateTime(new Date());

                                                Pattern p = Pattern.compile("^([0-5][0-9]):([0-5][0-9])$");
                                                if(!p.matcher(courseSectionTmp.getTime()).find()){//正则表达式匹配不成功
                                                        courseSectionTmp.setTime("00:00");
                                                }
                                                if(null == courseSectionTmp.getVideoUrl()){
                                                        courseSectionTmp.setVideoUrl("");
                                                }
                                                //计算节的总时间
                                                totalTime = appendCourseSectionTime(totalTime,courseSectionTmp.getTime());
                                                //插入节
                                                courseSectionMapper.insertSelective(courseSectionTmp);
                                        }
                                        //courseSectionMapper.insertList(subCourseSections);批量插入集合节

                                        //更新时间
                                        courseSection.setTime(totalTime);
                                        courseSection.setId(id);
                                        courseSectionMapper.updateByPrimaryKey(courseSection);
                                }
                        }
                }
                //TODO 更新课程总时长

        }

        @Override
        public List<CourseSection> findCourseSectionByCourseId(Integer courseId) {
                Example example=new Example(CourseSection.class);
                example.createCriteria().andEqualTo("courseId",courseId);
                example.orderBy("sort").asc();
                List<CourseSection> courseSectionList=courseSectionMapper.selectByExample(example);
                return courseSectionList;
        }

        @Override
        public List<CourseSection> findCourseSectionOnsale(Integer courseId, Integer onsale) {
                Example example=new Example(CourseSection.class);
                example.createCriteria().andEqualTo("courseId",courseId)
                        .andEqualTo("onsale",onsale);//是否上架
                example.orderBy("id").asc();
                example.orderBy("sort").asc();
                List<CourseSection> courseSectionList=courseSectionMapper.selectByExample(example);
                return courseSectionList;
        }

        @Override
        public List<CourseSectionVO> queryCourseSection(Integer courseId) {

                List<CourseSection> courseSectionList=findCourseSectionOnsale(courseId,1);

                List<CourseSectionVO> resultList = new ArrayList<>();
                Map<Integer,CourseSectionVO> tmpMap = new LinkedHashMap<>();
                Iterator<CourseSection> it = courseSectionList.iterator();
                while(it.hasNext()){
                        CourseSection item = it.next();
                        if(Integer.valueOf(0).equals(item.getParentId())){//章
                                CourseSectionVO vo = new CourseSectionVO();
                                BeanUtils.copyProperties(item, vo);
                                tmpMap.put(vo.getId(), vo);
                        }else{
                                tmpMap.get(item.getParentId()).getSections().add(item);//小节添加到大章中
                        }
                }
                for(CourseSectionVO vo : tmpMap.values()){
                        resultList.add(vo);
                }
                return resultList;

        }

        @Override
        public CourseSection findFirstCourseSectionByCourseId(Integer courseId) {
                Example example=new Example(CourseSection.class);
                example.createCriteria().andEqualTo("courseId",courseId)
                        .andEqualTo("del",0)//未删除
                        .andNotEqualTo("parentId",0);//不是父亲节点
                example.orderBy("id").asc();
                example.orderBy("sort").asc();
                List<CourseSection> courseSectionList=courseSectionMapper.selectByExample(example);
                if(UtilFuns.isNotEmpty(courseSectionList)){
                        return courseSectionList.get(0);
                }
               return null;
        }


        //时间合计
        private String appendCourseSectionTime(String time1, String time2){
                String[] time1Arr = time1.split(":");
                String[] time2Arr = time2.split(":");
                Integer second1 = Integer.parseInt(time1Arr[0]) * 60 + Integer.parseInt(time1Arr[1]);
                Integer second2 = Integer.parseInt(time2Arr[0]) * 60 + Integer.parseInt(time2Arr[1]);
                Integer secondTotal = second1 + second2;
                Integer minute = secondTotal/60;
                String minuteStr = minute + "";
                if(minute < 10){
                        minuteStr = "0"+minute;
                }
                Integer secode = secondTotal%60;
                String secodeStr = secode + "";
                if(secode < 10){
                        secodeStr = "0"+secode;
                }
                return minuteStr + ":" + secodeStr;
        }














}
