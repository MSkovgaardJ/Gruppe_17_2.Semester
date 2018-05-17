package data;

import java.sql.Date;
/**
 *
 * @author Morten Skovgaard
 */

public class SQLSet
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
