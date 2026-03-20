package com.mengliu;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        try {
            String createUserTableSQL = """
                    CREATE TABLE IF NOT EXISTS users (
                        id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        email VARCHAR(100) NOT NULL,
                        password VARCHAR(100) NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        UNIQUE (email)
                    )
                    """;

            jdbcTemplate.update(createUserTableSQL);
        } catch (Exception e) {
            e.printStackTrace(); // 打印完整堆栈信息
            throw e; // 重新抛出异常
        }

    }
}