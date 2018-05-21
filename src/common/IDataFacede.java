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
    
    public void getCitizen(ICitizen citizen); 
    public Collection<ICitizen> getCitizens(ICitizen base);   
        
    public void getAid(IAid aidNo);
    public Collection<IAid> getAids(IAid base);
    
    public boolean changeSystemUser(ISystemUser isu);
    public boolean checkLogin(String username, String password);   
    public void getCredentials(ISystemUser user);
    
}
