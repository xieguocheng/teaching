package com.teaching.web.controller.admin;

import com.teaching.enums.CourseCommentStatus;
import com.teaching.mapper.CourseCommentMapper;
import com.teaching.pojo.CourseComment;
import com.teaching.pojo.CourseSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/21 20:23
 */

@Controller
public class CommentController {

    @Autowired
    private CourseCommentMapper courseCommentMapper;

    /**
     * 获取评论列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/comment/commentList")
    public String commentListPage(Model model){

        Example example=new Example(CourseComment.class);
        example.createCriteria().andEqualTo("type",CourseCommentStatus.TYPE_COMMENT.getValue());
        example.orderBy("courseId").asc();
        List<CourseComment> courseCommentList=courseCommentMapper.selectByExample(example);

        model.addAttribute("courseCommentList",courseCommentList);
        return "admin/comment/comment-list";

    }

    /**
     * 获取答疑列表
     * @param model
     * @return
     */
    @RequestMapping(value="admin/comment/anwserList")
    public String answerListPage(Model model){
        Example example=new Example(CourseComment.class);
        example.createCriteria().andEqualTo("type",CourseCommentStatus.TYPE_ANSWER.getValue());
        example.orderBy("courseId").asc();
        List<CourseComment> courseCommentList=courseCommentMapper.selectByExample(example);

        model.addAttribute("courseCommentList",courseCommentList);

        return "admin/comment/answer-list";

    }

    /**
     * 设置屏蔽词
     * @param model
     * @return
     */
    @RequestMapping(value="admin/comment/shieldingList")
    public String shieldingListPage(Model model){

        CourseComment courseComment= new CourseComment();
        courseComment.setId(1);
        CourseComment courseComment1=courseCommentMapper.selectByPrimaryKey(courseComment);
        model.addAttribute("courseComment",courseComment1);

        return "admin/comment/shielding-list";

    }

}
