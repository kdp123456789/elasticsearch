package com.example.elasticsearch.service.serviceImpl;

import com.example.elasticsearch.service.MyAccessService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 自定义认证请求
 */
@Service
public class MyAccessServiceImpl implements MyAccessService {

    /**
     * 通过用户的获取到自定义权限（库里查到的）来认证   ------  uri
     * @param request
     * @param authentication
     * @return
     */
    @Override
    public boolean hasPermisson(HttpServletRequest request, Authentication authentication) {
        //获取登录用户分配的url权限
        String uri = request.getRequestURI();
        //获取权限对象
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            //获取用户对应的权限
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            //判断集合中是否包含对应的uri
            boolean flag = authorities.contains(new SimpleGrantedAuthority(uri));
            System.out.println(flag+"--"+new SimpleGrantedAuthority(uri));
            return flag;
        }
        return false;
    }
}
