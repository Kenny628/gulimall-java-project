package com._yzhheng.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com._yzhheng.vo.MemberAddressVo;
import com._yzhheng.vo.OrderItemVo;
import com._yzhheng.vo.UmsMemberReceiveAddressDTO;

@FeignClient("gulimall-cart")
public interface CartFeignService {
    // TODO: Search why feign can use differnt return type and method name as
    // original feign client, is it depeneds on mapping route?
    @GetMapping("/getCurrentUserCartItems/{username}")
    public ResponseEntity<List<OrderItemVo>> getCurrentUserCartItems(@PathVariable String username);
}
