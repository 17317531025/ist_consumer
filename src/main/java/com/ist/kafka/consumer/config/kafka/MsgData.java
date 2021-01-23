package com.ist.kafka.consumer.config.kafka;

import lombok.Data;

@Data
public class MsgData {
    private String timeId;
    private String no;
    private Integer msgType;
    private String content;
    private Integer contentType;
    private String sender;
    private String talker;
    private String createTime;
    private String shopId;
    private Integer status;
}
