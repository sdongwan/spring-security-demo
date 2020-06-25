package com.sdongwan.security.controller;

import com.alibaba.druid.util.StringUtils;
import com.sdongwan.security.DTO.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @author: sdongwan
 *  @Date: 2019/12/10 下午 08:48
 *  @Description:
 */

@Controller
public class LoginController {
    private HttpSessionRequestCache httpSessionRequestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = httpSessionRequestCache.getRequest(request,response);
        if (savedRequest != null) {
            String url = savedRequest.getRedirectUrl();
            if (url.endsWith(".html")) {
                String prefixUrl = url.replace(".html","");
                redirectStrategy.sendRedirect(request,response,prefixUrl);
            }
        }

        return new SimpleResponse("登录成功");
    }

}
