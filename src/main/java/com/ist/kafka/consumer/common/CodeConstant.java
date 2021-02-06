package com.ist.kafka.consumer.common;

import java.io.File;

/**
 * 常量定义
 */
public class CodeConstant {
    public static final int DISPLACEMENT_NUMBER = 2;

    public static final String REDIS_USER_USERID_SOCKET_SESSION_REL_PREFIX = "IST:USERID:SOCKET:SESSION:";
    public static final String REDIS_APP_KEY_PREFIX = "IST:APP:SECRET:";

    public interface RedisSaveTime{
        public static final long USER_ID_SOCKET_URL = 365*24*60*60;
        public static final long REDIS_SAVE_TIME_24h = 24*60*60;
    }

    public static final String ENVIRONMENT_NO="3";

    public interface Path{
        public static final String IST_IMAGE = File.separator+"ist";
    }
    public interface IstSvc{
        public static final String USER_VERIFY_TOKEN = "user/userVerifyToken";
        public static final String USER_QUERY_CLIENT_ID = "user/queryUserClientIdByUserId";
    }
}
