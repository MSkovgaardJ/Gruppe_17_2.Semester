/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import common.ICitizen;
import common.IDataHandler;
import common.IDataFaceda;
import common.IJournal;
import common.ILoginToken;

/**
 *
 * @author magnusm
 */
public class DataFacade implements IDataFaceda
{
    IDataHandler dataHandler;
    public DataFacade(){
        this.dataHandler = new SQLHandler();
    }
    @Override
    public boolean checkLogin(String username, String password) {
        dataHandler.checkLogin(username, password);
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
    
    
}
