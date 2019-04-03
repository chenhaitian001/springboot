package com.four.server.bsm;

import com.four.common.tpm.RecordTpm;
import com.four.common.tpm.UserTpm;
import java.util.List;

public abstract interface RecordBsm
{
  public abstract boolean saveRecords(List<RecordTpm> paramList);
  
  public abstract UserTpm getUserByCardId(String paramString);
  
  public abstract List<UserTpm> getUserByCardIds(List<String> paramList);
}


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.bsm.RecordBsm
 * JD-Core Version:    0.7.0.1
 */