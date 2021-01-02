package com.example.hospital.service;

import com.example.hospital.entity.User;


public interface UserService {
    Integer login(User user);
    boolean logout();
    Integer register(User user);
}
