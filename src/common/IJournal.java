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
    public void setStatus(String status);
    public void setDate(Date date);
    public void setJournalLocation(String Location);

    public int getID();
    public String getStatus();
    public Date getDate();
    public String getJournalLocation();
}
