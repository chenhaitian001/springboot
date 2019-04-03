/*  1:   */ package com.four.common.utils;
/*  2:   */ 
/*  3:   */ import java.io.BufferedReader;
/*  4:   */ import java.io.File;
/*  5:   */ import java.io.FileInputStream;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.io.InputStreamReader;
/*  8:   */ import java.io.PrintStream;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ 
/* 11:   */ public class MyFileReader
/* 12:   */ {
/* 13:10 */   private Integer maxLineCount = Integer.valueOf(10000);
/* 14:11 */   private String charSet = "utf-8";
/* 15:   */   private BufferedReader bufferedReader;
/* 16:   */   
/* 17:   */   public boolean initBufferedReader(File file)
/* 18:   */   {
/* 19:16 */     if (file.exists())
/* 20:   */     {
/* 21:17 */       InputStreamReader isr = null;
/* 22:   */       try
/* 23:   */       {
/* 24:19 */         isr = new InputStreamReader(new FileInputStream(file), this.charSet);
/* 25:   */       }
/* 26:   */       catch (Exception e)
/* 27:   */       {
/* 28:21 */         e.printStackTrace();
/* 29:22 */         return false;
/* 30:   */       }
/* 31:24 */       BufferedReader bfr = new BufferedReader(isr);
/* 32:25 */       this.bufferedReader = bfr;
/* 33:26 */       return true;
/* 34:   */     }
/* 35:28 */     System.out.println(file.getAbsolutePath() + ":文件不存在！");
/* 36:29 */     return false;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public ArrayList<String> next()
/* 40:   */     throws IOException
/* 41:   */   {
/* 42:34 */     ArrayList<String> file_data = new ArrayList();
/* 43:36 */     for (int i = 0; i < this.maxLineCount.intValue(); i++)
/* 44:   */     {
/* 45:37 */       String line = this.bufferedReader.readLine();
/* 46:38 */       if (line == null) {
/* 47:   */         break;
/* 48:   */       }
/* 49:39 */       file_data.add(line);
/* 50:   */     }
/* 51:46 */     return file_data;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void close()
/* 55:   */   {
/* 56:50 */     if (this.bufferedReader != null) {
/* 57:   */       try
/* 58:   */       {
/* 59:52 */         this.bufferedReader.close();
/* 60:53 */         this.bufferedReader = null;
/* 61:   */       }
/* 62:   */       catch (IOException e)
/* 63:   */       {
/* 64:55 */         e.printStackTrace();
/* 65:   */       }
/* 66:   */     }
/* 67:   */   }
/* 68:   */   
/* 69:   */   public Integer getMaxLineCount()
/* 70:   */   {
/* 71:61 */     return this.maxLineCount;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setMaxLineCount(Integer maxLineCount)
/* 75:   */   {
/* 76:65 */     this.maxLineCount = maxLineCount;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public String getCharSet()
/* 80:   */   {
/* 81:69 */     return this.charSet;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setCharSet(String charSet)
/* 85:   */   {
/* 86:73 */     this.charSet = charSet;
/* 87:   */   }
/* 88:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.utils.MyFileReader
 * JD-Core Version:    0.7.0.1
 */