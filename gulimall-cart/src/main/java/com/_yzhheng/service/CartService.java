package com._yzhheng.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com._yzhheng.feign.ProductFeignService;
import com._yzhheng.inteceptor.CartInteceptor;
import com._yzhheng.vo.Cart;
import com._yzhheng.vo.CartItem;
import com._yzhheng.vo.PmsSkuInfoDTO;
import com._yzhheng.vo.UserInfoTo;
import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ProductFeignService productFeignService;

    @Autowired
    ThreadPoolExecutor executor;

    public final String CART_PREFIX = "gulimall:cart:";

    public CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException {
        BoundHashOperations<String, Object, Object> cartOps = getCartOps();

        // 查询redis是否有当前商品
        String res = (String) cartOps.get(skuId.toString());
        System.out.println("Key: " + res);
        if (StringUtils.isEmpty(res)) {
            // 购物车无此商品，进行添加

            // 2.添加新商品到购物车
            CartItem cartItemVo = new CartItem();

            // 1.远程查询当前要添加的商品的信息
            CompletableFuture<Void> getSkuInfoTask = CompletableFuture.runAsync(() -> {
                ResponseEntity<PmsSkuInfoDTO> skuInfo = productFeignService.getSkuInfo(skuId);
                PmsSkuInfoDTO data = skuInfo.getBody();

                cartItemVo.setChecked(true);
                cartItemVo.setCount(num);
                cartItemVo.setImage(data.getSkuDefaultImg());
                cartItemVo.setPrice(data.getPrice());
                cartItemVo.setTitle(data.getSkuTitle());
                cartItemVo.setSkuId(skuId);
            }, executor);
            // 3.远程查询sku的组合信息
            CompletableFuture<Void> getSkuSaleAttrValues = CompletableFuture.runAsync(() -> {
                List<String> skuSaleAttrValues = productFeignService.getSkuSaleAttrValues(skuId).getBody();
                cartItemVo.setSkuAttr(skuSaleAttrValues);
            }, executor);

            // 等待异步都完成在执行后续
            CompletableFuture.allOf(getSkuInfoTask, getSkuSaleAttrValues).get();
            // 4.保存到redis中
            String s = JSON.toJSONString(cartItemVo);
            cartOps.put(skuId.toString(), s);

            return cartItemVo;
        } else {
            // 购物车有此商品，修改数量
            // TODO 个人觉得有问题：如果后台修改了价格呢，或者删除了这件商品呢。
            CartItem cartItem = JSON.parseObject(res, CartItem.class);
            cartItem.setCount(cartItem.getCount() + num);
            cartOps.put(skuId.toString(), JSON.toJSONString(cartItem));
            return cartItem;
        }
    }

    public Cart getCart() throws ExecutionException, InterruptedException {
        Cart cartVo = new Cart();
        UserInfoTo userInfoTo = CartInteceptor.threadLocal.get();
        if (userInfoTo.getUsername() != null) {
            // 用户已登录
            String cartKey = CART_PREFIX + userInfoTo.getUsername();
            // 临时购物车的键
            String temptCartKey = CART_PREFIX + userInfoTo.getUserkey();

            // 如果临时购物车的数据还未进行合并
            List<CartItem> tempCartItems = getCartItems(temptCartKey);
            if (tempCartItems != null) {
                // 临时购物车有数据需要进行合并操作
                for (CartItem item : tempCartItems) {
                    addToCart(item.getSkuId(), item.getCount());
                }
                // 清除临时购物车的数据
                clearCartInfo(temptCartKey);
            }

            // 获取登录后的购物车数据【包含合并过来的临时购物车的数据和登录后购物车的数据】
            List<CartItem> cartItems = getCartItems(cartKey);
            cartVo.setItems(cartItems);

            // 设置选中商品数量
            if (cartItems != null && cartItems.size() > 0) {
                int count = cartItems.stream().filter(obj -> {
                    return obj.getChecked() == true;
                }).mapToInt(CartItem::getCount).sum();
                cartVo.setCheckedNum(count);
            }
        } else {
            // 用户未登录
            String userKey = CART_PREFIX + userInfoTo.getUserkey();
            // 获取临时购物车的所有购物项
            List<CartItem> cartItems = getCartItems(userKey);
            cartVo.setItems(cartItems);
        }

        return cartVo;
    }

    public void clearCartInfo(String cartKey) {
        stringRedisTemplate.delete(cartKey);
    }

    /**
     * 获取购物车里面的数据
     * 
     * @param cartKey
     * @return
     */
    private List<CartItem> getCartItems(String cartKey) {
        // 获取购物车里面的所有商品
        BoundHashOperations<String, Object, Object> operations = stringRedisTemplate.boundHashOps(cartKey);
        List<Object> values = operations.values();
        if (values != null && values.size() > 0) {
            List<CartItem> collect = values.stream().map((obj) -> {
                String str = (String) obj;
                CartItem cartItem = JSON.parseObject(str, CartItem.class);
                return cartItem;
            }).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    public CartItem getCartItem(Long skuId) {
        BoundHashOperations<String, Object, Object> cartOps = getCartOps();
        String str = (String) cartOps.get(skuId.toString());
        CartItem cartItemVo = JSON.parseObject(str, CartItem.class);
        return cartItemVo;
    }

    public List<CartItem> getCurrentUserCartItems(String username) {
        // UserInfoTo userInfoTo = CartInteceptor.threadLocal.get();

        String cartKey = CART_PREFIX + username;
        List<CartItem> cartItems = getCartItems(cartKey);

        List<CartItem> listCartItems = cartItems.stream().filter(item -> item.getChecked()).map(item -> {
            BigDecimal price = productFeignService.getPrice(item.getSkuId()).getBody();
            item.setPrice(price);
            return item;
        }).collect(Collectors.toList());

        return listCartItems;

    }

    // TODO: Learn BoundHashOperations and why it return <String, Object, Object>
    private BoundHashOperations<String, Object, Object> getCartOps() {
        UserInfoTo userInfoTo = CartInteceptor.threadLocal.get();
        // 指定是临时购物车还是真实购物车
        String cartKey = "";// redis中存储的key
        if (userInfoTo.getUsername() != null) {
            // 用户登录了
            cartKey = CART_PREFIX + userInfoTo.getUsername();
        } else {
            // 用户没登录
            cartKey = CART_PREFIX + userInfoTo.getUserkey();
            System.out.println("User Key: " + userInfoTo.getUserkey());
        }

        BoundHashOperations<String, Object, Object> operations = stringRedisTemplate.boundHashOps(cartKey);
        return operations;
    }

    public void checkItem(Long skuId, Integer check) {
        BoundHashOperations<String, Object, Object> cartOps = getCartOps();
        CartItem cartItem = getCartItem(skuId);
        cartItem.setChecked(check == 1 ? true : false);
        String s = JSON.toJSONString(cartItem);
        cartOps.put(skuId.toString(), s);
    }

    /**
     * 修改购物项数量
     * 
     * @param skuId
     * @param num
     */

    public void countItem(Long skuId, Integer num) {
        // TODO 页面数量减少到0，应该删除该商品
        CartItem cartItem = getCartItem(skuId);
        cartItem.setCount(num);
        BoundHashOperations<String, Object, Object> cartOps = getCartOps();
        cartOps.put(skuId.toString(), JSON.toJSONString(cartItem));
    }

    /**
     * 删除某件商品
     * 
     * @param skuId
     * @return
     */

    public void deleteItem(Long skuId) {
        BoundHashOperations<String, Object, Object> cartOps = getCartOps();
        cartOps.delete(skuId.toString());
    }
}
