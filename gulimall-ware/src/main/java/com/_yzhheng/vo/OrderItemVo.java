package com._yzhheng.vo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class OrderItemVo {
    private Long skuId;
    private Boolean checked;
    private String title;
    private String image;
    private List<String> skuAttr;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;
}
