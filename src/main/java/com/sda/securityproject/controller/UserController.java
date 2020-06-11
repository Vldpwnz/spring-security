package com.sda.securityproject.controller;


import com.sda.securityproject.model.User;
import com.sda.securityproject.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }


    @GetMapping("/sign-up")
    public String allUsers(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }


    @PostMapping("/sign-up")
    public String createUserToDB(@ModelAttribute User user){
        repository.save(user);
        return "signup";
    }

}
