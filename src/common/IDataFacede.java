/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import common.ICitizen;
import common.IJournal;
import common.ILoginToken;

/**
 *
 * @author magnusm
 */
public interface IDataFacede {
    public boolean checkLogin(String username, String password);   
    public void getCredentials(String username, String password, ILoginToken token);
    public void getJournal(IJournal journal);
    public void getCitizen(ICitizen citizen);   
   
    
}
