/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Date;
/**
 *
 * @author Morten Skovgaard
 */
public class SQLset
  {
   public final String addCitizen(int ssn, String firstname, String lastname, String address, int postalnumber, String city, int phonenumber, String contactperson)
      {
        
        return "Insert into citizen (ssn, firstname,lastname, address, postalnumber, city, phonenumber, contactperson)\n"
                + "values('"+ssn+"','"+firstname+"','"+lastname+"','"+address+"','"+postalnumber+"','"+city+"','"+phonenumber+"','"+contactperson+"');";
      }
    
    public final String addJournal(int journalnumber, boolean status, String journallocation, Date date)
      {
        
        return  "Insert into journal \n"
                + "values('"+journalnumber+"','"+status+"','"+journallocation+"','"+date+"');";
      }
    
    public final String addAid(int aidnumber, String name, String description)

      {
        
        return "Insert into aid \n"
                + "values('"+aidnumber+"','"+name+"','"+description+"');";
      }  
 
  
  
  
  
  
  
  }
