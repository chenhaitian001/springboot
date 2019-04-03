/*  1:   */ package com.four.common.types;
/*  2:   */ 
/*  3:   */ public class DbSort
/*  4:   */ {
/*  5:   */   private String sortField;
/*  6:15 */   private String sortMode = "asc";
/*  7:   */   
/*  8:   */   public DbSort() {}
/*  9:   */   
/* 10:   */   public DbSort(DbSort sort)
/* 11:   */   {
/* 12:20 */     from(sort);
/* 13:   */   }
/* 14:   */   
/* 15:   */   public DbSort clone()
/* 16:   */   {
/* 17:24 */     DbSort s = new DbSort();
/* 18:25 */     s.from(this);
/* 19:26 */     return s;
/* 20:   */   }
/* 21:   */   
/* 22:   */   private void from(DbSort sort)
/* 23:   */   {
/* 24:30 */     this.sortField = sort.sortField;
/* 25:31 */     this.sortMode = sort.sortMode;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getSortField()
/* 29:   */   {
/* 30:35 */     return this.sortField;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setSortField(String sortField)
/* 34:   */   {
/* 35:39 */     this.sortField = sortField;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getSortMode()
/* 39:   */   {
/* 40:43 */     return this.sortMode;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setSortMode(String sortMode)
/* 44:   */   {
/* 45:47 */     this.sortMode = sortMode;
/* 46:   */   }
/* 47:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.types.DbSort
 * JD-Core Version:    0.7.0.1
 */