package com.teaching.web.controller.admin;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.SystemLogMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.SystemLog;
import com.teaching.service.AuthUserService;
import com.teaching.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/3 22:52
 */

@Controller
public class SystemController {

    @Autowired
    public SystemLogMapper systemLogMapper;
    @Autowired
    private AuthUserService authUserService;

    /**
     * 查看系统登录日志
     * @param model
     * @return
     */
    @RequestMapping(value="admin/system/systemLogList")
    public String systemLogList(Model model){
        List<SystemLog> systemLogList=systemLogMapper.selectAll();
        model.addAttribute("systemLogList", systemLogList);
        return "admin/system/system-log-List";
    }



    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 查看所有管理员
     * @param model
     * @return
     */
    @RequestMapping(value="admin/system/adminList")
    public String userSuperList(Model model){
        List<AuthUser> userSuperList=authUserService.findAdminUser();
        model.addAttribute("userSuperList", userSuperList);
        return "admin/system/admin-list";
    }


    /**
     * 管理员停用
     * @param id
     * @return
     */
    @PostMapping(value="admin/userSuper/userSuperStop")
    @ResponseBody
    public ApiResponse userSuperStop(Integer id){
        try{
            /*UserSuper userSuper=userSuperService.findUserSuperById(id);
            userSuper.setStatus(UserSuperStatus.STATUS_NO.getValue());
            userSuperService.updateUserSuper(userSuper);*/

            return ApiResponse.ofSuccess(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    /**
     * 管理员启用
     * @param id
     * @return
     */
    @PostMapping(value="admin/userSuper/userSuperStart")
    @ResponseBody
    public ApiResponse userSuperStart(Integer id){
        try{
            /*UserSuper userSuper=userSuperService.findUserSuperById(id);
            userSuper.setStatus(UserSuperStatus.STATUS_YES.getValue());
            userSuperService.updateUserSuper(userSuper);*/
            return ApiResponse.ofSuccess(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    /**
     * 新增管理页面
     * @return
     */
    @RequestMapping(value="admin/system/addAdminPage")
    public String userSuperAddPage(){
        return "admin/system/add-admin-page";
    }

    /**
     * 新增管理
     * @param authUser
     */
    @PostMapping(value="admin/system/addAdmin")
    @ResponseBody
    public ApiResponse userSuperAdd(AuthUser authUser){
       /* userSuper.setPassword(passwordEncoder.encode(userSuper.getPassword()));
        userSuperService.saveUserSuper(userSuper);*/

        return ApiResponse.ofSuccess(null);
    }


}
