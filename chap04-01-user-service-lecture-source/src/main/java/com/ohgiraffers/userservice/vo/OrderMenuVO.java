package com.ohgiraffers.userservice.vo;

import lombok.Data;

@Data
public class OrderMenuVO {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
