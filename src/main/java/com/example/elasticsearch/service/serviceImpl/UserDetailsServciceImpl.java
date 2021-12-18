package com.example.elasticsearch.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServciceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        //1.通过username查数据库对象
        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名密码错误!");
        }
        //2.查询对象比较密码
        String password = passwordEncoder.encode("123456");
        //返回用户对象   ROLE_(角色固定前缀)
        return new User("admin",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc"));
    }
}
