package com.teaching.security;

import com.teaching.mapper.SystemLogMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.SystemLog;
import com.teaching.mapper.AuthUserMapper;
import com.teaching.service.AuthUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author： XO
 * @Description：
 * @Date： 2018/11/21 16:18
 */

@Data
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthUserService authUserService;

    /*@Autowired
    private UserService userService;*/

    //private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
    //MD5加密过时，使用BCrypt比较好
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        //1.获取用户输入的名字和密码
        String userName = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();
        //2.从数据库查询管理员信息
        AuthUser authUser=authUserService.findAuthUserByUsername(userName);
       if(authUser==null){
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        //查看是否停用
       /* if(userSuper.getStatus()==0){
            throw new AuthenticationCredentialsNotFoundException("authError");
        }*/

        //3.进行加密的密码验证
        //3.1先授权看看是不是admin
        if(this.passwordEncoder.matches(inputPassword,authUser.getPassword())){
            return new UsernamePasswordAuthenticationToken(authUser, null, authUser.getAuthorities());
        }

        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }



}

