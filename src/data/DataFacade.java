/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import common.ICitizen;
import common.IJournal;
import common.ILoginToken;
import common.IDataFacede;
import java.util.Collection;

/**
 *
 * @author magnusm
 */
public class DataFacade implements IDataFacede
{
    SQLHandler dataHandler;
    public DataFacade(){
        this.dataHandler = new SQLHandler();
    }
    @Override
    public boolean checkLogin(String username, String password) 
    {
       return dataHandler.checkLogin(username, password);
    }

    @Override
    public void getCredentials(String username, String password, ILoginToken token) 
    {
        dataHandler.getCredentials(username, password, token);
    }

    @Override
    public void getJournal(IJournal journal) 
    {
        dataHandler.getJournal(journal);
    }
    

    @Override
    public void getCitizen(ICitizen citizen) 
    {
        dataHandler.getCitizen(citizen);
    }

    @Override
    public Collection<ICitizen> getCitizens(ICitizen base) 
    {
        return dataHandler.getCitizens(base);        
    }    
}
