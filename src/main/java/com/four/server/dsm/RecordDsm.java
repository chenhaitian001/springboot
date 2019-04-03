package com.four.server.dsm;

import com.four.common.tpm.RecordTpm;
import com.four.common.tpm.UserTpm;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public  interface RecordDsm
{
  public abstract int insertRecords(@Param("records") List<RecordTpm> paramList);
  
  public abstract UserTpm getUserByCardId(@Param("cardId") String paramString);
  
  public abstract List<UserTpm> getUserByCardIds(@Param("cardIds") List<String> paramList);
}


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.dsm.RecordDsm
 * JD-Core Version:    0.7.0.1
 */