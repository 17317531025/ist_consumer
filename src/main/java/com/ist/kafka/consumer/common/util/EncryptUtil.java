package com.ist.kafka.consumer.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncryptUtil {
	private static final String UTF8 = "utf-8";  
  
    private static final int RADIX = 32;
	private static final String SEED = "2013091313250120130913132501";
	
    private static EncryptUtil instance=null;
    
    public static EncryptUtil getInstance()throws Exception{
		if (instance==null)
		instance= new EncryptUtil();
		return instance;
    }
    
    private EncryptUtil(){
    }
    
    /** 
     * BASE64 加密 
     *  
     * @param src 
     * @return 
     * @throws Exception 
     */  
    public String base64Encoder(String src) throws Exception {  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(src.getBytes(UTF8));  
    }  
      
    /** 
     * BASE64解密 
     *  
     * @param dest 
     * @return 
     * @throws Exception 
     */  
    public String base64Decoder(String dest) throws Exception {  
        BASE64Decoder decoder = new BASE64Decoder();  
        return new String(decoder.decodeBuffer(dest), UTF8);  
    }  
      
    /** 
     * url加密 
     *  
     * @param src 
     * @return
     * @throws Exception 
     */  
    public String urlEncoder(String src) throws Exception {  
    	return URLEncoder.encode(base64Encoder(src),"utf-8");
    }  
      
    /** 
     * url解密 
     *  
     * @param dest 
     * @return
     * @throws Exception 
     */  
    public String urlDecoder(String dest) throws Exception {  
    	dest=URLDecoder.decode(dest,"utf-8");
        return base64Decoder(dest);
    }
      
    public static final String xorEncoder(String str) {
		if (str == null)
			return "";
		if (str.length() == 0)
			return "";

		BigInteger bi_passwd = new BigInteger(str.getBytes());

		BigInteger bi_r0 = new BigInteger(SEED);
		BigInteger bi_r1 = bi_r0.xor(bi_passwd);

		return bi_r1.toString(RADIX);
	}

	public static final String xorDecoder(String encrypted) {
		if (encrypted == null)
			return "";
		if (encrypted.trim().length() == 0)
			return "";

		BigInteger bi_confuse = new BigInteger(SEED);

		try {
			BigInteger bi_r1 = new BigInteger(encrypted, RADIX);
			BigInteger bi_r0 = bi_r1.xor(bi_confuse);

			return new String(bi_r0.toByteArray());
		} catch (Exception e) {
			return "";
		}
	}
    
    public static void main(String[] args) {
//    	String decodeStr = CodeConst.MEMCHACHE_TOKEN_ID +":" + "20000000000" + "-" + "1" + "-" + "20000000000" + System.currentTimeMillis();
//    	decodeStr = decodeStr.substring(decodeStr.indexOf(":")+1);
//    	String accountNo = decodeStr.substring(0, decodeStr.indexOf("-"));
//    	System.out.println(accountNo);
    	System.out.println(EncryptUtil.xorEncoder("T:" + "18999999991" + "|32|"));
	}
}
