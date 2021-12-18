package com.example.elasticsearch.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Security配置类
 */
@Configurable
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder pw() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //用户名密码必须是 username,password   源码  走UsernamePasswordAuthenticationFilter->attemptAuthentication->request.getParameter(this.usernameParameter)  或者自定义用户名密码参数;
        //表单登录
        http.formLogin()
                //自定义登录页面       未登录前都被拦截到此页面
                .loginPage("/login.html")
                //自定义登录逻辑（必须是post）       前端登录接口->拦截到loadUserByUsername方法->
                .loginProcessingUrl("/security/login")

                //登录成功后跳转页面(必须是post)        ->通过loadUserByUsername方法后->调用后台接口方法（/security/login）
                .successForwardUrl("/security/login")
//                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com")) //另一种方式，直接重定向页面，或者用post走后台

                //登录失败后跳转的页面(必须是post)       ->失败后调用后台接口方法（/security/toError）
                .failureForwardUrl("/security/toError")
//                .failureHandler(new MyForwardAuthenticationFailureHandler("https://www.bilibili.com")) //另一种方式，直接重定向页面，或者用post走后台

                //自定义用户名参数
                .usernameParameter("username")
                //自定义密码参数
                .passwordParameter("password")
        ;

        //授权
        http.authorizeRequests()
                //放行登录页面
                .antMatchers("/login.html").permitAll()
                //放行失败登录页面
                .antMatchers("/error.html").permitAll()
                //放行自定义文件
                .antMatchers("/**/*.jpg").permitAll()
                //权限    通过权限匹配（只有admin权限的人才能进去main1.html）
//                .antMatchers("/main1.html").hasAnyAuthority("admin","normal")
                //角色    通过权限匹配（只有admin权限的人才能进去main1.html）
                .antMatchers("/main1.html").hasAnyRole("-abc")
                //根据ip匹配    基于ip控制（只有admin权限的人才能进去main1.html）
//                .antMatchers("/main1.html").hasIpAddress("127.0.0.1")

                //所有请求都必须认证  或者自定义access逻辑（通过用户拥有的权限来访问）
//                .anyRequest().authenticated();
                .anyRequest().access("@myAccessServiceImpl.hasPermisson(request,authentication)");

        //异常处理
        http.exceptionHandling()
                //accessDeniedHandler自定义返回json，accessDeniedPage自定义返回页面
                .accessDeniedHandler(new MyAccessDeniedHandler())
//                .accessDeniedPage("/error/403.html")
        ;

        //关闭csrf防护，要不然不能进去自定义登录逻辑里的方法
        http.csrf().disable();
    }
}
