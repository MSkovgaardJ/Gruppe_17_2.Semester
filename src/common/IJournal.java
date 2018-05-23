package common;

import java.sql.Date;
import java.util.Collection;

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
    public void setCitizen(ICitizen citizen);
    public void setSSN(int ssn);
    
    public int getID();
    public String getStatus();
    public Date getDate();
    public String getJournalLocation();
    public ICitizen getCitizen();
    public Collection<IAid>getAids(); 
    
    public void addAid(IAid aid);
    
    public void removeAid(IAid aid);
}
