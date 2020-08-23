package com.mytest.replenisher.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReplenishRequest {
    private Integer client;
    private Integer provider;
    private BigDecimal sum;
}
