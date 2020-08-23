package com.mytest.app.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositRequest {
    private String clientId;
    private BigDecimal sum;
}
