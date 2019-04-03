/*  1:   */ package com.four.server.bsm.impl;
/*  2:   */ 
/*  3:   */ import com.four.common.tpm.SyncRecordTpm;
/*  4:   */ import com.four.common.types.DbPager;
/*  5:   */ import com.four.server.bsm.SynInterfaceBsm;
/*  6:   */ import com.four.server.exdsm.SynInterfaceDsm;
/*  7:   */ import java.util.List;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.context.annotation.Scope;
/* 10:   */ import org.springframework.stereotype.Repository;
/* 11:   */ 
/* 12:   */ @Scope("singleton")
/* 13:   */ @Repository("synInterfaceBsm")
/* 14:   */ public class SynInterfaceBsmImpl
/* 15:   */   implements SynInterfaceBsm
/* 16:   */ {
/* 17:   */   @Autowired
/* 18:   */   private SynInterfaceDsm synInterfaceDsm;
/* 19:   */   
/* 20:   */   public List<SyncRecordTpm> querySyncRecord(SyncRecordTpm syncRecordQuery, DbPager pager)
/* 21:   */   {
/* 22:24 */     return this.synInterfaceDsm.querySyncRecord(syncRecordQuery, pager);
/* 23:   */   }
/* 24:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.bsm.impl.SynInterfaceBsmImpl
 * JD-Core Version:    0.7.0.1
 */