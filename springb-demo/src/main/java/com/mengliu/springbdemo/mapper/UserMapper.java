package com.mengliu.springbdemo.mapper;

import com.mengliu.springbdemo.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectById(@Param("id") Integer id);
}

