package com.ohgiraffers.orderservice.aggregate;

import lombok.Data;

@Data
public class OrderMenu {

    private int orderCode;
    private int menuCode;
    private int orderAmount;

}
