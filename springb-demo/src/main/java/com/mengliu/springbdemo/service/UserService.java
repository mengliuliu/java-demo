package com.mengliu.springbdemo.service;

import com.mengliu.springbdemo.model.User;

/**
 * Service 层：用户相关业务接口
 */
public interface UserService {

    /**
     * 根据主键查询用户
     */
    User getUserById(Integer id);
}
