package com._yzhheng.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com._yzhheng.rest.Feign.ProductFeign;
import com._yzhheng.rest.dto.PmsBrandDTO;
import com._yzhheng.rest.dto.PmsSkuInfoDTO;

@Service
public class DisplayProductsService {
    @Autowired
    ProductFeign productFeign;

    public Page<PmsSkuInfoDTO> searchSkuByUserInputedText(String keyword, int pageNumber, int pageSize,
            Long catalog3Id, String sort) {
        return productFeign.searchSkuByUserInputedText(keyword, pageNumber, pageSize, catalog3Id, sort).getBody();
    }

    public List<PmsSkuInfoDTO> searchALLSkusByUserInputedText(String keyword, Long catalog3Id) {
        return productFeign.searchALLSkusByUserInputedText(keyword, catalog3Id).getBody();
    }

    public ResponseEntity<List<PmsBrandDTO>> getRequiredBrandConditionByBrandId(ArrayList<String> arrayList) {
        return productFeign.findByMutipleId(arrayList);
    }
}
