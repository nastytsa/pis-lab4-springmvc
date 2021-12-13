package com.example.lab4.dto;

import lombok.Data;

@Data
public class OrderDto {
    String order_id;
    String client_id;
    String price;
    String comment;
    String status;
    String content;
}
