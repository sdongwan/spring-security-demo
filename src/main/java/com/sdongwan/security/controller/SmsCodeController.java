package com.sdongwan.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @Description
 * @Date 2019/12/22 19:35
 * @Created by sdongwan
 */

@RestController
public class SmsCodeController {
    private Logger logger = LoggerFactory.getLogger(SmsCodeController.class);
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @RequestMapping(value = "/sms/code",method = RequestMethod.GET)
    public void smsCode(HttpServletRequest request, HttpServletResponse response) {
        String mobile = request.getParameter("mobile");
        String code = generateCode();
        sessionStrategy.setAttribute(new ServletWebRequest(request),"smscode",code);
        logger.debug("验证码：" + code);
    }

    public static  String generateCode () {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 4 ; i++) {
            code += random.nextInt(9) + "";
        }
        return code;
    }
}
