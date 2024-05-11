package com._yzhheng.rest.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com._yzhheng.dto.SkuEsModel;

@FeignClient("gulimall-search")
public interface SearchFeign {
    @PostMapping("search/save/product")
    public ResponseEntity<Void> productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
