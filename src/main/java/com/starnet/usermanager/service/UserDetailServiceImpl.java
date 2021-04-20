package com.starnet.usermanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("执行登录逻辑");
        //1.获取用户名，从数据库中取出密码
        if (!"admin".equals(s)){
            System.out.println("用户名不存在");
            throw new UsernameNotFoundException("该用户名不存在");
        }
        //2.从数据库取出密码（注册时密码已加密），如果匹配成功返回UserDetails
        String password = passwordEncoder.encode("123");

        return new User(s, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
