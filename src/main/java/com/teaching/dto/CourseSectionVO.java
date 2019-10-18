package com.teaching.dto;

import com.teaching.pojo.CourseSection;
import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CourseSectionVO extends CourseSection implements Serializable {

    //小节
    private List<CourseSection> sections = new ArrayList<CourseSection>();


    public List<CourseSection> getSections() {
        return sections;
    }

    public void setSections(List<CourseSection> sections) {
        this.sections = sections;
    }

}
