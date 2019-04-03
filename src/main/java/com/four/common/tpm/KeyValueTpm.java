/*  1:   */ package com.four.common.tpm;
/*  2:   */ 
/*  3:   */ public class KeyValueTpm
/*  4:   */ {
/*  5:   */   protected String key;
/*  6:   */   protected String value;
/*  7:   */   protected String description;
/*  8:   */   
/*  9:   */   public KeyValueTpm() {}
/* 10:   */   
/* 11:   */   public KeyValueTpm(String key, String value)
/* 12:   */   {
/* 13:21 */     this.key = key;
/* 14:22 */     this.value = value;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public String getKey()
/* 18:   */   {
/* 19:26 */     return this.key;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void setKey(String key)
/* 23:   */   {
/* 24:30 */     this.key = key;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getValue()
/* 28:   */   {
/* 29:34 */     return this.value;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setValue(String value)
/* 33:   */   {
/* 34:38 */     this.value = value;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getDescription()
/* 38:   */   {
/* 39:42 */     return this.description;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setDescription(String description)
/* 43:   */   {
/* 44:46 */     this.description = description;
/* 45:   */   }
/* 46:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.tpm.KeyValueTpm
 * JD-Core Version:    0.7.0.1
 */