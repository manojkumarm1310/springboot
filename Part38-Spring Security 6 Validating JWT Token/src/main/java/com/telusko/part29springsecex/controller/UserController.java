package com.telusko.part29springsecex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.telusko.part29springsecex.model.UsersValid;
import com.telusko.part29springsecex.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public UsersValid register(@RequestBody UsersValid user) {
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody UsersValid user) {

        return service.verify(user);
    }
}
