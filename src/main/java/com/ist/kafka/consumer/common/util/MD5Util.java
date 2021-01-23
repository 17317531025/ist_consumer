package com.ist.kafka.consumer.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

public class MD5Util {
	/**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @return 签名结果
     */
    public static String sign(String text, String key, String textCharset) {
    	text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, textCharset));
    }
    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    public static void main(String[] args) {
		System.out.println(sign("params=[{\"name\":\"{productName}\",\"val\":\"1\"},{\"name\":\"{validCode}\",\"val\":\"2\"},{\"name\":\"{1}\",\"val\":\"4\"}]&partnerId=2019261003&phones=13817183922&templateId=SMS000013&transactionId=20191012172401000&time=20191012172401", "d38d67815747576a3e6d827fd1ded2c2", "UTF-8"));
	}
}
