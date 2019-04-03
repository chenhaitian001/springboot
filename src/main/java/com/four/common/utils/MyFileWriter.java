/*  1:   */ package com.four.common.utils;
/*  2:   */ 
/*  3:   */ import java.io.BufferedWriter;
/*  4:   */ import java.io.File;
/*  5:   */ import java.io.FileOutputStream;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.io.OutputStreamWriter;
/*  8:   */ import java.util.ArrayList;
/*  9:   */ 
/* 10:   */ public class MyFileWriter
/* 11:   */ {
/* 12:10 */   private static String charSet = "utf-8";
/* 13:   */   private BufferedWriter bufferedWriter;
/* 14:   */   
/* 15:   */   public boolean initBufferedWriter(File file)
/* 16:   */   {
/* 17:15 */     OutputStreamWriter osw = null;
/* 18:   */     try
/* 19:   */     {
/* 20:17 */       osw = new OutputStreamWriter(new FileOutputStream(file), charSet);
/* 21:18 */       this.bufferedWriter = new BufferedWriter(osw);
/* 22:   */     }
/* 23:   */     catch (Exception e)
/* 24:   */     {
/* 25:20 */       e.printStackTrace();
/* 26:21 */       return false;
/* 27:   */     }
/* 28:23 */     return true;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void write(ArrayList<String> file_data)
/* 32:   */     throws IOException
/* 33:   */   {
/* 34:27 */     if ((file_data == null) || (file_data.size() == 0)) {
/* 35:28 */       return;
/* 36:   */     }
/* 37:30 */     for (String line : file_data)
/* 38:   */     {
/* 39:31 */       this.bufferedWriter.write(line);
/* 40:32 */       this.bufferedWriter.newLine();
/* 41:   */     }
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void close()
/* 45:   */   {
/* 46:37 */     if (this.bufferedWriter != null) {
/* 47:   */       try
/* 48:   */       {
/* 49:39 */         this.bufferedWriter.close();
/* 50:40 */         this.bufferedWriter = null;
/* 51:   */       }
/* 52:   */       catch (IOException e)
/* 53:   */       {
/* 54:42 */         e.printStackTrace();
/* 55:   */       }
/* 56:   */     }
/* 57:   */   }
/* 58:   */   
/* 59:   */   public static String getCharSet()
/* 60:   */   {
/* 61:48 */     return charSet;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public static void setCharSet(String charSet)
/* 65:   */   {
/* 66:52 */     charSet = charSet;
/* 67:   */   }
/* 68:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.utils.MyFileWriter
 * JD-Core Version:    0.7.0.1
 */