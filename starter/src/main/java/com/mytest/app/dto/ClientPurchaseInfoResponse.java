package com.mytest.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientPurchaseInfoResponse {
    private int clientId;
    private String clientName;
    private long num;
}
