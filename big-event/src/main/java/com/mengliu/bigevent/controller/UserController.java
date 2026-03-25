package com.mengliu.bigevent.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.pojo.User;
import com.mengliu.bigevent.service.UserService;
import com.mengliu.bigevent.utils.JwtUtil;
import com.mengliu.bigevent.utils.Md5Util;

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
        } else {
            userService.register(username, password);
            return Result.success();
        }
    }

    @PostMapping("/login")
    public Result<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return Result.error("User not found");
        }

        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", username);
            String token = JwtUtil.genToken(claims);
            return Result.success(token);

        }
        return Result.error("Invalid password");

    }

}
