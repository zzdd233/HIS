package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class User {
    @TableId
    public Integer id;
    public String password;


    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
