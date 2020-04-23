package com.teaching.security;

import com.teaching.mapper.AuthUserMapper;
import com.teaching.mapper.SystemLogMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.SystemLog;
import com.teaching.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/28 20:45
 */
@Slf4j
public class LoginAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private SystemLogMapper systemLogMapper;
    @Autowired
    private AuthUserService authUserService;
    @Autowired
    private AuthUserMapper authUserMapper;

    private final LoginUrlEntryPoint urlEntryPoint;

    public LoginAuthSuccessHandler(LoginUrlEntryPoint urlEntryPoint) {

        this.urlEntryPoint = urlEntryPoint;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        //登录成功添加systemlog日志,更新操作日志
        String name=authentication.getName();

        AuthUser authUser=authUserService.findAuthUserByUsername(name);
        authUser.setIp(request.getRemoteAddr());
        authUser.setLoginTime(new Date());
        authUserMapper.updateByPrimaryKeySelective(authUser);

        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")){
                SystemLog systemLog=new SystemLog();
                systemLog.setAddress(request.getRemoteAddr());
                systemLog.setNickname(name);
                systemLog.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                systemLog.setStatus(1);
                systemLogMapper.insert(systemLog);
                break;
            }
        }
        
        //网站session判断
        request.getSession().setAttribute("name",name);

        log.info("登录成功！！！");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
        out.flush();
        out.close();
    }
}
