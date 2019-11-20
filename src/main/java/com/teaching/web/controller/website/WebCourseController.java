package com.teaching.web.controller.website;

import com.teaching.mapper.CourseMapper;
import com.teaching.pojo.Course;
import com.teaching.pojo.CourseComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WebCourseController {

    @Autowired
    private CourseMapper courseMapper;


    /**
     * 查看课程表基本详情
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value="website/course/courseDetail/{id}")
    public String courseDetail(HttpServletRequest request,Model model, @PathVariable("id") String id){

        Course course=courseMapper.selectByPrimaryKey(new Course(Integer.valueOf(id)));
        model.addAttribute("course",course);


        return "website/course-detail";
    }

}
