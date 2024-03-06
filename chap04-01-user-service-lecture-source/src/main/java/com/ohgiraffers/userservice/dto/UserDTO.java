package com.ohgiraffers.userservice.dto;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String pwd;
    private String userId;
    private java.util.Date enrollDate;

    /* 설명. FeignClient 이후 */
    private List<ResponseOrder> orders;
}
