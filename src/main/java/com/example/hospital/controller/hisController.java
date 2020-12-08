package com.example.hospital.controller;


import com.example.hospital.entity.User;
import com.example.hospital.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
@MapperScan("com.example.hospital.mapper")
@RequestMapping("/login")
public class hisController {
    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){
        return "hello";
    }

    /**
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/user")
    public User Login(User user){
        
        return userMapper.selectById(user.id);
    }
}
