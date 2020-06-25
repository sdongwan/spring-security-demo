package com.sdongwan.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @author: sdongwan
 *  @Date: 2019/12/12 下午 11:12
 *  @Description:
 */
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request,response);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails != null) {
            request.getSession().setAttribute("username",userDetails.getUsername());
        }

        String url = null;
        if(savedRequest != null){
            url = savedRequest.getRedirectUrl();
        }

        if(url == null){
            getRedirectStrategy().sendRedirect(request,response,"/");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
