package com.mengliu.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.pojo.User;
import com.mengliu.bigevent.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<User> register(@RequestParam String username, @RequestParam String password) {

        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            return Result.error("Username already exists");
        }else {
            userService.register(username, password);
            return Result.success();
        }
    }
    

}
