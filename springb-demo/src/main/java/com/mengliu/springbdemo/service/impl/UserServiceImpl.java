package com.mengliu.springbdemo.service.impl;

import com.mengliu.springbdemo.mapper.UserMapper;
import com.mengliu.springbdemo.model.User;
import com.mengliu.springbdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Service 层实现：调用 Mapper 访问数据库
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
