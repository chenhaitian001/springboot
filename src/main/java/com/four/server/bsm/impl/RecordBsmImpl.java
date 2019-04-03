/*  1:   */ package com.four.server.bsm.impl;
/*  2:   */ 
/*  3:   */ import com.four.common.tpm.RecordTpm;
/*  4:   */ import com.four.common.tpm.UserTpm;
/*  5:   */ import com.four.server.bsm.RecordBsm;
/*  6:   */ import com.four.server.dsm.RecordDsm;
/*  7:   */ import java.util.ArrayList;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.context.annotation.Scope;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Scope("singleton")
/* 14:   */ @Repository("recordBsm")
/* 15:   */ public class RecordBsmImpl
/* 16:   */   implements RecordBsm
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   RecordDsm recordDsm;
/* 20:   */   
/* 21:   */   public boolean saveRecords(List<RecordTpm> records)
/* 22:   */   {
/* 23:32 */     if ((records == null) || (records.size() == 0)) {
/* 24:33 */       return true;
/* 25:   */     }
/* 26:35 */     int SQL_BATCH = 200;
/* 27:36 */     int SIZE = records.size();
/* 28:37 */     for (int i = 0; i < SIZE; i += 200)
/* 29:   */     {
/* 30:38 */       int fromIndex = i;
/* 31:39 */       int toIndex = fromIndex + 200;
/* 32:40 */       toIndex = toIndex > SIZE ? SIZE : toIndex;
/* 33:41 */       this.recordDsm.insertRecords(records.subList(fromIndex, toIndex));
/* 34:   */     }
/* 35:44 */     return true;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public UserTpm getUserByCardId(String cardId)
/* 39:   */   {
/* 40:49 */     return this.recordDsm.getUserByCardId(cardId);
/* 41:   */   }
/* 42:   */   
/* 43:   */   public List<UserTpm> getUserByCardIds(List<String> cardIds)
/* 44:   */   {
/* 45:54 */     if ((cardIds == null) || (cardIds.size() == 0)) {
/* 46:55 */       return null;
/* 47:   */     }
/* 48:58 */     List<UserTpm> userTpmList = new ArrayList();
/* 49:59 */     int step = 500;
/* 50:60 */     int size = cardIds.size();
/* 51:61 */     for (int i = 0; i < size; i += 500)
/* 52:   */     {
/* 53:62 */       int fromIndex = i;
/* 54:63 */       int toIndex = fromIndex + 500;
/* 55:64 */       toIndex = toIndex > size ? size : toIndex;
/* 56:65 */       List<UserTpm> sub = this.recordDsm.getUserByCardIds(cardIds.subList(fromIndex, toIndex));
/* 57:66 */       if (sub != null) {
/* 58:67 */         userTpmList.addAll(sub);
/* 59:   */       }
/* 60:   */     }
/* 61:71 */     return userTpmList;
/* 62:   */   }
/* 63:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.bsm.impl.RecordBsmImpl
 * JD-Core Version:    0.7.0.1
 */