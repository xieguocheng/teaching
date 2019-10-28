package com.teaching.config;


import com.teaching.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Author： XO
 * @Description：
 * @Date： 2018/11/21 15:54
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * HTTP权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);

        // 资源访问权限
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll() // 管理员登录入口
                .antMatchers("/static/**").permitAll() // 静态资源
                .antMatchers("/user/login").permitAll() // 用户登录入口
                .antMatchers("/admin/**").hasRole("ADMIN")
                // .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/admin/login")
               /*.successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    System.out.println("succeed!!!!!!!");
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
                    out.flush();
                    out.close();
                })*/
                /* .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
                            throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                })*/
                .loginProcessingUrl("/login") // 配置角色登录处理入口
                .failureHandler(authFailHandler())          //登录失败处理
                .successHandler(authSuccessHandler())       //登录成功处理
                .failureUrl("/admin/login?error=true")    //登录失败处理跳转admin登录界面
                .and()
                .logout()
                .logoutUrl("/logout")           //配置退出入口
                .logoutSuccessUrl("/logout/page")
                .deleteCookies("JSESSIONID")        //删除默认存放cookie名称-值
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403");  //无权访问该页面


        //1.方便开发，csrf会拦截我所有的post请求
        http.csrf().disable();
        // 2.希望所有的默认头都具有以下自定义设置：x-frame-options允许来自同一域的任何请求，HTTP严格传输安全性（HSTS）不会添加到响应中
        http.headers().frameOptions().sameOrigin();


        //登录成功,失败跳转页面
        http.formLogin().defaultSuccessUrl("/admin/center");
    }

    /**
     * 自定义认证策略
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    /**
     * 调用自己注入的authprovider
     * @return
     */
    @Bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }

    /**
     * 调用自己注入的LoginUrlEntryPoint
     * @return
     */
    @Bean
    public LoginUrlEntryPoint urlEntryPoint() {
        //登录失败入口
        return new LoginUrlEntryPoint("/admin/login");
    }

    /**
     * 调用自己注入的LoginAuthFailHandler
     * @return
     */
    @Bean
    public LoginAuthFailHandler authFailHandler() {

        return new LoginAuthFailHandler(urlEntryPoint());
    }
    /**
     * 调用自己注入的LoginAuthSuccessHandler
     * @return
     */
    @Bean
    public LoginAuthSuccessHandler authSuccessHandler() {

        return new LoginAuthSuccessHandler(urlEntryPoint());
    }

    /**
     * 调用自己注入的AuthFilter
     * 过滤器，用来验证码登录
     * @return
     */
    @Bean
    public AuthFilter authFilter() {
        AuthFilter authFilter = new AuthFilter();
        authFilter.setAuthenticationManager(authenticationManager());
        authFilter.setAuthenticationFailureHandler(authFailHandler());//
        authFilter.setAuthenticationSuccessHandler(authSuccessHandler());//
        return authFilter;
    }

    /**
     * 验证码登录的时候调用
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager =  super.authenticationManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationManager;
    }



}

