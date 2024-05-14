package com._yzhheng.rest.databaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PmsSkuItemSaleAttrVo {
    private Long attrId;
    private String attrName;
    private String attrValues;
}