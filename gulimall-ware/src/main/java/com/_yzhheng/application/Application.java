/*
 * Created on 2024-05-02 ( 19:42:32 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Application launched by SpringBoot starter
 * 
 * @author Telosys
 *
 */
@Component
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
    /**
     * Application entry point called by SpringBoot starter
     * 
     * @param args
     */
    public void run(String[] args) {
    	logger.info("Starting application...");
    	logger.debug("Starting application : args.length = {}", args.length);

    }
}