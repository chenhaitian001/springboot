package com.four.server.bsm;

import java.util.Date;

public abstract interface SystemBsm
{
  public abstract int saveSynSystemTime(String paramString, Date paramDate);
  
  public abstract Date getSynSystemTime(String paramString);
  
  public abstract Boolean getSynCardSetup();
}


/* Location:           E:\Henuo\public\public\bin\convertdata-1.0.jar
 * Qualified Name:     com.four.server.bsm.SystemBsm
 * JD-Core Version:    0.7.0.1
 */