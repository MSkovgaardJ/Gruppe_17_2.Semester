package logic;

import common.IAid;
import common.IJournal;
import java.sql.Date;
import common.ICitizen;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Morten Skovgaard
 */
public class Journal implements IJournal, Comparable<Journal> {

    private int ID;
    private Date date;
    private String status;
    private String JLocation;
    private ICitizen citizen;
    private IAid aid;
    private int ssn;
    //private Collection<IAid> Aids;
    

    public Journal() {
        this.date = new Date(System.currentTimeMillis());
        this.JLocation = "";        
    }       

    @Override
    public IJournal clone() {
        IJournal j = new Journal();
        j.setDate(date);
        j.setID(ID);
        j.setJournalLocation(JLocation);
        j.setStatus(status);
        j.setCitizen(citizen);
        j.addAid(aid);
        return j;
    }

    @Override
    public void setID(int ID) {this.ID = ID; }

    @Override
    public void setStatus(String status) { this.status = status;}

    @Override
    public void setDate(Date date) {this.date = date; }

    @Override
    public void setJournalLocation(String Location) { this.JLocation = Location;}

    @Override
    public int getID() {return this.ID;}

    @Override
    public String getStatus() {return this.status;}

    @Override
    public Date getDate() {return this.date;}

    @Override
    public String getJournalLocation() {return JLocation;}
    
    @Override
    public ICitizen getCitizen() {return this.citizen;}
    
    @Override
    public void setCitizen(ICitizen citizen) 
    {
        this.citizen = citizen;
    }
    
    @Override
    public void addAid(IAid aid) {this.aid = aid;}
    
    @Override
    public void removeAid(IAid aid) 
    {
        this.removeAid(aid);
    }
   
    

    @Override
    public int compareTo(Journal o) {
        return Integer.compare(this.ID,o.ID);
    }

    @Override
    public void setSSN(int ssn)
    {
        this.ssn = ssn;
    }
    @Override
    public String toString()
    {
        String s ="JNO : " +this.ID+"\n";
        if(this.citizen!= null){
            s+="SSN : "+ this.citizen.getSSN()+"\n";
            s+="Name: "+this.citizen.getFirstName()+"\n";
        }
        else
            s+="SSN : NULL";
        return s;     
        
    }
}
 
//OLD IMPLIMENTATION
    
//    public int getID() {
//        return ID;
//    }
//
//    public Citizen getCitizen() {
//        return citizen;
//    }
//
//    public String getWorkerName() {
//        return workerName;
//    }
//
//    @Override
//    public String getJournalDescription() {
//        return journalDescription;
//    }
//
//    @Override
//    public void setID(int journalNo) {
//        this.ID = journalNo;
//    }
//
//    public void setCitizen(Citizen citizen) {
//        this.citizen = citizen;
//    }
//
//    public void setWorkerName(String workerName) {
//        this.workerName = workerName;
//    }
//
//    public void setJournalDescribsion(String journalDescription) {
//        this.journalDescription = journalDescription;
//    }
//
//    public Collection<IAid> aidsAppliedFor() {
//        Collection<IAid> aids = new ArrayList<>();
//        return aids;
//    }
//
//    public String getAppliedAid(IAid aidNo) {
//        aidsAppliedFor().toString();
//        String aidName = aidNo.getAidName();
//        return aidName;
//    }
//
//    public void addAid(IAid aidNo) {
//        aidsAppliedFor().add(aidNo);
//    }
//
//    public void removeAid(IAid aidNo) {
//        aidsAppliedFor().remove(aidNo);
//    }
//
//    @Override
//    public IJournal clone() {
//        IJournal journal = new Journal();
//        return journal;
//    }
//
//    @Override
//    public void setJournalName(String jName) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setJournalDescription(String description) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getJournalName() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getjournalnumber() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setjournalnumber(int journalNumber) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setdate(Date date) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setjournallocation(String journalLocation) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setstatus(boolean status) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Date getdate() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getjournallocation() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean getstatus() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int compareTo(Journal o) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setStatus(String status) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setDate(Date date) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setJournalLocation(String Location) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getStatus() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Date getDate() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getJournalLocation() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }