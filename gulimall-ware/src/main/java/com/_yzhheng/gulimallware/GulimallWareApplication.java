package com._yzhheng.gulimallware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class GulimallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallWareApplication.class, args);
	}

}
