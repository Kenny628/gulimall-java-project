package com._yzhheng.rest.databaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Starsea
 * @date 2022-04-27 20:18
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleVoWihtSkuIds {
    private String attrValue;
    private String skuIds;
}