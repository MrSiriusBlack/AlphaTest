package com.mytest.app.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private Integer client;
    private String product;
    private BigDecimal sum;
}
