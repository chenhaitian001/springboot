package com.four.server.dsm;

import com.four.common.tpm.KeyValueTpm;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SystemDsm
{
  public abstract KeyValueTpm getSystemConfig(String paramString);
  
  public abstract int saveSystemConfig(@Param("kvs") List<KeyValueTpm> paramList, @Param("userId") Long paramLong);
}


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.dsm.SystemDsm
 * JD-Core Version:    0.7.0.1
 */