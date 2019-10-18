package com.teaching.web.controller.admin;

import com.teaching.dto.CourseSectionVO;
import com.teaching.pojo.CourseSection;
import com.teaching.service.CourseSectionService;
import com.teaching.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class CourseSectionController {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public CourseSectionService courseSectionService;

    //批量添加章节
    @RequestMapping(value = "admin/courseSection/addCourseSection")
    @ResponseBody
    public ApiResponse batchAdd(@RequestBody List<CourseSectionVO> batchSections){

        courseSectionService.batchAdd(batchSections);

        return ApiResponse.ofSuccess(null);
    }
















}
