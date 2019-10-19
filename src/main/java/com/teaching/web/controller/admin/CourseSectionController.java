package com.teaching.web.controller.admin;

import com.teaching.dto.CourseSectionVO;
import com.teaching.mapper.CourseSectionMapper;
import com.teaching.pojo.CourseSection;
import com.teaching.service.CourseSectionService;
import com.teaching.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class CourseSectionController {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public CourseSectionService courseSectionService;

    @Autowired
    private CourseSectionMapper courseSectionMapper;

    /**
     *  批量添加章节
     * @param batchSections
     * @return
     */
    @RequestMapping(value = "admin/courseSection/addCourseSection")
    @ResponseBody
    public ApiResponse batchAdd(@RequestBody List<CourseSectionVO> batchSections){

        courseSectionService.batchAdd(batchSections);

        return ApiResponse.ofSuccess(null);
    }


    /**
     * 通过章节id观看视频
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value="admin/courseSection/playVideo/{id}")
    public String userDetail(Model model, @PathVariable("id") String id){

        CourseSection courseSection=new CourseSection();
        courseSection.setId(Integer.valueOf(id));

        CourseSection section=courseSectionMapper.selectByPrimaryKey(courseSection);
        model.addAttribute("section",section);

        return "admin/course/video";
    }
















}
