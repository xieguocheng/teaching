package com.teaching.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/28 20:45
 */

public class LoginAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginUrlEntryPoint urlEntryPoint;

    public LoginAuthSuccessHandler(LoginUrlEntryPoint urlEntryPoint) {

        this.urlEntryPoint = urlEntryPoint;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("succeed!!!!!!!");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
        out.flush();
        out.close();
    }
}
