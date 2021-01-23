package com.ist.kafka.consumer.config.kafka;

import com.ist.kafka.consumer.config.IstConfig;
import com.ist.kafka.consumer.service.ChatService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.Resource;
import java.util.List;

public class MyKafkaListener {
    @Autowired
    private ChatService chatService;
    @Resource(name="all_log")
    private Logger logger;
    @Autowired
    private IstConfig istConfig;
//    /**
//     * 发送聊天消息时的监听
//     * @param record
//     */
//    @KafkaListener(topics = "${kafkaTopic}")
//    public void listen(ConsumerRecord<?, ?> record) {
//        logger.info("chatMessage发送聊天消息监听："+record.value() +",topic:" +  record.topic() + ",partition:" + record.partition() + ",offset:" + record.offset() + ",key:" + record.key() + ",timestamp:" + record.timestamp() + ",timestampType:"+record.timestampType().toString());
//        chatService.dealOnMessage(record.value().toString(),null);
//    }

    @KafkaListener(containerFactory = "kafkaBatchListener6",topics = "${kafkaTopic}")
    public void batchListener(List<ConsumerRecord<?,?>> records){
        try {
//            ack.acknowledge();//直接提交offset
            logger.info("kafkaBatchListener6.size:" + records.size() + " currentThread.id" + Thread.currentThread().getId());
            if (istConfig.getListenSleepSwitch()==0){
                records.forEach(record -> {
                chatService.dealOnMessage(record.value().toString(),null);
                });
            }else {
                Thread.sleep(istConfig.getListenSleepSwitch());
            }
        } catch (Exception e) {
            logger.error("Kafka监听异常"+e.getMessage(),e);
        }

    }

    /**
     * 关闭连接时的监听
     * @param record
     */
//    @KafkaListener(topics = {"closeWebsocket"})
//    private void closeListener(ConsumerRecord<?, ?> record) {
//        logger.info("closeWebsocket关闭websocket连接监听："+record.value().toString());
////        ChatWebsocket chatWebsocket = new ChatWebsocket();
////        chatWebsocket.kafkaCloseWebsocket(record.value().toString());
//    }
}
