package com.mengliu.bigevent.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;

    private String email;
    private String nickname;
    private String userPic;
    
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
