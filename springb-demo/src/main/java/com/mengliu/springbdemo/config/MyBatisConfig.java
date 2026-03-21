package com.mengliu.springbdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mengliu.springbdemo.mapper")
public class MyBatisConfig {
}

