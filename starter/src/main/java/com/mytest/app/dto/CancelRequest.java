package com.mytest.app.dto;

import lombok.Data;

@Data
public class CancelRequest {
    private int client;
    private String product;
}
