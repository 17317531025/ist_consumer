package com.ist.kafka.consumer.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientUtil {
	private static final Logger logger = LoggerFactory.getLogger("allLogger");

	public static String charset = "UTF-8";
	public static final String SunX509 = "SunX509";
	public static final String JKS = "JKS";
	public static final String PKCS12 = "PKCS12";
	public static final String TLS = "TLS";
	
	public static String doGet(String url) throws UnsupportedEncodingException {
		return doGet(url,null);
	}
	
	public static String doGet(String url, Map<String, String> params) throws UnsupportedEncodingException {
		if(params != null) {
			int i = 1;
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					if( i == 1){
						url +="?"+s+"="+params.get(s);
					}else{
						url +="&"+s+"="+params.get(s);
					}
					i++;
				}
			}
		}
		HttpMethod method = new GetMethod(url);
		logger.info("GetURL:"+url);
		return send(method, null);
	}
	
	public static String genGetUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {
		if(params != null) {
			int i = 1;
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					if( i == 1){
						url +="?"+s+"="+params.get(s);
					}else{
						url +="&"+s+"="+params.get(s);
					}
					i++;
				}
			}
		}
		return url;
	}
	public static String doGet(String url, String remoteIp, Map<String, String> params) throws UnsupportedEncodingException {
		if(params != null) {
			int i = 1;
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					if( i == 1){
						url +="?"+s+"="+params.get(s);
					}else{
						url +="&"+s+"="+params.get(s);
					}
					i++;
				}
			}
		}
		HttpMethod method = new GetMethod(url);
		logger.info("GetURL:"+url);
		return send(method, null,remoteIp);
	}
	
	public static String doGet(String url, Map<String, String> params, String contentCharset) throws UnsupportedEncodingException {
		if(params != null) {
			int i = 1;
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					if( i == 1){
						url +="?"+s+"="+params.get(s);
					}else{
						url +="&"+s+"="+params.get(s);
					}
					i++;
				}
			}
		}
		HttpMethod method = new GetMethod(url);
		return send(method, contentCharset);
	}
	
//	public static String doPost(String url, Map<String, Object> params) throws UnsupportedEncodingException {
//		return doPost(url,null);
//	}
	
	public static String doPost(String url, Map<String, String> params) throws UnsupportedEncodingException {
		PostMethod method = new PostMethod(url);
		if(params != null) {
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					method.addParameter(s, value);
				}
			}
		}
		return send(method, null);
	}

	public static String doPost(String url, String message,String receiverId) throws UnsupportedEncodingException {
		PostMethod method = new PostMethod(url);
		method.addParameter("message", message);
		method.addParameter("receiverId", receiverId);
//		if(params != null) {
//			for (String s : params.keySet()) {
//				String value = params.get(s);
//				if (s!=null && value!=null) {
//
//				}
//			}
//		}
		return send(method, null);
	}


	public static String doPost(String url, Map<String, String> params,int timeOut) throws UnsupportedEncodingException {
		PostMethod method = new PostMethod(url);
		if(params != null) {
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					method.addParameter(s, value);
				}
			}
		}
		return send(method, null,timeOut);
	}
	
	public static String doPost(String url, Map<String, String> params, String contentCharset) throws UnsupportedEncodingException {
		PostMethod method = new PostMethod(url);
		if(params != null) {
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					method.addParameter(s, value);
				}
			}
		}
		return send(method, contentCharset);
	}
	
	public static String doXmlPost(String urlStr, String xmlStr) {
		byte[] xmlData = xmlStr.getBytes();
		BufferedReader br = null;
		HttpURLConnection urlCon = null;
		try {
			// 获得URL链接
			URL url = new URL(urlStr);
			urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setUseCaches(false);
			urlCon.setRequestMethod("POST");  
			urlCon.setRequestProperty("Accept-Charset", charset);
			urlCon.setRequestProperty("Content-Type", "text/xml");
			urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));
			DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream()); 
			printout.write(xmlData);
			printout.flush();
			printout.close();
			 //读取响应  
            br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String lines;  
            StringBuffer sb = new StringBuffer("");  
            while ((lines = br.readLine()) != null) {  
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines + "\r\n");
            }
            return sb.toString();
		} catch (Exception e) {
			logger.error("HttpClientUtil.doXmlPost exception:", e);
		}
		finally
		{
			try{
				br.close();
			}
			catch(Exception e){}
		}
		return null;
	}
	
	private static String send(HttpMethod method, String contentCharset) {
		if(contentCharset == null || contentCharset.trim().equals("")){
			contentCharset = "UTF-8";
		}
		String rs = "";
        try{
            HttpClient client = new HttpClient();
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, contentCharset);//设置请求参数编码
            method.getParams().setParameter(HttpMethodParams.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
			method.setRequestHeader("content-type","application/json");
            client.executeMethod(method);
//            rs = method.getResponseBodyAsString();
            InputStream inputStream = method.getResponseBodyAsStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));  
            StringBuffer sb = new StringBuffer();  
            String str= "";  
            while((str = br.readLine()) != null){  
            	sb.append(str);
            }
            rs = sb.toString();
        }catch(Exception e){
            logger.error("HttpClientUtil.send exception:", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
	}
	
	private static String send(HttpMethod method, String contentCharset,String remoteIp) {
		if(contentCharset == null || contentCharset.trim().equals("")){
			contentCharset = "UTF-8";
		}
		String rs = "";
        try{
            HttpClient client = new HttpClient();
            method.setRequestHeader("X-FORWARDED-FOR", remoteIp);
            method.setRequestHeader("CLIENT-IP", remoteIp);
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, contentCharset);//设置请求参数编码
            method.getParams().setParameter(HttpMethodParams.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
            client.executeMethod(method);
//            rs = method.getResponseBodyAsString();
            InputStream inputStream = method.getResponseBodyAsStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));  
            StringBuffer sb = new StringBuffer();  
            String str= "";  
            while((str = br.readLine()) != null){  
            	sb.append(str);
            }
            rs = sb.toString();
        }catch(Exception e){
            logger.error("HttpClientUtil.send exception:", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
	}
	
	private static String send(HttpMethod method, String contentCharset,int timeOut) {
		if(contentCharset == null || contentCharset.trim().equals("")){
			contentCharset = "UTF-8";
		}
		String rs = "";
        try{
            HttpClient client = new HttpClient();  
            client.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
            client.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, contentCharset);//设置请求参数编码
            method.getParams().setParameter(HttpMethodParams.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
            client.executeMethod(method);
            InputStream inputStream = method.getResponseBodyAsStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));  
            StringBuffer sb = new StringBuffer();  
            String str= "";  
            while((str = br.readLine()) != null){  
            	sb.append(str);
            }
            rs = sb.toString();
        }catch(Exception e){
            logger.error("HttpClientUtil.send exception:", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
	}

	/**
	 * get HttpURLConnection
	 * @param strUrl url地址
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	public static HttpURLConnection getHttpURLConnection(String strUrl)
			throws IOException {
		URL url = new URL(strUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		return httpURLConnection;
	}
	
	/**
	 * get HttpsURLConnection
	 * @param strUrl url地址
	 * @return HttpsURLConnection
	 * @throws IOException
	 */
	public static HttpsURLConnection getHttpsURLConnection(String strUrl)
			throws IOException {
		URL url = new URL(strUrl);
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url
				.openConnection();
		return httpsURLConnection;
	}
	
	/**
	 * 获取不带查询串的url
	 * @param strUrl
	 * @return String
	 */
	public static String getURL(String strUrl) {

		if(null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if(-1 != indexOf) {
				return strUrl.substring(0, indexOf);
			} 
			
			return strUrl;
		}
		
		return strUrl;
		
	}
	
	/**
	 * 获取查询串
	 * @param strUrl
	 * @return String
	 */
	public static String getQueryString(String strUrl) {
		
		if(null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if(-1 != indexOf) {
				return strUrl.substring(indexOf+1, strUrl.length());
			} 
			
			return "";
		}
		
		return strUrl;
	}
	
	/**
	 * 查询字符串转换成Map<br/>
	 * name1=key1&name2=key2&...
	 * @param queryString
	 * @return
	 */
	public static Map<String, String> queryString2Map(String queryString) {
		if(null == queryString || "".equals(queryString)) {
			return null;
		}
		
		Map<String, String> m = new HashMap<String, String>();
		String[] strArray = queryString.split("&");
		for(int index = 0; index < strArray.length; index++) {
			String pair = strArray[index];
			HttpClientUtil.putMapByPair(pair, m);
		}
		
		return m;
		
	}
	
	/**
	 * 把键值添加至Map<br/>
	 * pair:name=value
	 * @param pair name=value
	 * @param m
	 */
	public static void putMapByPair(String pair, Map<String, String> m) {
		
		if(null == pair || "".equals(pair)) {
			return;
		}
		
		int indexOf = pair.indexOf("=");
		if(-1 != indexOf) {
			String k = pair.substring(0, indexOf);
			String v = pair.substring(indexOf+1, pair.length());
			if(null != k && !"".equals(k)) {
				m.put(k, v);
			}
		} else {
			m.put(pair, "");
		}
	}
	
	/**
	 * BufferedReader转换成String<br/>
	 * 注意:流关闭需要自行处理
	 * @param reader
	 * @return String
	 * @throws IOException
	 */
	public static String bufferedReader2String(BufferedReader reader) throws IOException {
		StringBuffer buf = new StringBuffer();
		String line = null;
		while( (line = reader.readLine()) != null) {
			buf.append(line);
			buf.append("\r\n");
		}
				
		return buf.toString();
	}
	
	/**
	 * 处理输出<br/>
	 * 注意:流关闭需要自行处理
	 * @param out
	 * @param data
	 * @param len
	 * @throws IOException
	 */
	public static void doOutput(OutputStream out, byte[] data, int len)
			throws IOException {
		int dataLen = data.length;
		int off = 0;
		while (off < data.length) {
			if (len >= dataLen) {
				out.write(data, off, dataLen);
				off += dataLen;
			} else {
				out.write(data, off, len);
				off += len;
				dataLen -= len;
			}

			// 刷新缓冲区
			out.flush();
		}

	}

	
	/**
	 * 获取CA证书信息
	 * @param cafile CA证书文件
	 * @return Certificate
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static Certificate getCertificate(File cafile)
			throws CertificateException, IOException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream(cafile);
		Certificate cert = cf.generateCertificate(in);
		in.close();
		return cert;
	}
	
	/**
	 * 字符串转换成char数组
	 * @param str
	 * @return char[]
	 */
	public static char[] str2CharArray(String str) {
		if(null == str) return null;
		
		return str.toCharArray();
	}
	
	/**
	 * 存储ca证书成JKS格式
	 * @param cert
	 * @param alias
	 * @param password
	 * @param out
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static void storeCACert(Certificate cert, String alias,
			String password, OutputStream out) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException {
		KeyStore ks = KeyStore.getInstance("JKS");

		ks.load(null, null);

		ks.setCertificateEntry(alias, cert);

		// store keystore
		ks.store(out, HttpClientUtil.str2CharArray(password));

	}
	
	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}
	
	/**
	 * InputStream转换成Byte
	 * 注意:流关闭需要自行处理
	 * @param in
	 * @return byte
	 * @throws Exception
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException{  
		
		int BUFFER_SIZE = 4096;  
		ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
        byte[] data = new byte[BUFFER_SIZE];  
        int count = -1;  
        
        while((count = in.read(data,0,BUFFER_SIZE)) != -1)  
            outStream.write(data, 0, count);  
          
        data = null;  
        byte[] outByte = outStream.toByteArray();
        outStream.close();
        
        return outByte;  
    } 
	
	/**
	 * InputStream转换成String
	 * 注意:流关闭需要自行处理
	 * @param in
	 * @param encoding 编码
	 * @return String
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in,String encoding) throws IOException{
        return new String(InputStreamTOByte(in),encoding);
    }

	private static final String APPLICATION_JSON = "application/json";
    
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";


	public static void main(String[] args) {
//		String result = null;
		try {
			// 设置默认工厂类
			System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
// 设置日志打印类
			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
//设置默认日志级别
			LogFactory.getFactory().setAttribute("org.apache.commons.logging.simplelog.defaultlog", "error");

			String message = "12";
			String receiverId = "2000000";
			Map<String, String> params = new HashMap<>();
			params.put("message",message);
			params.put("receiverId",receiverId);
			int count = 10000;
			long start = System.currentTimeMillis();
			long s = start;
			for (int i=0;i<count;i++){
				JsonObject result = HttpConnectionPoolUtil.post("http://ist3:8011/ist_im/" + "sendMessage/",params);
				//String result = HttpClientUtil.doPost("http://ist3:8011/ist_im/" + "sendMessage/", message,receiverId);
				if (i%1000==0){
					long e = System.currentTimeMillis();
					System.out.println("1000.cost:"+(e-s));
					s = e;
				}
				//logger.info("call crmOdmNotifyStatus resp===>"+result);
			}
			long end = System.currentTimeMillis();
			System.out.println("cost:" + (end-start));
			//result = HttpClientUtil.doGet("http://192.168.23.51:7021/bms_pc_adapter/verifyToken?uid=" + "13823366732" + "&tokenId=2kdtlmari9cgt32cpo68pj6dhm6spj4v1hfhu32cto0afv0f0i8fk58rf4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
