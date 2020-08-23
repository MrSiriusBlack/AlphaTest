package com.mytest.activator.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SellRequest {
    private int client;
    private String product;
    private BigDecimal sum;
}
