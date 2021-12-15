package com.example.elasticsearch.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败自定义跳转页面
 */
public class MyForwardAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final String forwardUrl;

    public MyForwardAuthenticationFailureHandler(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        request.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
        response.sendRedirect(this.forwardUrl);
    }
}
