package com._yzhheng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com._yzhheng.inteceptor.CartInteceptor;

@Configuration
public class GulimallWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(new CartInteceptor()).addPathPatterns("/**")
                .excludePathPatterns("/getCurrentUserCartItems/*");
        // WebMvcConfigurer.super.addInterceptors(registry);
    }
}
