/*  1:   */ package com.four.common.tpm;
/*  2:   */ 
/*  3:   */ import java.sql.Timestamp;
/*  4:   */ import java.text.SimpleDateFormat;
/*  5:   */ 
/*  6:   */ public class SyncRecordTpm
/*  7:   */ {
/*  8:   */   protected Long recID;
/*  9:   */   protected Timestamp readDate;
/* 10:   */   protected String consumerID;
/* 11:   */   protected Timestamp modifiedDate;
/* 12:   */   protected String certificateID;
/* 13:16 */   private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 14:   */   
/* 15:   */   public Long getRecID()
/* 16:   */   {
/* 17:19 */     return this.recID;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setRecID(Long recID)
/* 21:   */   {
/* 22:23 */     this.recID = recID;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getConsumerID()
/* 26:   */   {
/* 27:27 */     return this.consumerID;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setConsumerID(String consumerID)
/* 31:   */   {
/* 32:31 */     this.consumerID = consumerID;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getCertificateID()
/* 36:   */   {
/* 37:35 */     return this.certificateID;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setCertificateID(String certificateID)
/* 41:   */   {
/* 42:39 */     this.certificateID = certificateID;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Timestamp getReadDate()
/* 46:   */   {
/* 47:43 */     return this.readDate;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setReadDate(Timestamp readDate)
/* 51:   */   {
/* 52:47 */     this.readDate = readDate;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Timestamp getModifiedDate()
/* 56:   */   {
/* 57:51 */     return this.modifiedDate;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setModifiedDate(Timestamp modifiedDate)
/* 61:   */   {
/* 62:55 */     this.modifiedDate = modifiedDate;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public String toString()
/* 66:   */   {
/* 67:60 */     return 
/* 68:   */     
/* 69:   */ 
/* 70:   */ 
/* 71:64 */       "SyncRecordTpm{recID=" + this.recID + ", readDate=" + dateTimeFormat.format(this.readDate) + ", consumerID='" + this.consumerID + '\'' + ", modifiedDate=" + dateTimeFormat.format(this.modifiedDate) + ", certificateID='" + this.certificateID + '\'' + '}';
/* 72:   */   }
/* 73:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.tpm.SyncRecordTpm
 * JD-Core Version:    0.7.0.1
 */