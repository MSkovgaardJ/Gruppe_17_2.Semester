/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Collection;

/**
 *
 * @author magnusm
 */
public interface IDataFacede {
    public void getJournal(IJournal journal);
    public Collection<IJournal> getJournals(IJournal base);
    public Collection<IJournal> getAllJournalsFor(IJournal base, int ssn);
    public void addJournal(IJournal base);
    public void removeJournal(IJournal journal);
    public Collection<IJournal>getJournalsForCiticen(IJournal base, int ssn);
    
    public void addCitizen(ICitizen citizen);
    public void removeCitizen(ICitizen citizen);
    public void getCitizen(ICitizen citizen); 
    public Collection<ICitizen> getCitizens(ICitizen base);   
        
    public void getAid(IAid aidNo);
    public Collection<IAid> getAids(IAid base);
    public void addAid(IAid aid);
    public void removeAid(IAid aid);
    
    public void addSystemUser(ISystemUser isu);
    public void removeSystemUser(ISystemUser isu);
    public void changeSystemUser(ISystemUser isu);
    public boolean checkLogin(String username, String password);   
    public void getCredentials(ISystemUser user);
    
}
