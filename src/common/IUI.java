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
public interface IUI {
    public boolean tryLogin();
    public ICitizen getCitizen(int ssn);
    public IJournal getJournal(int journalno);
    public void setDataHandler(IDataFaceda dataHandler); 
    public IAid getAid(int aidno);
    public Collection<ICitizen> getCitizens();
    public Collection<IJournal> getJournals();
    public Collection<IAid> getAids();
    public boolean changeSystemUser(ISystemUser isu);    
}
