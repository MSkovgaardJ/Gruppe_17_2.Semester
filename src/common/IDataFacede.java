/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import common.ICitizen;
import common.IJournal;
import common.ILoginToken;
import java.util.Collection;

/**
 *
 * @author magnusm
 */
public interface IDataFacede {
    public boolean checkLogin(String username, String password);   
    public void getCredentials(ISystemUser user);
    public void getJournal(IJournal journal);
    public void getCitizen(ICitizen citizen); 
    public void getAid(IAid aidNo);
    public Collection<ICitizen> getCitizens(ICitizen base);   
    public Collection<IJournal> getJournals(IJournal base);
    public Collection<IAid> getAids(IAid base);
    public boolean changeSystemUser(ISystemUser isu);
}
