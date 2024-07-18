package com._yzhheng.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com._yzhheng.inteceptor.CartInteceptor;
import com._yzhheng.service.CartService;
import com._yzhheng.vo.Cart;
import com._yzhheng.vo.CartItem;
import com._yzhheng.vo.UserInfoTo;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    CartService cartService;

    @GetMapping("/cart.html")
    public String cartListPage(HttpSession session, Model model) throws ExecutionException, InterruptedException {
        Cart cartVo = cartService.getCart();
        model.addAttribute("cart", cartVo);
        return "cartList";
    }

    // TODO: Compare ra.addAttribute(将attribute自动放在url后方) and
    // ra.addFlashAttribute(放在session 只能用一次)
    @GetMapping("/addToCart")
    public String addToCart(@RequestParam Long skuId, @RequestParam Integer num, RedirectAttributes ra)
            throws ExecutionException, InterruptedException {
        cartService.addToCart(skuId, num);
        ra.addAttribute("skuId", skuId);
        return "redirect:http://cart.gulimall.com:8600/addToCartSuccess.html";

    }

    @GetMapping("/addToCartSuccess.html")
    public String getMethodName(@RequestParam Long skuId, Model model) {
        CartItem item = cartService.getCartItem(skuId);
        model.addAttribute("cartItem", item);
        return "success";
    }

    @GetMapping("/checkItem")
    public String checkItem(@RequestParam("skuId") Long skuId, @RequestParam("check") Integer check) {
        cartService.checkItem(skuId, check);
        return "redirect:http://cart.gulimall.com:8600/cart.html";
    }

    /**
     * 修改购物项数量
     * 
     * @return
     */
    @GetMapping("/countItem")
    public String countItem(@RequestParam("skuId") Long skuId, @RequestParam("num") Integer num) {
        cartService.countItem(skuId, num);
        return "redirect:http://cart.gulimall.com:8600/cart.html";
    }

    /**
     * 删除某件商品
     * 
     * @param skuId
     * @return
     */
    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam("skuId") Long skuId) {
        cartService.deleteItem(skuId);
        return "redirect:http://cart.gulimall.com:8600/cart.html";
    }

    @GetMapping("/getCurrentUserCartItems/{username}")
    // TODO: @ResponseBody
    public ResponseEntity<List<CartItem>> getCurrentUserCartItems(@PathVariable String username) {
        return ResponseEntity.ok(cartService.getCurrentUserCartItems(username));
    }
}
