package com._yzhheng.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com._yzhheng.rest.dto.PmsBrandDTO;
import com._yzhheng.rest.dto.PmsSkuInfoDTO;
import com._yzhheng.rest.services.DisplayProductsService;

@Controller
public class IndexController {

    @Autowired
    DisplayProductsService displayProductsService;

    @GetMapping({ "/", "search.html" })
    public String home(@RequestParam(value = "keyword", defaultValue = " ") String keyword,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(value = "catalog3Id", defaultValue = "0") Long catalog3Id,
            @RequestParam(value = "sort", required = false, defaultValue = "defaultSort") String sort,
            Model model) {
        // Use the 'number' parameter here
        Page<PmsSkuInfoDTO> pmsSkuInfoDTO = displayProductsService.searchSkuByUserInputedText(keyword, pageNumber, 12,
                catalog3Id, sort);
        List<PmsSkuInfoDTO> pmsSkuInfoDTOAll = displayProductsService.searchALLSkusByUserInputedText(keyword,
                catalog3Id);
        Map<Integer, String> brandMap = new HashMap<>();
        int count = 0;
        for (PmsSkuInfoDTO pmsSkuInfoDTO2 : pmsSkuInfoDTOAll) {
            System.out.println(pmsSkuInfoDTO2.toString());
            System.out.println("printtttt1");
            if (!brandMap.containsValue(pmsSkuInfoDTO2.getBrandId().toString())) {
                count++;
                System.out.println("printtttt");
                brandMap.put(count, pmsSkuInfoDTO2.getBrandId().toString());
            }
        }

        for (Map.Entry<Integer, String> entry : brandMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
        List<PmsBrandDTO> dtos = displayProductsService
                .getRequiredBrandConditionByBrandId(new ArrayList<String>(brandMap.values())).getBody();
        for (PmsBrandDTO dto : dtos) {
            System.out.println("SuccessPrinted" + dto.toString());
        }
        // displayProductsService.getRequiredFilterConditionByCatelogId(pmsSkuInfoDTO.getContent().get(0).getCatalogId());
        // for (PmsSkuInfoDTO pmsSkuInfoDTO2 : pmsSkuInfoDTO) {
        // System.out.println(pmsSkuInfoDTO2.toString());
        // }
        model.addAttribute("productPage", pmsSkuInfoDTO);
        model.addAttribute("brandDetails", dtos);
        return "search";
    }

}
