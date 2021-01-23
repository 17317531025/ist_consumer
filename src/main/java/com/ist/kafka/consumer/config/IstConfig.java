package com.ist.kafka.consumer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
public class IstConfig {
    @Value("${spring.profiles.active}")
    private String springProfilesActive;
    @Value("${server.port}")
    private String serverPort;
    @Value("msg.isInsertSwitch:0")
    private String IsInsertMsgSwitch;
    @Value("${msg.kafkaTopic:chatMessage}")
    private String kafkaTopic;
    @Value("${kafka.listener.sleepSwitch:0}")
    private Integer listenSleepSwitch;
}
