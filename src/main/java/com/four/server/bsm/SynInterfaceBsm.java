package com.four.server.bsm;

import com.four.common.tpm.SyncRecordTpm;
import com.four.common.types.DbPager;
import java.util.List;

public abstract interface SynInterfaceBsm
{
  public abstract List<SyncRecordTpm> querySyncRecord(SyncRecordTpm paramSyncRecordTpm, DbPager paramDbPager);
}


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.bsm.SynInterfaceBsm
 * JD-Core Version:    0.7.0.1
 */