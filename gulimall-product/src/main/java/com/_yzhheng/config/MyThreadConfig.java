package com._yzhheng.config;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyThreadConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(ThreadPoolConfigPropeties threadPoolConfigPropeties) {
        return new ThreadPoolExecutor(threadPoolConfigPropeties.getCoreSize(), threadPoolConfigPropeties.getMaxSize(),
                threadPoolConfigPropeties.getKeepAliveTime(), TimeUnit.SECONDS, new LinkedBlockingDeque<>(100000));
    }
}
