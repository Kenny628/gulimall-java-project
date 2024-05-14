package com._yzhheng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com._yzhheng.rest.services.PmsSkuInfoService;
import com._yzhheng.vo.SkuItemVo;

import java.util.concurrent.ExecutionException;

/**
 * 前端详情页Controller
 * 
 * @author Starsea
 * @date 2022-04-24 21:56
 */
@Controller
public class ItemController {

    @Autowired
    private PmsSkuInfoService skuInfoService;

    /**
     * 获取详情页数据并跳转
     * 
     * @param skuId
     * @param model
     * @return
     */
    @GetMapping("/item/{skuId}")
    public String skuItem(@PathVariable("skuId") Long skuId, Model model)
            throws ExecutionException, InterruptedException {
        System.out.println("准备查询：" + skuId + "的详情...");
        // skuInfoService.item(skuId);
        SkuItemVo skuItemVo = skuInfoService.item(skuId);
        model.addAttribute("item", skuItemVo);
        return "item";
    }
}
