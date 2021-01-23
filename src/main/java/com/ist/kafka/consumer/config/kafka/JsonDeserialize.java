package com.ist.kafka.consumer.config.kafka;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
public class JsonDeserialize implements Deserializer<JSONObject> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public JSONObject deserialize(String topic, byte[] data) {
        JSONObject obj = null;
        try {
            obj = JSONObject.parseObject(new String(data,"UTF-8"));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void close() {

    }
}
