/*  1:   */ package com.four.common.tpm;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class UserTpm
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   protected Long id;
/* 10:   */   protected String employId;
/* 11:   */   protected String name;
/* 12:   */   protected String userName;
/* 13:   */   protected String cardId;
/* 14:   */   protected Integer state;
/* 15:   */   protected Date entryDate;
/* 16:   */   
/* 17:   */   public Long getId()
/* 18:   */   {
/* 19:20 */     return this.id;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void setId(Long id)
/* 23:   */   {
/* 24:24 */     this.id = id;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getEmployId()
/* 28:   */   {
/* 29:28 */     return this.employId;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setEmployId(String employId)
/* 33:   */   {
/* 34:32 */     this.employId = employId;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getName()
/* 38:   */   {
/* 39:36 */     return this.name;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setName(String name)
/* 43:   */   {
/* 44:40 */     this.name = name;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getUserName()
/* 48:   */   {
/* 49:44 */     return this.userName;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setUserName(String userName)
/* 53:   */   {
/* 54:48 */     this.userName = userName;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getCardId()
/* 58:   */   {
/* 59:52 */     return this.cardId;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setCardId(String cardId)
/* 63:   */   {
/* 64:56 */     this.cardId = cardId;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public Integer getState()
/* 68:   */   {
/* 69:60 */     return this.state;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setState(Integer state)
/* 73:   */   {
/* 74:64 */     this.state = state;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public Date getEntryDate()
/* 78:   */   {
/* 79:68 */     return this.entryDate;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setEntryDate(Date entryDate)
/* 83:   */   {
/* 84:72 */     this.entryDate = entryDate;
/* 85:   */   }
/* 86:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.tpm.UserTpm
 * JD-Core Version:    0.7.0.1
 */