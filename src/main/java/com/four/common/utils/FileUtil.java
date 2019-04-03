/*   1:    */ package com.four.common.utils;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.BufferedWriter;
/*   5:    */ import java.io.File;
/*   6:    */ import java.io.FileInputStream;
/*   7:    */ import java.io.FileOutputStream;
/*   8:    */ import java.io.FileWriter;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.io.InputStreamReader;
/*  11:    */ import java.io.OutputStream;
/*  12:    */ import java.io.OutputStreamWriter;
/*  13:    */ import java.io.PrintStream;
/*  14:    */ import java.util.ArrayList;
/*  15:    */ import java.util.List;
/*  16:    */ import java.util.regex.Matcher;
/*  17:    */ import java.util.regex.Pattern;
/*  18:    */ 
/*  19:    */ public class FileUtil
/*  20:    */ {
/*  21: 13 */   private static String charSet = "utf-8";
/*  22:    */   
/*  23:    */   public static ArrayList<String> readFile(File file)
/*  24:    */     throws Exception
/*  25:    */   {
/*  26: 20 */     ArrayList<String> file_data = new ArrayList();
/*  27: 21 */     if (file.exists())
/*  28:    */     {
/*  29: 22 */       InputStreamReader isr = new InputStreamReader(new FileInputStream(file), charSet);
/*  30: 23 */       BufferedReader bfr = new BufferedReader(isr);
/*  31: 24 */       String line = bfr.readLine();
/*  32: 25 */       while (line != null)
/*  33:    */       {
/*  34: 26 */         file_data.add(line);
/*  35: 27 */         line = bfr.readLine();
/*  36:    */       }
/*  37: 29 */       bfr.close();
/*  38:    */     }
/*  39:    */     else
/*  40:    */     {
/*  41: 31 */       System.out.println(file.getAbsolutePath() + ":文件不存在！");
/*  42:    */     }
/*  43: 33 */     return file_data;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public static void writeFile(File file, ArrayList<String> file_data)
/*  47:    */     throws Exception
/*  48:    */   {
/*  49: 38 */     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
/*  50: 39 */     for (int i = 0; i < file_data.size(); i++)
/*  51:    */     {
/*  52: 40 */       String line = (String)file_data.get(i);
/*  53: 41 */       bfw.write(line);
/*  54: 42 */       bfw.newLine();
/*  55:    */     }
/*  56: 44 */     bfw.close();
/*  57:    */   }
/*  58:    */   
/*  59:    */   public static void writeFileAppend(File file, String content)
/*  60:    */   {
/*  61:    */     try
/*  62:    */     {
/*  63: 50 */       FileWriter writer = new FileWriter(file, true);
/*  64: 51 */       writer.write(content);
/*  65: 52 */       writer.close();
/*  66:    */     }
/*  67:    */     catch (IOException e)
/*  68:    */     {
/*  69: 54 */       e.printStackTrace();
/*  70:    */     }
/*  71:    */   }
/*  72:    */   
/*  73:    */   public static ArrayList<File> listFile(File path, String file_prefix, String file_suffix)
/*  74:    */   {
/*  75: 60 */     ArrayList<File> return_files = new ArrayList();
/*  76: 61 */     if (path.isFile())
/*  77:    */     {
/*  78: 62 */       if ((path.getName().startsWith(file_prefix)) && 
/*  79: 63 */         (path.getName().endsWith(file_suffix))) {
/*  80: 64 */         return_files.add(path);
/*  81:    */       }
/*  82: 66 */       return return_files;
/*  83:    */     }
/*  84: 67 */     if (path.isDirectory())
/*  85:    */     {
/*  86: 68 */       File[] files = path.listFiles();
/*  87: 69 */       if (files == null) {
/*  88: 70 */         return return_files;
/*  89:    */       }
/*  90: 72 */       for (int i = 0; i < files.length; i++)
/*  91:    */       {
/*  92: 73 */         ArrayList<File> files_list = listFile(files[i], file_prefix, file_suffix);
/*  93:    */         
/*  94: 75 */         return_files.addAll(files_list);
/*  95:    */       }
/*  96:    */     }
/*  97: 78 */     return return_files;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public ArrayList<File> listFileBak(File path, String file_name_startwith, String file_suffix)
/* 101:    */   {
/* 102: 84 */     ArrayList<File> return_files = new ArrayList();
/* 103: 85 */     File[] files = path.listFiles();
/* 104: 86 */     for (int i = 0; i < files.length; i++) {
/* 105: 87 */       if (files[i].isFile())
/* 106:    */       {
/* 107: 88 */         String file_name = files[i].getName();
/* 108: 89 */         if ((file_name.startsWith(file_name_startwith)) && 
/* 109: 90 */           (file_name.endsWith(file_suffix))) {
/* 110: 91 */           return_files.add(files[i]);
/* 111:    */         }
/* 112:    */       }
/* 113: 93 */       else if (files[i].isDirectory())
/* 114:    */       {
/* 115: 94 */         File[] child_files = files[i].listFiles();
/* 116: 95 */         for (int j = 0; j < child_files.length; j++)
/* 117:    */         {
/* 118: 96 */           String file_name = child_files[j].getName();
/* 119: 97 */           if ((file_name.startsWith(file_name_startwith)) && 
/* 120: 98 */             (file_name.endsWith(file_suffix))) {
/* 121: 99 */             return_files.add(child_files[j]);
/* 122:    */           }
/* 123:    */         }
/* 124:    */       }
/* 125:    */     }
/* 126:104 */     return return_files;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public static boolean outputFile(byte[] output_data, File file)
/* 130:    */     throws Exception
/* 131:    */   {
/* 132:109 */     boolean return_value = false;
/* 133:110 */     if (output_data != null)
/* 134:    */     {
/* 135:111 */       OutputStream os = new FileOutputStream(file);
/* 136:112 */       os.write(output_data);
/* 137:113 */       os.close();
/* 138:114 */       return_value = true;
/* 139:    */     }
/* 140:116 */     return return_value;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public List<String> readKeysByFile(String filePath)
/* 144:    */   {
/* 145:    */     try
/* 146:    */     {
/* 147:121 */       List<String> list = new ArrayList();
/* 148:    */       
/* 149:123 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
/* 150:124 */       String line = null;
/* 151:125 */       Pattern pattern = Pattern.compile("[ ]+");
/* 152:126 */       while ((line = bufferedReader.readLine()) != null) {
/* 153:127 */         if (!pattern.matcher(line).matches()) {
/* 154:128 */           list.add(line.trim());
/* 155:    */         }
/* 156:    */       }
/* 157:132 */       return list;
/* 158:    */     }
/* 159:    */     catch (Exception e)
/* 160:    */     {
/* 161:134 */       e.printStackTrace();
/* 162:    */     }
/* 163:137 */     return null;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public static void setCharSet(String charSet)
/* 167:    */   {
/* 168:141 */     charSet = charSet;
/* 169:    */   }
/* 170:    */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */