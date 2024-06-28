package com._yzhheng.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com._yzhheng.vo.PmsSkuInfoDTO;

@FeignClient("gulimall-product")
public interface ProductFeignService {
    @GetMapping("/api/v1/PmsSkuInfo/{skuId}")
    public ResponseEntity<PmsSkuInfoDTO> getSkuInfo(@PathVariable Long skuId);

    @GetMapping("/api/v1/PmsSkuSaleAttrValue/getSkuAttrCombo/{skuid}")
    public ResponseEntity<List<String>> getSkuSaleAttrValues(@PathVariable Long skuid);
    // public ResponseEntity<PmsSkuInfoDTO> findById(@PathVariable Long skuId);
    // public ResponseEntity<PmsSkuInfoDTO> getSkuInfo(@PathVariable Long skuId);

}
