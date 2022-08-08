package com.example.demo01.dao;

import com.example.demo01.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class studentDao {
    public List<Student> select(){
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?userSSL=false;serverTimezone=Asia/Shanghai", "root", "20020425");

            String sql = "select name,age from student";
            ps = connection.prepareStatement(sql);

            rs=ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                students.add(new Student(name,age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return students;
    }
}
