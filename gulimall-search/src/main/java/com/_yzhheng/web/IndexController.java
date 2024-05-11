package com._yzhheng.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping({ "/", "search.html" })
    public String home() {
        return "search";
    }

}
