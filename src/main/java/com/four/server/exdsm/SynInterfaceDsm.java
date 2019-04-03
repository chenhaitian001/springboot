package com.four.server.exdsm;

import com.four.common.tpm.SyncRecordTpm;
import com.four.common.types.DbPager;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SynInterfaceDsm
{
  public abstract List<SyncRecordTpm> querySyncRecord(@Param("syncRecordQuery") SyncRecordTpm paramSyncRecordTpm, @Param("pager") DbPager paramDbPager);
}


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.exdsm.SynInterfaceDsm
 * JD-Core Version:    0.7.0.1
 */