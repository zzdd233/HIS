package com.example.hospital.service.impl;

import com.example.hospital.entity.Cost;
import com.example.hospital.entity.User;
import com.example.hospital.mapper.CostMapper;
import com.example.hospital.mapper.UserMapper;
import com.example.hospital.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CostMapper costMapper;

    @Override
    public Integer login(User user) {
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(String.valueOf(user.getUserId()),user.getUserPassword()));
            return 0;
        } catch (UnknownAccountException e) {//用户名未知
            e.printStackTrace();
            return 1;
        }catch (IncorrectCredentialsException e){//密码错误
            e.printStackTrace();
            return 2;
        }catch (Exception e){//未知错误
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return true;
    }

    @Override
    public Integer register(User user) {
        if(user.getUserId().isEmpty()||user.getUserPassword().isEmpty())
            return 0;
        //添加cost
        Cost cost=new Cost();
        cost.setPatientId(user.getUserId());
        costMapper.insert(cost);
        return userMapper.insert(user);
    }
}
