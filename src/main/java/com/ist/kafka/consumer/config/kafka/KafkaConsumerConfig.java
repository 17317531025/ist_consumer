package com.ist.kafka.consumer.config.kafka;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: sunhaitao
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    @Value("${kafka.consumer.servers}")
    private String bootstrapServers;
    @Value("${kafka.consumer.max-poll-records}")
    private Integer maxPollRecords;
    @Value("${kafka.consumer.max-partition-fetch-bytes}")
    private Integer maxPartitionFetchBytes;
    @Value("${kafka.listener.batch-listener}")
    private Boolean batchListener;
    @Value("#{'${kafka.listener.concurrencys}'.split(',')[1]}")
    private Integer concurrency6;
    @Value("${kafka.consumer.receive-buffer-bytes:65536}")
    private Integer receiveBufferConfig;
    private ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setPollTimeout(1500);
        factory.setBatchListener(batchListener);
        //设置偏移量的方式

//        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
    @Bean
    @ConditionalOnMissingBean(name = "kafkaBatchListener6")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaBatchListener6() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = kafkaListenerContainerFactory();
        factory.setConcurrency(concurrency6);
        return factory;
    }

    public Map<String, Object> consumerConfigs() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("group.id", "chatMessage"); //获取服务器Ip作为groupId
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        properties.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, maxPartitionFetchBytes);
        properties.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG,receiveBufferConfig);
        properties.put("auto.offset.reset", "latest");
        properties.put("session.timeout.ms", "30000");

        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    public String getIPAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            if (address != null && StringUtils.isNotBlank(address.getHostAddress())) {
                return address.getHostAddress();
            }
        }catch (UnknownHostException e) {
            return UUID.randomUUID().toString().replace("-","");
        }
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 自定义监听
     */
    @Bean
    public MyKafkaListener listener() {
        return new MyKafkaListener();
    }
}
