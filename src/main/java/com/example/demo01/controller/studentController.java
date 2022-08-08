package com.example.demo01.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo01.entity.Student;
import com.example.demo01.service.studentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/student")
public class studentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentService studentService = new studentService();

        List<Student> studentList = studentService.select();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success");
        map.put("student",studentList);
//        System.out.println(studentList);

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(JSON.toJSONString(map));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String, Object> map = new HashMap<>();

        if(username != null && password != null) {
            map.put("code", 200);
            map.put("msg", "操作成功！");
        } else {
            map.put("code", 500);
            map.put("msg", "操作失败！");
        }

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(JSON.toJSONString(map));
    }
}
