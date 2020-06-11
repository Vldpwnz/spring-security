package com.sda.securityproject.service;

import com.sda.securityproject.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    Integer removeUserByUserName(String userName);
    void createUser(User user);
}
