package com.mengliu.bigevent.service;

import com.mengliu.bigevent.pojo.User;

public interface UserService {
    void register(String username, String password);

    User findByUsername(String username);

}
