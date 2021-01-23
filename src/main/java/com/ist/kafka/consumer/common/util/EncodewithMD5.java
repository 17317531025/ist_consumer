package com.ist.kafka.consumer.common.util;

import com.ist.kafka.consumer.common.CodeConstant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class EncodewithMD5 {
    
	/**
	 * 
	 * 方法名：encodeWithMD5
	 *
	 * 方法描述：将指定的字符串进行MD5加密
	 *
	 * @param String source
	 * @return String destString
	 */
    public static String encodeWithMD5(String s) {   
        StringBuffer hexString = new StringBuffer();   
        if (s != null && s.trim().length() != 0) {   
            try {   
                MessageDigest md = MessageDigest.getInstance("MD5");   
                md.update(s.getBytes());   
                byte[] hash = md.digest();   
                for (int i = 0; i < hash.length; i++) {   
                    if ((0xff & hash[i]) < 0x10) {   
                        hexString.append("0"  
                                + Integer.toHexString((0xFF & hash[i])));   
                    } else {   
                        hexString.append(Integer.toHexString(0xFF & hash[i]));   
                    }   
                }   
            } catch (NoSuchAlgorithmException e) {   
                e.printStackTrace();   
            }   
        }   
        return hexString.toString();   
    }  
    
    /**
	 * 
	 * 方法名：getRandomPWD
	 *
	 * 方法描述：得到指定长度的密码
	 *
	 * @param int length
	 * @return String destString
	 */
    public static  String getRandomPWD(int length) {  
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < length; i++) {  
            int number = random.nextInt(base.length());  
            sb.append(base.charAt(number));  
        }  
        
        return sb.toString();  
    }  
    
    /**
	 * 
	 * 方法名：getPhoneRegisterRandomPWD
	 *
	 * 方法描述：得到指定长度的手机验证码
	 *
	 * @param int length
	 * @return String destString
	 */
    public static  String getPhoneRegisterRandomPWD(int length) {  
        String base = "0123456789";
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < length; i++) {  
            int number = random.nextInt(base.length());  
            sb.append(base.charAt(number));  
        }  
        
        return sb.toString();  
    }  
    
    /**
	 * 
	 * 方法名：encodePWDWithMD5
	 *
	 * 方法描述：将密码进行加密
	 *
	 * @param String sourceCode
	 * @return String destCode
	 */
    public static String encodePWDWithMD5(String sourceCode) {   
        byte[] sourceByte=sourceCode.getBytes();
		StringBuffer destString=new StringBuffer();
		for (int i = 0; i < sourceByte.length; i++) {
			destString.append((byte)(sourceByte[i] << CodeConstant.DISPLACEMENT_NUMBER));
		}
        return encodeWithMD5(destString.toString());   
    }
    
    /**
     * 方法名：toMD5
	 *
	 * 方法描述：进行加密（生成userToken时调用）
	 *  
     * @param paramString
     * @return
     */
    public static String toMD5(String paramString)
    {
      char[] arrayOfChar1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
      try
      {
        byte[] arrayOfByte1 = paramString.getBytes();
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(arrayOfByte1);
        byte[] arrayOfByte2 = localMessageDigest.digest();
        int i = arrayOfByte2.length;
        char[] arrayOfChar2 = new char[i * 2];
        int j = 0;
        for (int k = 0; k < i; ++k)
        {
          int l = arrayOfByte2[k];
          arrayOfChar2[(j++)] = arrayOfChar1[(l >>> 4 & 0xF)];
          arrayOfChar2[(j++)] = arrayOfChar1[(l & 0xF)];
        }
        return new String(arrayOfChar2);
      }
      catch (Exception localException)
      {
      }
      return null;
    }
    
    public static void main(String[] args){
    	System.out.println(EncodewithMD5.encodeWithMD5("123456"));
    }
}