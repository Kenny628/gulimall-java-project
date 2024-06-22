package com._yzhheng.rest.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com._yzhheng.rest.dto.PmsSkuInfoDTO;

@FeignClient("gulimall-product")
public interface ProductFeign {
    @GetMapping("api/v1/PmsSkuInfo/searchSku/{userInputedText}")
    public ResponseEntity<Page<PmsSkuInfoDTO>> searchSkuByUserInputedText(@PathVariable String userInputedText,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize);
}
