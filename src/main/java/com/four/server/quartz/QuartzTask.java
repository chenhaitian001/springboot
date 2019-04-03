 package com.four.server.quartz;
 
 import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.service.IStudentService;
import com.four.server.entity.Data;
import com.four.server.entity.ResponseJson;
import com.four.util.ConfigMapUtil;
import com.google.gson.Gson;
import com.http.HttpClient;

 
 @Service("quartzTask")
 public class QuartzTask
 {
	private static Logger logger = LoggerFactory.getLogger(QuartzTask.class);
   @Resource
   private IStudentService iStudentService;
// 静态初使化当前类
   
   /*static
   {
     if (logger == null) {
       logger = LoggerFactory.getLogger(QuartzTask.class);
     }
   }*/
   
   public void convertDataTask()
   {
     logger.info("Q---------增量同步门禁卡点:" + new Timestamp(System.currentTimeMillis()));
     try
     {	 String url =ConfigMapUtil.getValueByKey("down.url");
    	 //String url = "http://103.48.232.146:50080/backend/Record/recordlist";
    	 //当前时间
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 String nowDate = df.format(new Date());
		 //当前时间前2个小时（当前时间2小时前）
		 Calendar calendar = Calendar.getInstance(); 
		 calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 2); 
		 SimpleDateFormat dftwo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 String newTwo = dftwo.format(calendar.getTime()); 
		 String data1 = newTwo;//两个小时前
	     String data2 = nowDate;//当前时间		
	     String configStart =ConfigMapUtil.getValueByKey("startTime");
	     String configEnd =ConfigMapUtil.getValueByKey("endTime");
	     if(!configStart.isEmpty()&&!configEnd.isEmpty()){
	    	  data1 = configStart;//两个小时前
		      data2 = configEnd;//当前时间	
	     }
	     
		 //String data1 = "2018-12-4 00:00:00";
	     //String data2 = "2018-12-4 12:00:00";			 
    	 String response = HttpClient.post1(url, data1,data2) ;
    	 logger.info("获取数据"+response);
    	 Gson g=new Gson();
    	 ResponseJson bean=g.fromJson(response, ResponseJson.class);
    	 int res =bean.getRes();
    	 //判断请求是否成功
    	 if(res==0){
    	 }else{
    		 logger.info("获取数据失败"+bean.getMessage());
    		 return;
    	 }
    	 String total = bean.getTotal();
    	 logger.info("获取数据条数"+total);
    	 List<Data> dataList = bean.getData();
    	 for(Data data :dataList){
    		 int dev_direction = data.getDev_direction();
    		 String img = data.getImg();
    		 String tel_number = data.getTel_number();
    		 String visitor_name = data.getVisitor_name();
    		 String visitor_uid = data.getVisitor_uid();
    		 String access_time = data.getAccess_time();
    		 String userSql = "select ng_id from sys_user where ng_id = "+visitor_uid+"";
    		 String ng_user_id = iStudentService.findUser(userSql);
    		 if(ng_user_id.isEmpty()){
    			 logger.info("获取人员工号失败"+visitor_uid);
    			 continue;
    		 }
    		 
    		//文件名
    		 String filename = img.substring(img.lastIndexOf('/')+1);
    		 SimpleDateFormat dff = new SimpleDateFormat("yyyyMMdd");//设置日期格式
    		 String dataWork = dff.format(new Date());
    		 String downFile = "F:/iFaceTime/Tomcat-Eq/webapps/ROOT/records/"+dataWork;
    		 //按日期下载文件
    		 FileDown.download(img, filename, downFile);
    		 
    		//数据库保存的路径
    	     String savePath  = "records"+"/"+dataWork+"/"+filename;
    		 
    		 String sql3= " INSERT INTO stat_card(ng_user_id, ng_dev_id, "
    				 + "	ts_card, bt_native ,sz_photo_path,"
    				 + "    ts_create)  ("
    				 + "SELECT '"+ng_user_id+"','1000',"
    				 + "'"+access_time+"','1','"+savePath+"',"
    				 + "'"+nowDate+"'"
    				 + " FROM DUAL WHERE NOT EXISTS"
    				 + "  (SELECT 1 FROM stat_card WHERE ng_user_id = '"+ng_user_id+"' AND ts_card = '"+access_time+"')"
					+ ")";
    		 
    		 iStudentService.test(sql3);
    	 }
     }
     catch (Exception e)
     {
       e.printStackTrace();
       logger.error("增量同步门禁卡点失败：" + e.getLocalizedMessage());
     }
   }
 }

