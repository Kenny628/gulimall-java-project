package com._yzhheng.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com._yzhheng.vo.OrderVo;

@FeignClient("gulimall-order")
public interface OrderFeign {
    @GetMapping("/api/v1/OmsOrder/orderNumber/{orderSn}")
    public ResponseEntity<OrderVo> getOrderStatus(@PathVariable String orderSn);
}
