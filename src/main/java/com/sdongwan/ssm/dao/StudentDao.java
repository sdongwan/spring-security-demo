package com.sdongwan.ssm.dao;

import com.sdongwan.ssm.bean.StudentBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */
@Repository
public interface StudentDao {
    int insertStudent(StudentBean studentBean);

    int deleteStudentById(int id);

    StudentBean selectStudentById(int id);

    int updateStudenById(StudentBean studentBean);

    List<StudentBean> selectAllStudents();
}
