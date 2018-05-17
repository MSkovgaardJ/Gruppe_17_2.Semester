/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logik;

import common.IAid;
import common.ICitizen;
import common.IDataFacede;
import common.IJournal;
import common.ILogicFacade;
import common.ILoginToken;
import common.ISystemUser;
import java.util.Collection;

/**
 *
 * @author Morten Skovgaard
 */
public class LogikFacade implements ILogicFacade
{
    private IDataFacede dataHandler;
    private SystemUser User;
    private JournalHandler JH;     
    @Override
    public void addData(IDataFacede data) {
        this.dataHandler = data;
    }  
    @Override
    public ICitizen getCitizen(int ssn) {
        ICitizen citizen = new Citizen();
        citizen.setSSN(ssn);
        dataHandler.getCitizen(citizen);
        return citizen;
    }
    @Override
    public IJournal getJournal(int journalno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setDataHandler(IDataFacede dataHandler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public IAid getAid(int aidno) 
    {
       
        return null;
    }
    @Override
    public Collection<ICitizen> getCitizens() {
        return dataHandler.getCitizens(new Citizen());
    }
    @Override
    public Collection<IJournal> getJournals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Collection<IAid> getAids() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean changeSystemUser(ISystemUser isu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    @Override
    public boolean login(String username, String password) {
        if(dataHandler.checkLogin(username, password))
        {
            this.User=new SystemUser(username,password);
            dataHandler.getCredentials(username, password, this.User.getClearance());
            return true;
        }
        return false;
    }
    @Override
    public void getCredentials(String username, String password, ILoginToken login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void getJournal(IJournal journal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void getCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        this.User = null;
    }
}
