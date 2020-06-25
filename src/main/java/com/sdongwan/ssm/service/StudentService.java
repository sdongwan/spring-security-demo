package com.sdongwan.ssm.service;

import com.sdongwan.ssm.bean.StudentBean;
import com.sdongwan.ssm.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/8.
 */
@Service
public class StudentService {

    // @Autowired
    private StudentDao studentDao;

    public void addStudent() {
        StudentBean studentBean = new StudentBean(1, "sdongwan", "boy");
        studentDao.insertStudent(studentBean);
    }
}
