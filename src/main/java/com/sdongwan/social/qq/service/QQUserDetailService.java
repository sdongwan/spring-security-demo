package com.sdongwan.social.qq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Date 2020/1/5 19:15
 * @Created by sdongwan
 */
@Component("QQUserDetailService")
public class QQUserDetailService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * UserDetails接口，实际可以自己实现这个接口，返回自己的实现类
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buildUser(username);
    }


    /**
     * 第三方登录使用
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        return buildUser(userId);
    }



    private SocialUserDetails buildUser(String userId) {
        String password = passwordEncoder.encode("123456");
        System.err.println("加密后密码：  "+password);
        //参数：用户名|密码|是否启用|账户是否过期|密码是否过期|账户是否锁定|权限集合
        return new SocialUser(userId,password,true,true,
                true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
