package com.mengliu.springbdemo.controller;

import com.mengliu.springbdemo.model.User;
import com.mengliu.springbdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login 1234啊实打实222的 333";
    }

    /**
     * 示例：通过 Service 查询用户（需 MySQL 中存在 users 表及数据）
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
