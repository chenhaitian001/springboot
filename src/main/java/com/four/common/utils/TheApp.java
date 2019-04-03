/*   1:    */ package com.four.common.utils;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.InputStream;
/*   6:    */ import java.io.InputStreamReader;
/*   7:    */ import java.util.Properties;
/*   8:    */ import org.slf4j.LoggerFactory;
/*   9:    */ 
/*  10:    */ public class TheApp
/*  11:    */ {
/*  12:    */   public static final int SQL_BATCH_SIZE = 200;
/*  13: 14 */   private static org.slf4j.Logger logger = LoggerFactory.getLogger(TheApp.class);
/*  14: 16 */   private static String vehicleFuelDirPath = "";
/*  15: 17 */   private static String mainRoadFilePath = "";
/*  16: 18 */   private static String fuelFileNameSuffix = ".csv";
/*  17: 19 */   private static Integer speedRange = Integer.valueOf(10);
/*  18: 20 */   private static String rootPath = "";
/*  19:    */   
/*  20:    */   public static void initialize()
/*  21:    */     throws IOException
/*  22:    */   {
/*  23: 23 */     InputStream is = TheApp.class.getClassLoader().getResourceAsStream("app.properties");
/*  24: 24 */     if (is == null) {
/*  25: 25 */       return;
/*  26:    */     }
/*  27: 27 */     InputStreamReader isr = new InputStreamReader(is, "utf-8");
/*  28: 28 */     Properties p = new Properties();
/*  29: 29 */     p.load(isr);
/*  30: 30 */     isr.close();
/*  31:    */     
/*  32: 32 */     vehicleFuelDirPath = getStringValue(p, "vehicle.fuel.dir.path", vehicleFuelDirPath);
/*  33: 33 */     mainRoadFilePath = getStringValue(p, "main.road.file.path", mainRoadFilePath);
/*  34: 34 */     fuelFileNameSuffix = getStringValue(p, "vehicle.fuel.file.name.suffix", fuelFileNameSuffix);
/*  35: 35 */     speedRange = Integer.valueOf(getUnsignedIntegerValue(p, "speed.range.size", speedRange.intValue()));
/*  36: 36 */     rootPath = getStringValue(p, "root.path", rootPath);
/*  37: 38 */     if (Utils.isEmpty(rootPath))
/*  38:    */     {
/*  39: 39 */       File file = new File("");
/*  40: 40 */       rootPath = file.getAbsolutePath();
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   private static String getStringValue(Properties properties, String key, String defaultValue)
/*  45:    */   {
/*  46: 45 */     String value = properties.getProperty(key);
/*  47: 46 */     if ((value != null) && (!value.equals(""))) {
/*  48: 47 */       return value;
/*  49:    */     }
/*  50: 49 */     return defaultValue;
/*  51:    */   }
/*  52:    */   
/*  53:    */   private static int getUnsignedIntegerValue(Properties properties, String key, int defaultValue)
/*  54:    */   {
/*  55: 52 */     String threshold = properties.getProperty(key);
/*  56: 53 */     if ((threshold != null) && (threshold.matches("\\d+")))
/*  57:    */     {
/*  58: 54 */       int th = Integer.parseInt(threshold);
/*  59: 55 */       if (th > 0) {
/*  60: 56 */         return th;
/*  61:    */       }
/*  62:    */     }
/*  63: 60 */     return defaultValue;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public static String getRootPath(String path)
/*  67:    */   {
/*  68: 67 */     StringBuilder rootPath = new StringBuilder(path);
/*  69: 68 */     rootPath.append(File.separator).append(path);
/*  70: 69 */     return rootPath.toString();
/*  71:    */   }
/*  72:    */   
/*  73:    */   public static String getVehicleFuelDirPath()
/*  74:    */   {
/*  75: 73 */     return vehicleFuelDirPath;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public static void setVehicleFuelDirPath(String vehicleFuelDirPath)
/*  79:    */   {
/*  80: 77 */     vehicleFuelDirPath = vehicleFuelDirPath;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public static String getMainRoadFilePath()
/*  84:    */   {
/*  85: 81 */     return mainRoadFilePath;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public static void setMainRoadFilePath(String mainRoadFilePath)
/*  89:    */   {
/*  90: 85 */     mainRoadFilePath = mainRoadFilePath;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public static String getFuelFileNameSuffix()
/*  94:    */   {
/*  95: 89 */     return fuelFileNameSuffix;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public static void setFuelFileNameSuffix(String fuelFileNameSuffix)
/*  99:    */   {
/* 100: 93 */     fuelFileNameSuffix = fuelFileNameSuffix;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public static Integer getSpeedRange()
/* 104:    */   {
/* 105: 97 */     return speedRange;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public static void setSpeedRange(Integer speedRange)
/* 109:    */   {
/* 110:101 */     speedRange = speedRange;
/* 111:    */   }
/* 112:    */   
/* 113:109 */   private static org.apache.log4j.Logger loggerServer = org.apache.log4j.Logger.getLogger("com.four.server");
/* 114:110 */   private static org.apache.log4j.Logger loggerCommon = org.apache.log4j.Logger.getLogger("com.four.commons");
/* 115:    */   
/* 116:    */   public static org.apache.log4j.Logger getLoggerServer()
/* 117:    */   {
/* 118:114 */     return loggerServer;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public static void setLoggerServer(org.apache.log4j.Logger loggerServer)
/* 122:    */   {
/* 123:118 */     loggerServer = loggerServer;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public static org.apache.log4j.Logger getLoggerCommon()
/* 127:    */   {
/* 128:122 */     return loggerCommon;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public static void setLoggerCommon(org.apache.log4j.Logger loggerCommon)
/* 132:    */   {
/* 133:126 */     loggerCommon = loggerCommon;
/* 134:    */   }
/* 135:    */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.utils.TheApp
 * JD-Core Version:    0.7.0.1
 */