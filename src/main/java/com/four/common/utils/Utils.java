/*  1:   */ package com.four.common.utils;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.FileInputStream;
/*  5:   */ import java.io.InputStream;
/*  6:   */ import java.util.Collection;
/*  7:   */ import java.util.Properties;
/*  8:   */ 
/*  9:   */ public class Utils
/* 10:   */ {
/* 11:   */   public static boolean isEmpty(String str)
/* 12:   */   {
/* 13:19 */     return (str == null) || (str.length() == 0);
/* 14:   */   }
/* 15:   */   
/* 16:   */   public static boolean isBlank(String str)
/* 17:   */   {
/* 18:   */     int strLen;
/* 19:28 */     if ((str == null) || ((strLen = str.length()) == 0)) {
/* 20:29 */       return true;
/* 21:   */     }
/* 22:   */     //int strLen;
/* 23:31 */     for (int i = 0; i < strLen; i++) {
/* 24:32 */       if (!Character.isWhitespace(str.charAt(i))) {
/* 25:33 */         return false;
/* 26:   */       }
/* 27:   */     }
/* 28:36 */     return true;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public static boolean isEmpty(Collection list)
/* 32:   */   {
/* 33:44 */     return (list == null) || (list.size() == 0);
/* 34:   */   }
/* 35:   */   
/* 36:   */   public static Properties loadProperties(File file)
/* 37:   */   {
/* 38:53 */    Properties properties = new Properties();
/* 39:54 */     InputStream inputStream = null;
/* 40:   */     try
/* 41:   */     {
/* 42:56 */       inputStream = new FileInputStream(file);
/* 43:57 */       properties.load(inputStream);
/* 44:   */       
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:   */ 
/* 49:   */ 
/* 50:   */ 
/* 51:   */ 
/* 52:   */ 
/* 53:   */ 
/* 54:68 */       return properties;
/* 55:   */     }
/* 56:   */     catch (Exception e)
/* 57:   */     {
/* 58:59 */       return null;
/* 59:   */     }
/* 60:   */     finally
/* 61:   */     {
/* 62:61 */       if (inputStream != null) {
/* 63:   */         try
/* 64:   */         {
/* 65:63 */           inputStream.close();
/* 66:   */         }
/* 67:   */         catch (Exception localException3) {}
/* 68:   */       }
/* 69:   */     }
/* 70:   */   }
/* 71:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.utils.Utils
 * JD-Core Version:    0.7.0.1
 */