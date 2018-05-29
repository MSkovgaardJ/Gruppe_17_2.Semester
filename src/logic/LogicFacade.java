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
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Morten Skovgaard
 */
public class LogicFacade implements ILogicFacade {

    private IDataFacede dataHandler;
    private SystemUser User;
    public LogicFacade()
    {
        
    }
    // -------------------- Citizen --------------------------------------------
    @Override
    public void saveCitizen() {
      ICitizen c = JournalHandler.getInstance().getActiveCitizen();
      dataHandler.saveCitizen(c);
    }
    @Override
    public void addCitizen() {
        ICitizen citizen = JournalHandler.getInstance().getActiveCitizen();
        dataHandler.addCitizen(citizen);
    }
    @Override
    public void newCitizen() {
        JournalHandler.getInstance().createCitizen();
    }
    @Override
    public boolean citizenExist(int snn) {        
        return dataHandler.citizenExist(snn);   
    }
    @Override
    public void getCitizen(int ssn) {
        ICitizen citizen = JournalHandler.getInstance().createCitizen();
        citizen.setSSN(ssn);
        // loads Citizen
        dataHandler.getCitizen(citizen);        
    }
    @Override
    public Collection<ICitizen> getCitizens() {
        return dataHandler.getCitizens(new Citizen());

    }
    @Override
    public void removeCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
    @Override
    public ICitizen getActiveCitizen() {
        return JournalHandler.getInstance().getActiveCitizen();
    }
    // -------------------- Journal --------------------------------------------
    @Override
    public Collection<IJournal> getJournals() {        
        return dataHandler.getJournals(new Journal());
    }
    @Override
    public void newJournal() {
        // a list of all journals
        List<IJournal> list = (ArrayList<IJournal>)getJournals();
        //sorts the list on ID number 
        list.sort(new Comparator<IJournal>() {
            @Override
            public int compare(IJournal o1, IJournal o2) {
                return Integer.compare(o1.getJNO(), o2.getJNO());
            }
        });
        // get the id of the last journal
        int jno = -1;
        if (!list.isEmpty()) {
            jno = list.get(list.size() - 1).getJNO();
        }
        // add 1 to it
        jno++;
        // makes a new jouranl
        IJournal journal = JournalHandler.getInstance().createJournal();
        // sets new id 
        journal.setJNO(jno);
    }
    @Override
    public void saveJournal() {
        //System.out.println("Saving journal ID : " +JournalHandler.getInstance().getActiveJournal().getJNO());
        dataHandler.saveJournal(JournalHandler.getInstance().getActiveJournal());
    }
    @Override
    public void addJournal() {
        dataHandler.addJournal(JournalHandler.getInstance().getActiveJournal());
    }

    @Override
    public Collection<Integer> getAllJournalsFor(int ssn) {
        return dataHandler.getAllJournalsFor(ssn);
    }
    @Override
    public void getJournal(int jno) {
        IJournal j = JournalHandler.getInstance().createJournal();
        j.setJNO(jno);
        dataHandler.getJournal(j,j.getCitizen());
        if(j.getJNO()!=-1)
        {
            JournalHandler.getInstance().setActiveCitizen(j.getCitizen());
        }
        else
        {
            //System.out.println("Clearing Journal Handler");
            JournalHandler.getInstance().Clear();
        }
    }
    @Override
    public void removeJournal(IJournal journal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public IJournal getActiveJournal() {
        return JournalHandler.getInstance().getActiveJournal();
    }
    @Override
    public void openJournalDiscription() {
        JournalHandler.getInstance().openJournalDiscription();
        saveJournal();
    }
    // -------------------- AID ------------------------------------------------
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
    // -------------------- System ---------------------------------------------
    @Override
    public void changeSystemUser(ISystemUser isu) {
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


}
