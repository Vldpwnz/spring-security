package com.sda.securityproject.repository;

import com.sda.securityproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    Integer removeUserByUserName(String userName);
}
