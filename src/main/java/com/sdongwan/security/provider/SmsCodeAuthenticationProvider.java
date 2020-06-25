package com.sdongwan.security.provider;

import com.sdongwan.security.token.SmsCodeAuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2019/12/22 19:13
 * @Created by sdongwan
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken smsCodeAuthenticationToken = (SmsCodeAuthenticationToken) authentication;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String smsCode = (String) sessionStrategy.getAttribute(new ServletWebRequest(request),"smscode");
        String inputCode = request.getParameter("smscode");
        String mobile = (String) smsCodeAuthenticationToken.getPrincipal();
        checkSmsCode(smsCode,inputCode);

        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        SmsCodeAuthenticationToken smsCodeAuthenticationToken1 = new SmsCodeAuthenticationToken(mobile,auths);
        smsCodeAuthenticationToken1.setDetails(smsCodeAuthenticationToken.getDetails());
        return smsCodeAuthenticationToken1;
    }

    private void checkSmsCode(String smsCode,String inputCode) {
        if(smsCode == null) {
            throw new BadCredentialsException("未检测到申请的验证码");
        }
        if(!StringUtils.equals(smsCode,inputCode)) {
            throw new BadCredentialsException("验证码错误");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }


}
