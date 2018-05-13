/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private File journalDescribsion;

    public Journal(int journalNo, Citizen citizen, String workerName, File journalDescribsion)
    {
        this.journalNo = journalNo;
        this.citizen = citizen;
        this.workerName = workerName;
        this.journalDescribsion = journalDescribsion;
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

    public File getJournalDescribsion()
    {
        return journalDescribsion;
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

    public void setJournalDescribsion(File journalDescribsion)
    {
        this.journalDescribsion = journalDescribsion;
    }
    
    
    
}
