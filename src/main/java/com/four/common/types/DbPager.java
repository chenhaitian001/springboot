/*   1:    */ package com.four.common.types;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ 
/*   7:    */ public class DbPager
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10:    */   public static final int DEFAULT_PAGE_SIZE = 10;
/*  11: 20 */   private int pageIndex = 1;
/*  12: 24 */   private int pageSize = 10;
/*  13: 28 */   private int recordCount = 0;
/*  14: 32 */   private List<DbSort> dbSorts = new ArrayList();
/*  15:    */   
/*  16:    */   public int getRecordCount()
/*  17:    */   {
/*  18: 40 */     return this.recordCount;
/*  19:    */   }
/*  20:    */   
/*  21:    */   public void setRecordCount(int recordCount)
/*  22:    */   {
/*  23: 49 */     if (recordCount < 0) {
/*  24: 50 */       this.recordCount = 0;
/*  25:    */     } else {
/*  26: 52 */       this.recordCount = recordCount;
/*  27:    */     }
/*  28:    */   }
/*  29:    */   
/*  30:    */   public int getPageSize()
/*  31:    */   {
/*  32: 60 */     return this.pageSize;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setPageSize(int pageSize)
/*  36:    */   {
/*  37: 72 */     this.pageSize = pageSize;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public int getPageIndex()
/*  41:    */   {
/*  42: 80 */     return this.pageIndex;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setPageIndex(int pageIndex)
/*  46:    */   {
/*  47: 88 */     if (pageIndex <= 0) {
/*  48: 89 */       this.pageIndex = 1;
/*  49:    */     } else {
/*  50: 92 */       this.pageIndex = pageIndex;
/*  51:    */     }
/*  52:    */   }
/*  53:    */   
/*  54:    */   public int getRecordOffset()
/*  55:    */   {
/*  56:100 */     return this.pageSize * (this.pageIndex - 1);
/*  57:    */   }
/*  58:    */   
/*  59:    */   public int getPageCount()
/*  60:    */   {
/*  61:107 */     if (this.recordCount % this.pageSize == 0) {
/*  62:108 */       return this.recordCount / this.pageSize;
/*  63:    */     }
/*  64:110 */     return this.recordCount / this.pageSize + 1;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public DbPager(int pageSize, int pageIndex)
/*  68:    */   {
/*  69:124 */     setPageSize(pageSize);
/*  70:125 */     setPageIndex(pageIndex);
/*  71:    */   }
/*  72:    */   
/*  73:    */   public DbPager()
/*  74:    */   {
/*  75:132 */     setPageSize(this.pageSize);
/*  76:133 */     setPageIndex(this.pageIndex);
/*  77:    */   }
/*  78:    */   
/*  79:    */   public List<DbSort> getDbSorts()
/*  80:    */   {
/*  81:137 */     return this.dbSorts;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setDbSorts(List<DbSort> dbSorts)
/*  85:    */   {
/*  86:141 */     this.dbSorts = dbSorts;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public DbPager(DbPager pager)
/*  90:    */   {
/*  91:145 */     from(pager);
/*  92:    */   }
/*  93:    */   
/*  94:    */   public DbPager clone()
/*  95:    */   {
/*  96:150 */     DbPager p = new DbPager();
/*  97:151 */     p.from(this);
/*  98:152 */     return p;
/*  99:    */   }
/* 100:    */   
/* 101:    */   private void from(DbPager pager)
/* 102:    */   {
/* 103:156 */     this.pageIndex = pager.pageIndex;
/* 104:157 */     this.pageSize = pager.pageSize;
/* 105:158 */     this.recordCount = pager.recordCount;
/* 106:159 */     for (DbSort s : pager.dbSorts) {
/* 107:160 */       this.dbSorts.add(s.clone());
/* 108:    */     }
/* 109:    */   }
/* 110:    */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.types.DbPager
 * JD-Core Version:    0.7.0.1
 */