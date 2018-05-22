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
    
    public void addCitizen(ICitizen citizen);
    public ICitizen getCitizen(int ssn);
    public Collection<ICitizen> getCitizens();
    public void removeCitizen(ICitizen citizen);
    

    public void getJournal(IJournal journal);
    public IJournal getJournal(int journalno);
    public Collection<IJournal> getJournals();
    public IJournal newJournal();
    public Collection<IJournal> getAllJournalsFor(int ssn);
    public void removeJournal(IJournal journal);
    
    public IAid getAid(int aidno);
    public Collection<IAid> getAids();
    public void addAid(IAid aid);
    public void removeAid(IAid aid);
    
    public void addSystemUser(ISystemUser isu);
    public void removeSystemUser(ISystemUser isu);
    public boolean changeSystemUser(ISystemUser isu);
    public boolean login(String username, String password);
    public void logout();
    public void getCredentials(String username, String password, ILoginToken login);
}
