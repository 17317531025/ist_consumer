package com.ist.kafka.consumer.common;

/**
 * 响应状态码及描述信息
 * @Author: ligun
 */
public class ResultConstant {
    public static String SUCCESS_CODE = "0";
    public static String SUCCESS_CODE_MSG = "success";

    public static String PARAM_ERROR_CODE = "901";
    public static String PARAM_ERROR_MSG = "参数缺失";
    public static String SIGN_ERROR_CODE = "903";
    public static String SIGN_ERROR_MSG = "签名校验失败";
    public static String TOKENID_ERROR_CODE = "105";
    public static String TOKEN_ERROR_MSG = "tokenId错误";

    public static String SOCKET_USER_NOT_EXIST_CURRENT_NODE_CODE = "904";
    public static String SOCKET_USER_NOT_EXIST_CURRENT_NODE_MSG = "session不在当前服务器上";
    public static String APP_ERROR_CODE = "999";
    public static String APP_ERROR_MSG = "服务暂时不可用,请稍后再试";



}
