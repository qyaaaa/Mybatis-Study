package com.qy.dao;

import com.qy.pojo.Student;


import java.util.List;

public interface StudentMapper {
    //查询所有的学生的信息以及对应老师的信息
    public List<Student> getStudent();

    public List<Student> getStudent2();
}
