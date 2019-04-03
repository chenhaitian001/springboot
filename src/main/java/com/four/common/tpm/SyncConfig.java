/*  1:   */ package com.four.common.tpm;
/*  2:   */ 
/*  3:   */ public enum SyncConfig
/*  4:   */ {
/*  5: 4 */   SynCardSetup("syn_guard_card_setup", "启动时是否同步门禁卡点"),  SynCardTime("syn_guard_card_time", "同步门禁卡点时开始时间");
/*  6:   */   
/*  7:   */   private String value;
/*  8:   */   private String describe;
/*  9:   */   
/* 10:   */   private SyncConfig(String value, String describe)
/* 11:   */   {
/* 12:11 */     this.value = value;
/* 13:12 */     this.describe = describe;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getValue()
/* 17:   */   {
/* 18:16 */     return this.value;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getDescribe()
/* 22:   */   {
/* 23:20 */     return this.describe;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String toString()
/* 27:   */   {
/* 28:25 */     return this.describe;
/* 29:   */   }
/* 30:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.tpm.SyncConfig
 * JD-Core Version:    0.7.0.1
 */