package com.ist.kafka.consumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean(name = "all_log")
    public Logger getAllLog(){
        Logger logger = LoggerFactory.getLogger("allLogger");
        return logger;
    }
}
