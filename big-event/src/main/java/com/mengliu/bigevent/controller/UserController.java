package com.mengliu.bigevent.controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mengliu.bigevent.pojo.Result;
import com.mengliu.bigevent.pojo.User;
import com.mengliu.bigevent.service.UserService;
import com.mengliu.bigevent.utils.JwtUtil;
import com.mengliu.bigevent.utils.Md5Util;
import com.mengliu.bigevent.utils.ThreadLocalUtil;

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
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);

        }
        return Result.error("Invalid password");

    }

    @GetMapping("/userInfo")
    public Result<User> userInfo() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        if (claims == null) {
            return Result.error("User not found");
        }
        String username = (String) claims.get("username");
        User user = userService.findByUsername(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody User user) {
        if (userService.update(user)) {
            return Result.success();
        }
        return Result.error("Update failed");
    }

    // 修改头像
    @PatchMapping("/updateAvatar")
    public Result<?> updateAvatar(@RequestParam @URL String avatar) {
        if(userService.updateAvatar(avatar)){
            return Result.success();
        }
        return Result.error("Update avatar failed");
    }

    // 修改密码
    @PatchMapping("/updatePassword")
    public Result<?> updatePassword(@RequestParam String oldPassword, @RequestParam String newPassword) {
        if(userService.updatePassword(oldPassword, newPassword)){
            return Result.success();
        }
        return Result.error("Update password failed");
    }
}
