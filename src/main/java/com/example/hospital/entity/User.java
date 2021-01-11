package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class User {
    @TableId
    String userId;
    String userPassword;
    String userStatus;


   public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userID, String password) {
        this.userId = userID;
        this.userPassword = password;
        userStatus ="患者";
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
