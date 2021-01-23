package com.ist.kafka.consumer.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	
	/**
	 * 
	 * 方法名：matchingText
	 *
	 * 方法描述：验证正则表达式和字符串是否匹配,正确匹配返回true,否则返回false.
	 *
	 * @param expression
	 * @param phoneNumber
	 * @return
	 */
	private static boolean matchingText(String expression, String phoneNumber) {
		Pattern p = Pattern.compile(expression); // 正则表达式
		Matcher m = p.matcher(phoneNumber); // 操作的字符串
		boolean b = m.matches();
		return b;
	}

	/**
	 * 
	 * 方法名：validateMoblie
	 *
	 * 方法描述：验证手机号是否正确,正确返回true,否则返回false.
	 *
	 * @param phoneNumber
	 * @return
	 */
	public static boolean validateMoblie(String phoneNumber) {
		if(!StringUtils.isNumeric(phoneNumber)){
			return false;
		}
		boolean rs=false;
		if(phoneNumber == null)
		{
			return rs;
		}
		if (matchingText("^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9]|19[0-9])\\d{8}$", phoneNumber)) {
			rs= true;
		}
		return rs;
	}
	
	/**
	 * 方法名：validateMoblie
	 * 方法描述：验证手机号是否正确,正确返回true,否则返回false.
	 * @param
	 * @return
	 */
	public static boolean validateCtcMoblie(String phone) {
		if(!StringUtils.isNumeric(phone)){
			return false;
		}
		boolean rs=false;
		if (matchingText("^(133|149|153|170[0-2]|173|174|177|180|181|189|191|199|1349)\\d{4,8}$", phone)) {
			rs= true;
		}
		return rs;
	}
	
	/**
	 * 方法名：validateMoblie
	 * 方法描述：验证手机号是否正确,正确返回true,否则返回false.
	 * @return
	 */
	public static boolean validateCmMoblie(String phone) {
		if(!StringUtils.isNumeric(phone)){
			return false;
		}
		boolean rs=false;
		if (matchingText("^(134[0-8]|13[5-9]|147|15[0-2]|15[7-9]|165|1703|1705|1706|172|178|18[2-4]|18[7-8]|198)\\d{4,8}$", phone)) {
			rs= true;
		}
		return rs;
	}
	
	/**
	 * 方法名：validateMoblie
	 * 方法描述：验证手机号是否正确,正确返回true,否则返回false.
	 * @return
	 */
	public static boolean validateCuMoblie(String phone) {
		if(!StringUtils.isNumeric(phone)){
			return false;
		}
		boolean rs=false;
		if (matchingText("^(13[0-2]|145|146|15[5-6]|166|167|1704|170[7-9]|171|175|176|18[5-6])\\d{4,8}$", phone)) {
			rs= true;
		}
		return rs;
	}
	
	/**
	 * 
	 * 方法名：validateEmail
	 *
	 * 方法描述：验证邮箱地址是否正确,正确返回true,否则返回false.
	 *
	 * @param eMail
	 * @return
	 */
	public static boolean validateEmail(String eMail){
		boolean rs=false;
		if (matchingText("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*", eMail)) {
			rs= true;
		}
		return rs;
	}

	/**
	 * 
	 * 方法名：validateBroadband
	 *
	 * 方法描述：验证宽带号格式（只包含数字和字母）是否正确,正确返回true,否则返回false.
	 *
	 * @return
	 */
	public static boolean validateBroadband(String str){
		boolean rs=false;
		if (matchingText("^ad[0-9]+$", str)) {
			rs= true;
		}
		return rs;
	}
	

	/**
	 * 
	 * 方法名：validateImsi
	 *
	 * 方法描述：验证手机号是否正确,正确返回true,否则返回false.
	 *
	 * @param imsi
	 * @return
	 */
	public static boolean validateImsi(String imsi) {
		boolean rs=false;
		if(imsi == null)
		{
			return rs;
		}
		if (matchingText("^460\\d{12}$", imsi)) {
			rs= true;
		}
		return rs;
	}
	
	public static boolean validatePassword(String password) {
		boolean rs=false;
		if(password == null)
		{
			return rs;
		}
		if (matchingText("(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^[^\\s%,<>]{6,16}$", password)) {
			rs= true;
		}
		return rs;
	}
	/**
	 * 方法名：main
	 *
	 * 方法描述：
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ValidateUtil.validateCuMoblie("17040000006"));
	}

}
