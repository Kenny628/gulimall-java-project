package com._yzhheng.payment;

import lombok.Data;

@Data
public class ChargeRequest {
    private String token;
    private Long amount;

    // getters and setters
}