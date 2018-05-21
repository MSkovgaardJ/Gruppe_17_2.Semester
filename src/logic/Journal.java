package logic;

import common.IAid;
import common.IJournal;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Morten Skovgaard
 */

public class Journal implements IJournal
{
    private int journalNo;
    private Citizen citizen;
    private String workerName;
    private File journalDescription;
    private Collection<IAid>Aids;

    public Journal(int journalNo, Citizen citizen, String workerName, File journalDescription)
    {
        
        this.journalNo = journalNo;
        this.citizen = citizen;
        this.workerName = workerName;
        this.journalDescription = journalDescription;
    }

    private Journal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public Collection<IAid> aidsAppliedFor()
    {
        Collection<IAid> aids = new ArrayList<>();
        return aids;
    }
    
    public String getAppliedAid(IAid aidNo)
    {
        aidsAppliedFor().toString();
        String aidName = aidNo.getAidName();
        return aidName;
    }
    
    public void addAid(IAid aidNo)
    {
        aidsAppliedFor().add(aidNo);
    }
    
    public void removeAid(IAid aidNo)
    {
        aidsAppliedFor().remove(aidNo);
    }
    
    public IJournal clone() {
        IJournal journal = new Journal(journalNo, citizen, workerName, journalDescription);
        return journal;
    }

    @Override
    public void setJournalName(String jName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJournalDescription(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
