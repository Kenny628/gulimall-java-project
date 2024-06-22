package com._yzhheng.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * TODO: Dependency: spring-boot-configuration-processor
 */
@ConfigurationProperties(prefix = "gulimall.thread")
@Component
@Data
public class ThreadPoolConfigPropeties {

    private Integer coreSize;
    private Integer maxSize;
    private Integer keepAliveTime;
}
