/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Collection;

/**
 *
 * @author Stephanie
 */
public interface ILogicFacade {

    public void setDataHandler(IDataFacede dataHandler);
    
    public ICitizen newCitizen();
    public ICitizen getActiveCitizen();
    public ICitizen getCitizen(int ssn);
    public boolean citizenExist(int snn);
    public Collection<ICitizen> getCitizens();
    public void removeCitizen(ICitizen citizen); 
    public void saveCitizen();
    public void addCitizen();

    public IJournal getJournal(int jno);
    public IJournal getActiveJournal();
    public IJournal newJournal();
    public Collection<IJournal> getJournals();
    public Collection<Integer> getAllJournalsFor(int ssn);    
    public void saveJournal();
    public void addJournal();
    public void removeJournal(IJournal journal);
    public void openJournalDiscription();
    
    public IAid getAid(int aidno);
    public Collection<IAid> getAids();
    public void addAid(IAid aid);
    public void removeAid(IAid aid);
    
    public void addSystemUser(ISystemUser isu);
    public void removeSystemUser(ISystemUser isu);
    public void logout();
    public void changeSystemUser(ISystemUser isu);
    public void getCredentials(String username, String password, ILoginToken login);
    public boolean login(String username, String password);

    



  
}
