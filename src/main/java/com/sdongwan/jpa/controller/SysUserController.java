package com.sdongwan.jpa.controller;


import com.sdongwan.jpa.model.SysUser;
import com.sdongwan.jpa.service.SysUserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *  @author: sdongwan
 *  @Date: 2019/12/6 下午 10:15
 *  @Description:
 */
@Controller
public class SysUserController {
    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

   /**
    *  @author: sdongwan
    *  @Date: 2019/12/9 下午 08:40
    *  @Description:
    */
    @RequestMapping("/addOne")
    @ResponseBody
    public Object addSysUser() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword("123");
        System.out.println("11111111111111");
        return sysUserService.saveOne(sysUser);
    }

    /**
     *  @author: sdongwan
     *  @Date: 2019/12/9 下午 08:40
     *  @Description:
     */
    @RequestMapping("/listOne")
    @ResponseBody
    public Object listOne(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        return sysUserService.listOne(userId);
    }

    @RequestMapping("/listByAccount")
    @ResponseBody
    public Object listByAccount(HttpServletRequest request) {
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        logger.error(account + " " + pwd);
        logger.info(account + " " + pwd);
        logger.debug(account + " " + pwd);
        System.out.println("11111111111");
        return sysUserService.listSameAccount(account,pwd);
    }

    @RequestMapping("/listByQuery")
    @ResponseBody
    public Object listByQuery(HttpServletRequest request) {
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        return sysUserService.listByQuery(account,pwd);
    }
}
