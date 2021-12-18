package com.example.elasticsearch.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public interface MyAccessService {

    public boolean hasPermisson(HttpServletRequest request, Authentication authentication);
}
