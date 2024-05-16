package com._yzhheng.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com._yzhheng.vo.UserRegisVo;

@FeignClient("gulimall-member")
public interface MemberFeign {
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisVo memberRegisVo);
}
