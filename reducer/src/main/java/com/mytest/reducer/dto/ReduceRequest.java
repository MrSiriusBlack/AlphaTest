package com.mytest.reducer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReduceRequest {
    private Integer client;
    private Integer provider;
    private BigDecimal sum;
}
