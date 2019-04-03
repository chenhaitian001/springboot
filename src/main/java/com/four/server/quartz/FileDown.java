package com.four.server.quartz;


import java.io.File;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.URL;  
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
 
 
public class FileDown {  
	private static Logger logger = LoggerFactory.getLogger(FileDown.class);
    /** 
     * @param args 
     * @throws Exception  
     */  
   /* public static void main(String[] args) throws Exception {  
        // TODO Auto-generated method stub  
    	String url = "http://ui.51bi.com/opt/siteimg/images/fanbei0923/Mid_07.jpg";
    	String filename = url.substring(url.lastIndexOf('/')+1);
    	String temp[] = url.replaceAll("\\\\","/").split("/"); 
    	
    		
    	
    	String url1 = temp[temp.length - 2]; 
		String url2 = temp[temp.length - 3];
    	System.out.println(url1+"/"+url2+"/"+filename);
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		 String nowDate = df.format(new Date());
    	
         download("http://ui.51bi.com/opt/siteimg/images/fanbei0923/Mid_07.jpg", "51bi.gif","F:/iFaceTime/Tomcat-Eq/webapps/ROOT/records/"+nowDate);  
    }  */
      
    public static void download(String urlString, String filename,String savePath) throws Exception {  
        try {
			// 构造URL  
			URL url = new URL(urlString);
			// 打开连接  
			URLConnection con = url.openConnection();
			//设置请求超时为5s  
			con.setConnectTimeout(5 * 1000);
			// 输入流  
			InputStream is = con.getInputStream();
			// 1K的数据缓冲  
			byte[] bs = new byte[1024];
			// 读取到的数据长度  
			int len;
			// 输出的文件流  
			File sf = new File(savePath);
			if (!sf.exists()) {
				sf.mkdirs();
			}
			OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
			// 开始读取  
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接  
			os.close();
			is.close();
		} catch (Exception e) {
			logger.info("图片下载失败，路径："+urlString);
		}  
    }   
  
}