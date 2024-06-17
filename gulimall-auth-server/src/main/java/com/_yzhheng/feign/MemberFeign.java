package com._yzhheng.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com._yzhheng.vo.SocialUserLogin;
import com._yzhheng.vo.UserLoginVo;
import com._yzhheng.vo.UserRegisVo;

@FeignClient("gulimall-member")
public interface MemberFeign {
    @PostMapping("api/v1/UmsMember/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisVo memberRegisVo);

    @PostMapping("api/v1/UmsMember/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginVo userLoginVo);

    @PostMapping("api/v1/UmsMember/oauth2/login")
    public ResponseEntity<String> loginUser(@RequestBody SocialUserLogin socialUserLogin);
}
