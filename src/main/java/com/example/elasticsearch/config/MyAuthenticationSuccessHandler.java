package com.example.elasticsearch.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功后跳转自定义跳转页面
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String forwardUrl;

    public MyAuthenticationSuccessHandler(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(this.forwardUrl);
    }
}
