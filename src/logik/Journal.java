package logik;

import java.io.File;

/**
 *
 * @author Morten Skovgaard
 */

public class Journal
{
    private int journalNo;
    private Citizen citizen;
    private String workerName;
    private File journalDescription;

    public Journal(int journalNo, Citizen citizen, String workerName, File journalDescription)
    {
        this.journalNo = journalNo;
        this.citizen = citizen;
        this.workerName = workerName;
        this.journalDescription = journalDescription;
    }

    public int getJournalNo()
    {
        
        return journalNo;
    }

    public Citizen getCitizen()
    {
        
        return citizen;
    }

    public String getWorkerName()
    {
        
        return workerName;
    }

    public File getJournalDescription()
    {
        
        return journalDescription;
    }

    public void setJournalNo(int journalNo)
    {
        this.journalNo = journalNo;
    }

    public void setCitizen(Citizen citizen)
    {
        this.citizen = citizen;
    }

    public void setWorkerName(String workerName)
    {
        this.workerName = workerName;
    }

    public void setJournalDescribsion(File journalDescription)
    {
        this.journalDescription = journalDescription;
    }
    
    
    
}
