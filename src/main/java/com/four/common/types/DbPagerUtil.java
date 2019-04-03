/*  1:   */ package com.four.common.types;
/*  2:   */ 
/*  3:   */ public class DbPagerUtil
/*  4:   */ {
/*  5:   */   public static DbPager getDbPager(Integer page)
/*  6:   */   {
/*  7:14 */     return getDbPager(10, page);
/*  8:   */   }
/*  9:   */   
/* 10:   */   public static DbPager getDbPager(int pageSize, Integer page)
/* 11:   */   {
/* 12:18 */     DbPager pager = getDefaultDbPager(pageSize);
/* 13:19 */     if (null == page) {
/* 14:20 */       pager.setPageIndex(1);
/* 15:23 */     } else if (page.intValue() < 1) {
/* 16:24 */       pager.setPageIndex(1);
/* 17:   */     } else {
/* 18:27 */       pager.setPageIndex(page.intValue());
/* 19:   */     }
/* 20:31 */     return pager;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public static DbPager getDefaultDbPager(int pageSize)
/* 24:   */   {
/* 25:35 */     DbPager pager = new DbPager();
/* 26:36 */     pager.setPageSize(pageSize);
/* 27:37 */     return pager;
/* 28:   */   }
/* 29:   */ }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.common.types.DbPagerUtil
 * JD-Core Version:    0.7.0.1
 */