package com._yzhheng.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class OAuth2Controller {

    // can consider use okhttp or resttemplate
    @GetMapping("/oauth2/github/success")
    public String github(@RequestParam String code) {
        return "";
    }
}
