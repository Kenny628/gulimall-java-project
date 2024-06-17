package com._yzhheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com._yzhheng.inteceptor.CartInteceptor;
import com._yzhheng.vo.UserInfoTo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    /**
     * Browser has session: user-key, use to indicate user identity, expired after
     * one month
     * 
     * If first time use this function, all will get this cookie
     * 
     * Brower will save it,every time access will bring it
     * 
     * @param session
     * @return
     */
    @GetMapping("/cart.html")
    public String cartListPage(HttpSession session) {
        UserInfoTo userInfoTo = CartInteceptor.threadLocal.get();
        return "cartList";
    }
}
