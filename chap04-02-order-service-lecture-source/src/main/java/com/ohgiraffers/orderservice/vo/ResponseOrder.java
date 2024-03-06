package com.ohgiraffers.orderservice.vo;

import com.ohgiraffers.orderservice.dto.OrderMenuDTO;
import lombok.Data;

import java.util.List;

@Data
public class ResponseOrder {
    private String orderDate;
    private String orderTime;

    private List<OrderMenuDTO> orderMenus;
}
