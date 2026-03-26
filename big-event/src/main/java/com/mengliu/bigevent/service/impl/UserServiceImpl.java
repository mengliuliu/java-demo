package com.mengliu.bigevent.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mengliu.bigevent.mapper.UserMapper;
import com.mengliu.bigevent.pojo.User;
import com.mengliu.bigevent.service.UserService;
import com.mengliu.bigevent.utils.Md5Util;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void register(String username, String password) {
        String md5Password = Md5Util.getMD5String(password);
        userMapper.insert(username, md5Password);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public boolean update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.update(user) > 0;
    }
}
