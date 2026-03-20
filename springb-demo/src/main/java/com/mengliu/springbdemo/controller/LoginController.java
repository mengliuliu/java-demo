package com.mengliu.springbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "login 1234啊实打实222的 333";
    }
}
