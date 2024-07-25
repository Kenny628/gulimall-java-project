package com._yzhheng.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._yzhheng.persistence.entities.PmsCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._yzhheng.persistence.entities.PmsCategory;
import com._yzhheng.rest.dto.PmsSkuInfoDTO;
import com._yzhheng.rest.services.PmsCategoryService;
import com._yzhheng.rest.services.PmsSkuInfoService;

@Controller
public class IndexController {

    @Autowired
    PmsCategoryService categoryService;

    @Autowired
    PmsSkuInfoService pmsSkuInfoService;

    @GetMapping({ "/", "/index.html" })
    public String indexPage(Model model) {
        // 查询所有一级分类
        List<PmsCategory> categoryEnties = categoryService.getLevel1Category();
        for (PmsCategory m : categoryEnties) {
            System.out.println(m.getName());
        }
        List<PmsSkuInfoDTO> allProducts = pmsSkuInfoService.findAll();
        model.addAttribute("category", categoryEnties);
        model.addAttribute("productPage", allProducts);
        // 视图解析器进行拼串
        // classpath:/templates/ + 返回值 + .html
        return "index";
    }

    /**
     * 查询二级分类和三级分类
     * 
     * @return
     */
    @GetMapping("/index/json/catalog.json")
    public ResponseEntity<Map<String, List<Catelog2Vo>>> getCatalogJson() {
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return ResponseEntity.ok(catalogJson);
    }
}
