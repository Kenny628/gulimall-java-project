/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com._yzhheng.application.Application;

/**
 * Spring Boot entry point <br>
 * 
 * In order to use "Convention Over Configuration" this class is supposed to be
 * located <br>
 * at the top level of the packages hierarchy
 * 
 * @author Telosys
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
// If this class is not at the top level of the packages hierarchy use
// @ComponentScan
// for example : @ComponentScan(basePackages = "org.demo")
public class SpringBootStarter {

    /**
     * Main entry point for Spring Boot starting
     * 
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(SpringBootStarter.class, args);

        // get the application bean (the "root component")
        Application application = appContext.getBean(Application.class);

        // launch application with its own entry point method
        application.run(args);
    }

}
