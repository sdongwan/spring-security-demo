package com.sdongwan.ssm.mapper;

import com.sdongwan.ssm.bean.StudentBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface StudentMapper {
    int insertStudent(StudentBean studentBean);
    int deleteStudentById(int id);
    StudentBean selectStudentById(int id);
    int updateStudenById(StudentBean studentBean);
    List<StudentBean> selectAllStudents();
}
