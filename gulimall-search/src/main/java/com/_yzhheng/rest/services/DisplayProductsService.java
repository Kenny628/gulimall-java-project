package com._yzhheng.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com._yzhheng.rest.Feign.ProductFeign;
import com._yzhheng.rest.dto.PmsSkuInfoDTO;

@Service
public class DisplayProductsService {
    @Autowired
    ProductFeign productFeign;

    public Page<PmsSkuInfoDTO> searchSkuByUserInputedText(String keyword, int pageNumber, int pageSize) {
        return productFeign.searchSkuByUserInputedText(keyword, pageNumber, pageSize).getBody();
    }
}
