package com._yzhheng.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._yzhheng.dto.SkuEsModel;
import com._yzhheng.rest.services.SaveToEsService;

@RequestMapping("/search/save")
@RestController
public class ElasticSaveController {

    @Autowired
    private SaveToEsService productSaveService;

    /**
     * es中保存商品上架
     * 
     * @param skuEsModels
     * @return
     */
    @PostMapping("/product")
    public ResponseEntity<Void> productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {
        boolean b = false;
        try {
            b = productSaveService.productStatusUp(skuEsModels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        if (!b) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
