package com._yzhheng.vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderSubmitVo {
    private Long addrId;
    private Integer payType;
    private String orderToken;
    private BigDecimal payPrice;
    private String note;
}
