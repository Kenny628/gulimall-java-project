package com._yzhheng.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com._yzhheng.rest.dto.PmsSkuInfoDTO;
import com._yzhheng.rest.services.DisplayProductsService;

@Controller
public class IndexController {

    @Autowired
    DisplayProductsService displayProductsService;

    @GetMapping({ "/", "search.html" })
    public String home(@RequestParam("keyword") String keyword, @RequestParam(defaultValue = "0") int pageNumber,
            Model model) {
        // Use the 'number' parameter here
        Page<PmsSkuInfoDTO> pmsSkuInfoDTO = displayProductsService.searchSkuByUserInputedText(keyword, pageNumber, 8);
        for (PmsSkuInfoDTO pmsSkuInfoDTO2 : pmsSkuInfoDTO) {
            System.out.println(pmsSkuInfoDTO2.toString());
        }
        model.addAttribute("productPage", pmsSkuInfoDTO);
        return "search";
    }

}
