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
public class Journal implements IJournal, Comparable<Journal> {

    private int ID;
    private Citizen citizen;
    private String workerName;
    private String journalDescription;
    private Collection<IAid> Aids;

    public Journal() {
    }

    public int getID() {
        return ID;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public String getWorkerName() {
        return workerName;
    }

    @Override
    public String getJournalDescription() {
        return journalDescription;
    }

    @Override
    public void setID(int journalNo) {
        this.ID = journalNo;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public void setJournalDescribsion(String journalDescription) {
        this.journalDescription = journalDescription;
    }

    public Collection<IAid> aidsAppliedFor() {
        Collection<IAid> aids = new ArrayList<>();
        return aids;
    }

    public String getAppliedAid(IAid aidNo) {
        aidsAppliedFor().toString();
        String aidName = aidNo.getAidName();
        return aidName;
    }

    public void addAid(IAid aidNo) {
        aidsAppliedFor().add(aidNo);
    }

    public void removeAid(IAid aidNo) {
        aidsAppliedFor().remove(aidNo);
    }

    @Override
    public IJournal clone() {
        IJournal journal = new Journal();
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

    @Override
    public int compareTo(Journal o) {
        int r = Integer.compare(this.ID, o.ID);
        return r;
    }

    @Override
    public String getJournalName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
