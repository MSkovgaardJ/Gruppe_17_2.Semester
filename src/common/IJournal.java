package common;

import java.sql.Date;

/**
 *
 * @author magnusm
 */

public interface IJournal
{
    public int getjournalnumber();
    
    public void setjournalnumber(int journalNumber);
    
    public void setdate(Date date);
    
    public void setjournallocation(String journalLocation);
    
    public void setstatus(boolean status);
    
    public Date getdate();
    
    public String getjournallocation();
    
    public boolean getstatus();
    
}
