package com.mengliu.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mengliu.bigevent.pojo.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `user` (username, password, create_time, update_time) VALUES (#{username}, #{password}, now(), now())")
    void insert(String username, String password);

    @Select("SELECT * FROM `user` WHERE username = #{username}")
    User selectByUsername(String username);

    @Update("UPDATE `user` SET email = #{email}, nickname = #{nickname}, update_time = #{updateTime} WHERE id = #{id}")
    int update(User user);

    @Update("UPDATE `user` SET user_pic = #{userPic}, update_time = #{updateTime} WHERE id = #{id}")
    int updateAvatar(User user);

    @Update("UPDATE `user` SET password = #{password}, update_time = #{updateTime} WHERE id = #{id}")
    int updatePassword(User user);

}
