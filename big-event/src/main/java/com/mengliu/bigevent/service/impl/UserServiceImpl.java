package com.mengliu.bigevent.service.impl;

import java.time.LocalDateTime;
import java.util.Map;
import com.mengliu.bigevent.pojo.Result;
import org.springframework.stereotype.Service;

import com.mengliu.bigevent.mapper.UserMapper;
import com.mengliu.bigevent.pojo.User;
import com.mengliu.bigevent.service.UserService;
import com.mengliu.bigevent.utils.Md5Util;
import com.mengliu.bigevent.utils.ThreadLocalUtil;
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
        Map<String, Object> claims = ThreadLocalUtil.get();
        if (claims == null || claims.get("id") == null) {
            return false;
        }

        Integer userId = (Integer) claims.get("id");
        user.setId(userId);
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean updateAvatar(String avatar) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        if (claims == null || claims.get("id") == null) {
            return false;
        }

        Integer userId = (Integer) claims.get("id");
        User user = new User();
        user.setId(userId);
        user.setUserPic(avatar);
        user.setUpdateTime(LocalDateTime.now());

        return userMapper.updateAvatar(user) > 0;
    }
}
