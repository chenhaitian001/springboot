/*  1:   */ package com.four.server.bsm.impl;
/*  2:   */ 
/*  3:   */ import com.four.common.tpm.KeyValueTpm;
/*  4:   */ import com.four.common.tpm.SyncConfig;
/*  5:   */ import com.four.server.bsm.SystemBsm;
/*  6:   */ import com.four.server.dsm.SystemDsm;
/*  7:   */ import java.text.ParseException;
/*  8:   */ import java.text.SimpleDateFormat;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.Date;
/* 11:   */ import java.util.List;

import javax.annotation.Resource;

/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.context.annotation.Scope;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Scope("singleton")
/* 17:   */ @Repository("systemBsm")
/* 18:   */ public class SystemBsmImpl
/* 19:   */   implements SystemBsm
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private SystemDsm systemDsm;
/* 23:26 */   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/* 24:   */   
/* 25:   */   public int saveSynSystemTime(String key, Date date)
/* 26:   */   {
/* 27:30 */     String dateStr = this.sdf.format(date);
/* 28:31 */     List<KeyValueTpm> keyValueTpms = new ArrayList();
/* 29:32 */     KeyValueTpm keyValueTpm = new KeyValueTpm(key, dateStr);
/* 30:33 */     keyValueTpms.add(keyValueTpm);
/* 31:34 */     Integer count = Integer.valueOf(this.systemDsm.saveSystemConfig(keyValueTpms, null));
/* 32:35 */     return count.intValue();
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Date getSynSystemTime(String key)
/* 36:   */   {
/* 37:40 */     KeyValueTpm keyValueTpm = this.systemDsm.getSystemConfig(key);
/* 38:41 */     Date date = null;
/* 39:42 */     if (keyValueTpm != null)
/* 40:   */     {
/* 41:43 */       String value = keyValueTpm.getValue();
/* 42:   */       try
/* 43:   */       {
/* 44:45 */         date = this.sdf.parse(value);
/* 45:   */       }
/* 46:   */       catch (ParseException e)
/* 47:   */       {
/* 48:47 */         e.printStackTrace();
/* 49:   */       }
/* 50:   */     }
/* 51:51 */     return date;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public Boolean getSynCardSetup()
/* 55:   */   {
/* 56:56 */     Boolean flag = Boolean.valueOf(false);
/* 57:   */     try
/* 58:   */     {
/* 59:58 */       KeyValueTpm keyValueTpm = this.systemDsm.getSystemConfig(SyncConfig.SynCardSetup.getValue());
/* 60:59 */       if (keyValueTpm == null) {
/* 61:60 */         return Boolean.valueOf(false);
/* 62:   */       }
/* 63:62 */       String value = keyValueTpm.getValue();
/* 64:   */       
/* 65:64 */       flag = Boolean.valueOf(value.equals("1"));
/* 66:65 */       if (flag.booleanValue()) {
/* 67:66 */         keyValueTpm.setValue("0");
/* 68:   */       }
/* 69:68 */       List<KeyValueTpm> keyValueTpms = new ArrayList();
/* 70:69 */       keyValueTpms.add(keyValueTpm);
/* 71:70 */       this.systemDsm.saveSystemConfig(keyValueTpms, null);
/* 72:   */     }
/* 73:   */     catch (Exception e)
/* 74:   */     {
/* 75:72 */       e.printStackTrace();
/* 76:73 */       flag = Boolean.valueOf(false);
/* 77:   */     }
/* 78:76 */     return flag;
/* 79:   */   }
/* 80:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.bsm.impl.SystemBsmImpl
 * JD-Core Version:    0.7.0.1
 */