package com._yzhheng.rest.databaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleVoWihtSkuIds {
    private String attrValue;
    private String skuIds;
}