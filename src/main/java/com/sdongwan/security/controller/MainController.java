package com.sdongwan.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @author: sdongwan
 *  @Date: 2019/12/10 下午 08:51
 *  @Description:
 */
@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    @RequestMapping("/main")
    public Object toMain() {
        return "main";
    }
}
