package com.sdongwan.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sdongwan.ssm.service.StudentService;

/**
 *  @author: sdongwan
 *  @Date: 2019/12/5 下午 08:58
 *  @Description:
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStu")
    public String addStudent() {
        // studentService.addStudent();
        return "index";
    }

}
