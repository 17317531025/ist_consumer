package com.ist.kafka.consumer.common.util;


import com.ist.kafka.consumer.common.CodeConstant;

/**
 * @Author: ligun
 */
public class RedisKeyUtil {
    public static String getUIDWebSocketURL(String userID){
        String redisKey = CodeConstant.REDIS_USER_USERID_SOCKET_SESSION_REL_PREFIX + userID;
        return redisKey;
    }
}
