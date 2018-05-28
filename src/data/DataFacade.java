package data;

import common.IAid;
import common.ICitizen;
import common.IJournal;
import common.ILoginToken;
import common.IDataFacede;
import common.ISystemUser;
import java.util.Collection;

/**
 *
 * @author magnusm
 */
public class DataFacade implements IDataFacede {

    SQLHandler dataHandler;

    public DataFacade() {
        this.dataHandler = new SQLHandler();
    }

    //-------------------- System User------------------------------------------
    @Override
    public void changeSystemUser(ISystemUser isu) {
        dataHandler.changeSystemUser(isu);
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
    public boolean checkLogin(String username, String password) {
        return dataHandler.checkLogin(username, password);
    }
    @Override
    public void getCredentials(ISystemUser user) {
        dataHandler.getCredentials(user);
    }
    //-------------------- Citizen ---------------------------------------------   
    @Override
    public boolean citizenExist(int snn) {
        return dataHandler.citizenExist(snn); 
    }
    @Override
    public void addCitizen(ICitizen citizen) {
        dataHandler.addCitizen(citizen);
    }
    @Override
    public void removeCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void getCitizen(ICitizen citizen) {
        dataHandler.getCitizen(citizen);
    }
    @Override
    public Collection<ICitizen> getCitizens(ICitizen base) {
        return dataHandler.getCitizens(base);
    }
    @Override
    public void saveCitizen(ICitizen citizen) {
        dataHandler.saveCitizen(citizen);
    }
    //-------------------- Journal ---------------------------------------------
    @Override
    public void getJournal(IJournal journal, ICitizen citizen) {
        dataHandler.getJournal(journal, citizen);
    }
    @Override
    public Collection<IJournal> getJournals(IJournal base) {
        return dataHandler.getJournals(base);
    }
    @Override
    public void addJournal(IJournal base) {
        dataHandler.addJournal(base);
    }
    @Override
    public void saveJournal(IJournal journal) {
        dataHandler.saveJournal(journal);
    }
    @Override
    public void removeJournal(IJournal journal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Collection<Integer> getAllJournalsFor(int ssn) {
        return dataHandler.getAllJournalsFor(ssn);
    }
    //-------------------- AID -------------------------------------------------
    @Override
    public void getAid(IAid aid) {
        dataHandler.getAid(aid);
    }
    @Override
    public Collection<IAid> getAids(IAid base) {
        return dataHandler.getAids(base);
    }
    @Override
    public void addAid(IAid aid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void removeAid(IAid aid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
