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
    @Override
    public void changeSystemUser(ISystemUser isu) {
        dataHandler.changeSystemUser(isu);
    }
    @Override
    public boolean checkLogin(String username, String password) {
        return dataHandler.checkLogin(username, password);
    }
    @Override
    public void getCredentials(ISystemUser user) {
        dataHandler.getCredentials(user);
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
    public void getJournal(IJournal journal) {
        dataHandler.getJournal(journal);
    }
    @Override
    public Collection<IJournal> getJournals(IJournal base) {
        return dataHandler.getJournals(base);
    }
    @Override
    public Collection<IJournal> getAllJournalsFor(IJournal base, int ssn) {
        return dataHandler.getAllJournalsFor(base, ssn);
    }  
    @Override
    public Collection<IJournal> getJournalsForCiticen(IJournal base, int ssn)
    {
        return dataHandler.getJournalsForCitizen(base, ssn);
    }    
    @Override
    public void getAid(IAid aid) {
        dataHandler.getAid(aid);
    }
    @Override
    public Collection<IAid> getAids(IAid base) {
        return dataHandler.getAids(base);
    }
    @Override
    public void addJournal(IJournal base) { 
        dataHandler.addJournal(base);
    }
    @Override
    public void removeJournal(IJournal journal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void addCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void removeCitizen(ICitizen citizen) {
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

    
}
