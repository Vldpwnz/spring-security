package com.sda.securityproject.service;


import com.sda.securityproject.model.User;
import com.sda.securityproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public Integer removeUserByUserName(String userName) {
        userRepository.removeUserByUserName(userName);
        return null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
