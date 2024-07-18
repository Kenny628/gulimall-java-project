package com._yzhheng.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

import com._yzhheng.persistence.entities.PmsSkuImages;
import com._yzhheng.persistence.entities.PmsSkuInfo;
import com._yzhheng.persistence.entities.PmsSpuInfoDesc;
import com._yzhheng.rest.databaseDto.PmsSkuItemSaleAttrVo;
import com._yzhheng.rest.databaseDto.SpuItemAttrGroupDto;

import jakarta.annotation.sql.DataSourceDefinition;

@ToString
@Data
public class SkuItemVo {
    // sku基本信息
    private PmsSkuInfo info;

    // 有货
    private boolean hasStock = true;
    // // 库存
    // Map<Long, Boolean> stocks;

    // sku的图片信息
    private List<PmsSkuImages> images;

    // spu的销售属性组合
    private List<PmsSkuItemSaleAttrVo> saleAttr;

    // spu的介绍
    private PmsSpuInfoDesc desc;

    // spu的规格参数信息
    private List<SpuItemAttrGroupDto> groupAttrs;

    // @Data
    // public static class PmsSkuItemSaleAttrVo {
    // private Long attrId;
    // private String attrName;
    // private String attrValues;
    // }

    // @Data
    // public static class SpuItemBaseAttrVo {
    // private String attrGroupName;
    // private List<SpuBaseAttrVo> attrValues;
    // }

    // @Data
    // public static class SpuBaseAttrVo {
    // private String attrName;
    // private String attrValue;
    // }

}
