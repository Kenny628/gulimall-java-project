package com._yzhheng.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com._yzhheng.vo.SpuInfoVo;

@FeignClient("gulimall-product")
public interface ProductFeignService {
    @GetMapping("/api/v1/PmsSpuInfo/getSpuInfoBySkuId/{id}")
    public ResponseEntity<SpuInfoVo> getSpuInfoBySkuId(@PathVariable Long id);
}
