package common;

/**
 *
 * @author magnusm
 */

public interface IJournal
{
    public IJournal clone();
    public void setJournalNo(int journalNo);
    public void setJournalName(String jName);
    public void setJournalDescription(String description);
}
