package com.teaching.web.controller.admin;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.SchoolMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.School;
import com.teaching.service.AuthUserService;
import com.teaching.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/2 23:08
 */

@Controller
public class UserController {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    private AuthUserService userService;

    @Autowired
    private SchoolMapper schoolMapper;

    /**
     *  查询所有普通用户页面
     * @param model
     * @return
     */
    @GetMapping("admin/user/userCommonList")
    public String userCommonList(Model model) {

        List<AuthUser>  userList=userService.findCommonUser();
        model.addAttribute("userList",userList);

        return "admin/user/user-common-list";
    }

    /**
     *  查询所有教师
     * @param model
     * @return
     */
    @GetMapping("admin/user/userTeacherList")
    public String userTeacherList(Model model) {

        List<AuthUser>  userList=userService.findTeacherUser();
        model.addAttribute("userList",userList);

        return "admin/user/user-teacher-list";
    }


    /**
     * 查看用户详情
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value="admin/user/userDetail/{id}")
    public String userDetail(Model model,@PathVariable("id") String id){

        //查询用户基本信息
        AuthUser user=authUserMapper.selectByPrimaryKey(new AuthUser(Integer.valueOf(id)));

        //查询学校
        if(UtilFuns.isNotEmpty(user.getSchool())){
            School school=schoolMapper.selectByPrimaryKey(new School(user.getSchool()));
            model.addAttribute("school",school);
        }else{
            model.addAttribute("school",new School());
        }
        model.addAttribute("user",user);


        return "admin/user/user-detail";
    }





}
