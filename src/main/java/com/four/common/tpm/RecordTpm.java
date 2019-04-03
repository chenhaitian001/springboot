/*   1:    */ package com.four.common.tpm;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.sql.Timestamp;
/*   5:    */ 
/*   6:    */ public class RecordTpm
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   protected Long devId;
/*  10:    */   protected Long userId;
/*  11:    */   protected Timestamp timestamp;
/*  12: 13 */   protected Boolean isNative = Boolean.valueOf(true);
/*  13:    */   protected String photoPath;
/*  14:    */   protected Timestamp create;
/*  15:    */   protected Long creatorId;
/*  16:    */   protected Timestamp modifyTime;
/*  17:    */   protected Long modifierId;
/*  18:    */   protected String verify;
/*  19: 22 */   protected Integer validate = Integer.valueOf(1);
/*  20:    */   
/*  21:    */   public Long getDevId()
/*  22:    */   {
/*  23: 25 */     return this.devId;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public void setDevId(Long devId)
/*  27:    */   {
/*  28: 29 */     this.devId = devId;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public Long getUserId()
/*  32:    */   {
/*  33: 33 */     return this.userId;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setUserId(Long userId)
/*  37:    */   {
/*  38: 37 */     this.userId = userId;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public Timestamp getTimestamp()
/*  42:    */   {
/*  43: 41 */     return this.timestamp;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setTimestamp(Timestamp timestamp)
/*  47:    */   {
/*  48: 45 */     this.timestamp = timestamp;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Boolean getIsNative()
/*  52:    */   {
/*  53: 49 */     return this.isNative;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setIsNative(Boolean isNative)
/*  57:    */   {
/*  58: 53 */     this.isNative = isNative;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getPhotoPath()
/*  62:    */   {
/*  63: 57 */     return this.photoPath;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setPhotoPath(String photoPath)
/*  67:    */   {
/*  68: 61 */     this.photoPath = photoPath;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public Timestamp getCreate()
/*  72:    */   {
/*  73: 65 */     return this.create;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setCreate(Timestamp create)
/*  77:    */   {
/*  78: 69 */     this.create = create;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public Long getCreatorId()
/*  82:    */   {
/*  83: 73 */     return this.creatorId;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setCreatorId(Long creatorId)
/*  87:    */   {
/*  88: 77 */     this.creatorId = creatorId;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public Timestamp getModifyTime()
/*  92:    */   {
/*  93: 81 */     return this.modifyTime;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setModifyTime(Timestamp modifyTime)
/*  97:    */   {
/*  98: 85 */     this.modifyTime = modifyTime;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public Long getModifierId()
/* 102:    */   {
/* 103: 89 */     return this.modifierId;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setModifierId(Long modifierId)
/* 107:    */   {
/* 108: 93 */     this.modifierId = modifierId;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String getVerify()
/* 112:    */   {
/* 113: 97 */     return this.verify;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setVerify(String verify)
/* 117:    */   {
/* 118:101 */     this.verify = verify;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public Integer getValidate()
/* 122:    */   {
/* 123:105 */     return this.validate;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setValidate(Integer validate)
/* 127:    */   {
/* 128:109 */     this.validate = validate;
/* 129:    */   }
/* 130:    */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.tpm.RecordTpm
 * JD-Core Version:    0.7.0.1
 */