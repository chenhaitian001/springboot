/*  1:   */ package com.four.server.main;
/*  2:   */ 
/*  3:   */ import com.four.common.utils.TheApp;
/*  4:   */ import org.slf4j.Logger;
/*  5:   */ import org.slf4j.LoggerFactory;
/*  6:   */ import org.springframework.context.support.ClassPathXmlApplicationContext;
/*  7:   */ 
/*  8:   */ public class ConvertDataMain
/*  9:   */ {
/* 10:   */   public static ClassPathXmlApplicationContext applicationContext;
/* 11:   */   
/* 12:   */   public static void main(String[] args)
/* 13:   */   {
/* 14:16 */     Logger logger = LoggerFactory.getLogger(ConvertDataMain.class);
/* 15:17 */     long beginTime = System.currentTimeMillis();
/* 16:   */     try
/* 17:   */     {
/* 18:19 */       TheApp.initialize();
/* 19:20 */       applicationContext = new ClassPathXmlApplicationContext(new String[] { "spring/application-config.xml", "spring/application-mybatis.xml", "spring/application-quartz.xml" });
/* 20:   */       
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */       logger.error("转换程序已启动.............");
/* 25:   */     }
/* 26:   */     catch (Exception e)
/* 27:   */     {
/* 28:34 */       e.printStackTrace();
/* 29:35 */       logger.error("转换程序启动失败：" + e.getMessage());
/* 30:36 */       System.exit(-1);
/* 31:   */     }
/* 32:   */   }
/* 33:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.main.ConvertDataMain
 * JD-Core Version:    0.7.0.1
 */