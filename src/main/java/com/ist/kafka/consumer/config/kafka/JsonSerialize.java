package com.ist.kafka.consumer.config.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonSerialize implements Serializer<JSONObject> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, JSONObject data) {
        try {
            return data.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {

    }
}
