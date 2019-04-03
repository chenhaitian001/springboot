package com.four.server.asm.impl;
 
 import com.four.common.tpm.RecordTpm;
 import com.four.common.tpm.SyncConfig;
 import com.four.common.tpm.SyncRecordTpm;
 import com.four.common.tpm.UserTpm;
 import com.four.common.types.DbPager;
 import com.four.common.types.DbPagerUtil;
 import com.four.common.utils.TheApp;
 import com.four.common.utils.Utils;
 import com.four.server.asm.RecordAsm;
 import com.four.server.bsm.RecordBsm;
 import com.four.server.bsm.SynInterfaceBsm;
 import com.four.server.bsm.SystemBsm;
import com.four.server.bsm.impl.RecordBsmImpl;
import com.four.server.bsm.impl.SystemBsmImpl;

import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.OutputStreamWriter;
 import java.io.PrintStream;
 import java.sql.Timestamp;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Scope;
 import org.springframework.stereotype.Repository;
 
 @Scope("singleton")
 @Repository("recordAsm")
 public class RecordAsmImpl implements RecordAsm
 {
   static Logger logger  ;
   @Resource
   private RecordBsm recordBsm;
   @Resource
   private SystemBsm systemBsm;
   @Resource
   private SynInterfaceBsm synInterfaceBsm;
   private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   private static Integer maxLineCount = Integer.valueOf(500);
   
   public void convertData()
     throws Exception
   {
	 SystemBsm   systemBsm = new SystemBsmImpl();
     Date beginTime = systemBsm.getSynSystemTime(SyncConfig.SynCardTime.getValue());
     if (beginTime == null) {
       beginTime = dateTimeFormat.parse(dateTimeFormat.format(new Date()));
     }
     Date endTime = beginTime;
     
     DbPager pager = DbPagerUtil.getDefaultDbPager(maxLineCount.intValue());
     SyncRecordTpm syncRecordQuery = new SyncRecordTpm();
     syncRecordQuery.setModifiedDate(new Timestamp(beginTime.getTime()));
     Integer count = Integer.valueOf(1);
     Integer countNum = Integer.valueOf(0);
     for (;;)
     {
       List<SyncRecordTpm> syncRecordTpmList = this.synInterfaceBsm.querySyncRecord(syncRecordQuery, pager);
       if (Utils.isEmpty(syncRecordTpmList)) {
         break;
       }
       for (Object localObject = syncRecordTpmList.iterator(); ((Iterator)localObject).hasNext();)
       {
        SyncRecordTpm recordTpm = (SyncRecordTpm)((Iterator)localObject).next();
         if (recordTpm.getModifiedDate().getTime() > endTime.getTime()) {
           endTime = recordTpm.getModifiedDate();
         }
       }
       convertData(syncRecordTpmList);
       
       countNum = Integer.valueOf(countNum.intValue() + syncRecordTpmList.size());
       pager.setPageIndex(pager.getPageIndex() + 1);
      Integer localObject = count;Integer recordTpm = count = Integer.valueOf(count.intValue() + 1);System.out.println("syncBranch: " + localObject + " * " + maxLineCount);
     }
     logger.info("共处理的记录条数为: " + countNum);
     logger.info("卡点同步完成！");
     systemBsm.saveSynSystemTime(SyncConfig.SynCardTime.getValue(), endTime);
   }
   
   public void convertData(List<SyncRecordTpm> syncRecordTpmList)
     throws Exception
   {
     if (Utils.isEmpty(syncRecordTpmList)) {
       return;
     }
     Set<String> cardIdSet = new HashSet();
     List<SyncRecordTpm> syncRecords_existCardId = new ArrayList();
     List<SyncRecordTpm> syncRecords_noCardId = new ArrayList();
     for (SyncRecordTpm recordTpm : syncRecordTpmList)
     {
       String cardId = recordTpm.getCertificateID();
       if (cardId == null)
       {
         syncRecords_noCardId.add(recordTpm);
       }
       else
       {
         syncRecords_existCardId.add(recordTpm);
         cardIdSet.add(cardId);
       }
     }
     if (syncRecords_noCardId.size() > 0) {
       writeFile(syncRecords_noCardId, "", "trash_card", "原始数据中不存在身份证！");
     }
     Object cardIds = new ArrayList(cardIdSet);
     
     RecordBsm recordBsm = new RecordBsmImpl();
     
     List<UserTpm> userTpmList = recordBsm.getUserByCardIds((List)cardIds);
     if (userTpmList == null) {
       userTpmList = new ArrayList();
     }
     Map<String, Long> cardIdMap = new HashMap();
     for (UserTpm userTpm : userTpmList) {
       cardIdMap.put(userTpm.getCardId(), userTpm.getId());
     }
     Object recordTpmList = new ArrayList();
     List<SyncRecordTpm> syncRecords_trash = new ArrayList();
     for (SyncRecordTpm syncRecord : syncRecords_existCardId)
     {
       String cardId = syncRecord.getCertificateID();
       Long userId = (Long)cardIdMap.get(cardId);
       if (userId == null)
       {
         syncRecords_trash.add(syncRecord);
       }
       else
       {
         RecordTpm record = new RecordTpm();
         record.setTimestamp(syncRecord.getReadDate());
         record.setUserId(userId);
         record.setDevId(Long.valueOf(-1L));
         record.setCreate(new Timestamp(System.currentTimeMillis()));
         ((List)recordTpmList).add(record);
       }
     }
     if (syncRecords_trash.size() > 0) {
       writeFile(syncRecords_trash, "", "trash_card", "汉王系统中没有对应的身份证！");
     }
     if (((List)recordTpmList).size() > 0) {
       recordBsm.saveRecords((List)recordTpmList);
     }
   }
   
   public static <T> void writeFile(List<T> dataList, String fileNamePrefix, String dir, String comment)
   {
     try
     {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
       String dirPath = TheApp.getRootPath("syncDir") + File.separator + dir;
       File dirFile = new File(dirPath);
       if (!dirFile.exists()) {
         dirFile.mkdirs();
       }
       Date date = new Date();
       String fileName = fileNamePrefix + sdf.format(date) + ".txt";
       File file = new File(dirPath, fileName);
       BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
       
       writer.write(sdfDateTime.format(date) + "--start-------(" + comment + ")");
       writer.newLine();
       for (T obj : dataList)
       {
         writer.write(obj.toString());
         writer.newLine();
       }
       writer.write(sdfDateTime.format(date) + "--end---");
       writer.newLine();
       
       writer.close();
     }
     catch (Exception e)
     {
       logger.error("文件保存本地失败：" + e.getLocalizedMessage());
     }
   }
 }


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.asm.impl.RecordAsmImpl
 * JD-Core Version:    0.7.0.1
 */