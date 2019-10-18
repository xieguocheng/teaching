package com.teaching.service.Impl;

import com.teaching.dto.CourseSectionVO;
import com.teaching.enums.CourseSectionStatus;
import com.teaching.mapper.CourseSectionMapper;
import com.teaching.mapper.UserCourseSectionMapper;
import com.teaching.pojo.CourseSection;
import com.teaching.service.CourseSectionService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
