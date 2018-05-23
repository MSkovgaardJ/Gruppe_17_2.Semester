package logic;

import common.IAid;
import common.ICitizen;
import common.IDataFacede;
import common.IJournal;
import common.ILogicFacade;
import common.ILoginToken;
import common.ISystemUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Morten Skovgaard
 */
public class LogicFacade implements ILogicFacade {

    private IDataFacede dataHandler;
    private SystemUser User;
    private JournalHandler JH;

    @Override
    public void addCitizen(ICitizen citizen) {
        addCitizen(citizen);

    }

    @Override
    public ICitizen getCitizen(int ssn) {
        ICitizen citizen = new Citizen();
        citizen.setSSN(ssn);
        dataHandler.getCitizen(citizen);
        return citizen;
    }

    @Override
    public Collection<ICitizen> getCitizens() {
        return dataHandler.getCitizens(new Citizen());
    }

    @Override
    public Collection<IJournal> getJournals() {
        return dataHandler.getJournals(new Journal());
    }

    @Override
    public IJournal getJournal(int journalno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IJournal newJournal() {
        // a list of all journals
        List<IJournal> list = (ArrayList<IJournal>) dataHandler.getJournals(new Journal());
        //sorts the list on ID number 
        list.sort(new Comparator<IJournal>() {
            @Override
            public int compare(IJournal o1, IJournal o2) {
                return Integer.compare(o1.getID(), o2.getID());
            }
        });
        // get the id of the last journal
        int jno =-1;
        if(!list.isEmpty()) jno= list.get(list.size() - 1).getID();
        // add 1 to it
        jno++;
        // makes a new jouranl
        IJournal journal = new Journal();
        // sets new id 
        journal.setID(jno);
        // returns new journal.
        return journal;
    }

    @Override
    public IAid getAid(int aidNo) {
        IAid gAid = new Aid();
        gAid.setAidNo(aidNo);
        dataHandler.getAid(gAid);
        return gAid;
    }

    @Override
    public Collection<IAid> getAids() {
        return dataHandler.getAids(new Aid()); 
    }

    @Override
    public boolean changeSystemUser(ISystemUser isu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String username, String password) {
        if (dataHandler.checkLogin(username, password)) {
            this.User = new SystemUser(username, password);
            dataHandler.getCredentials(this.User);
            return true;
        }
        return false;
    }

    @Override
    public void getCredentials(String username, String password, ILoginToken login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        this.User = null;
    }

    @Override
    public void setDataHandler(IDataFacede dataHandler) {
        this.dataHandler = dataHandler;
    }

    @Override
    public Collection<IJournal> getAllJournalsFor(int ssn) {return dataHandler.getAllJournalsFor(new Journal(), ssn);}

    @Override
    public void removeCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getJournal(IJournal journal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeJournal(IJournal journal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAid(IAid aid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAid(IAid aid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSystemUser(ISystemUser isu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSystemUser(ISystemUser isu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<IJournal> getJournalsForCitizen(IJournal base, int ssn)
    {
        return dataHandler.getAllJournalsFor(base, ssn);
    }

}
