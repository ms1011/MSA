package com.ohgiraffers.userservice.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String pwd;
    private String userId;
    private java.util.Date enrollDate;
}
