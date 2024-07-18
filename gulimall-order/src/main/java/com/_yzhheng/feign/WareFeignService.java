package com._yzhheng.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com._yzhheng.vo.WareSkuLockVo;

@FeignClient("gulimall-ware")
public interface WareFeignService {
    @PostMapping("/api/v1/WmsWareSku/lock/order")
    public ResponseEntity<Void> orderLockStock(@RequestBody WareSkuLockVo wareSkuLockVo);
}
