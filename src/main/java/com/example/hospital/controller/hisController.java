package com.example.hospital.controller;


import com.example.hospital.entity.User;
import com.example.hospital.mapper.UserMapper;
import com.example.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class hisController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")//登录
    public Integer login(String id,String password) {
        return userService.login(new User(id,password));
    }

    @RequestMapping("/logout")//登出
    public boolean logout(){
        return userService.logout();
    }

    @RequestMapping("/register")//注册
    public Integer register(String id,String password){
        return userService.register(new User(id,password));
    }

    @RequestMapping("/registers")//注册
    public Integer registers(User user){
        return userService.register(user);
    }

    @RequestMapping("/getUsers")
    public List<User> getUser(String id){
        return userMapper.selectAllUsers();
    }
}
