package com.mengliu.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mengliu.bigevent.pojo.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `user` (username, password, create_time, update_time) VALUES (#{username}, #{password}, NOW(), NOW())")
    void insert(String username, String password);

    @Select("SELECT * FROM `user` WHERE username = #{username}")
    User selectByUsername(String username);

}
