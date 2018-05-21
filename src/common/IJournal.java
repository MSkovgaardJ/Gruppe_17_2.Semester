package common;

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
}
