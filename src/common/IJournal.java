package common;

import java.sql.Date;

/**
 *
 * @author magnusm
 */

public interface IJournal 
{
    public IJournal clone();
    public void setID(int ID);
    public void setJournalName(String jName);
    public void setJournalDescription(String description);
    public int getID();
    public String getJournalName();
    public String getJournalDescription();
    public int getjournalnumber();    
    public void setjournalnumber(int journalNumber);    
    public void setdate(Date date);
    public void setjournallocation(String journalLocation);
    public void setstatus(boolean status);
    public Date getdate();
    public String getjournallocation();  
    public boolean getstatus();
}
