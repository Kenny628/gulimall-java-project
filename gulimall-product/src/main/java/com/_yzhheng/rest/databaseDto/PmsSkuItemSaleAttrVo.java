package com._yzhheng.rest.databaseDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PmsSkuItemSaleAttrVo {
    private String attrName;
    private List<SaleVoWihtSkuIds> attrValues;
}