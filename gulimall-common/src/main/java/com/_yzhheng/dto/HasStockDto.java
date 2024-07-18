package com._yzhheng.dto;

import lombok.Data;

@Data
public class HasStockDto {
    private Long skuId;
    private Boolean hasStock;// 是否有库存
}
