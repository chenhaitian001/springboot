package com.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;




public class HttpClient {
	
	
	public static String post(String url, String data) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		String result = "";
		StringEntity entity = new StringEntity(data, "utf-8");// 
		entity.setContentEncoding("UTF-8");
		entity.setContentType("multipart/form-data");
		httppost.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httppost);
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			result = EntityUtils.toString(httpEntity, "UTF-8");
		}
		response.close();
		httpclient.close();
		return result;
	}
	public static String post1(String url,String data1,String data2) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);

		httppost.addHeader("Cookie","JSESSIONID=fnwebidwn==");

		//User-Agent

		httppost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		//创建 MultipartEntityBuilder,以此来构建我们的参数 
		MultipartEntityBuilder EntityBuilder = MultipartEntityBuilder.create();
		//设置字符编码，防止乱码
		ContentType contentType=ContentType.create("text/plain",Charset.forName("UTF-8"));
		//填充我们的文本内容，这里相当于input 框中的 name 与value
		EntityBuilder.addPart("start_time",new StringBody(data1,contentType));
		EntityBuilder.addPart("end_time", new StringBody(data2,contentType));
		//参数组装
		httppost.setEntity(EntityBuilder.build());
		
		HttpResponse response=httpclient.execute(httppost);
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			String result = EntityUtils.toString(httpEntity, "UTF-8");
			return result;
		}
		httpclient.close();
		return null;
		
		
}
	
	protected MultiValueMap<String, String> popHeaders(Object obj) {
	        
	        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

	        map.add("start_time","2018-12-4 00:00:00");
	        map.add("end_time","2018-12-5 10:00:00");
	        //.....
	        return map;
	}
}
