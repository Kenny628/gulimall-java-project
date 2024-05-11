package com._yzhheng.rest.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com._yzhheng.dto.HasStockDto;

@FeignClient("gulimall-ware")
public interface WareFeign {
    @PostMapping("api/v1/WmsWareSku/hasStock")
    public ResponseEntity<List<HasStockDto>> getSkuHasStock(@RequestBody List<Long> skuIds);
}
