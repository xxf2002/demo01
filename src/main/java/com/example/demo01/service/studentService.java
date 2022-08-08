package com.example.demo01.service;

import com.example.demo01.dao.studentDao;
import com.example.demo01.entity.Student;

import java.util.List;

public class studentService {
    public List<Student> select(){
        studentDao studentdao= new studentDao();
        return studentdao.select();
    }
}
