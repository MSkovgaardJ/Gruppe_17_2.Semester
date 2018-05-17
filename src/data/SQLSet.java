package data;

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
    
    public final String addJournal()
      {
        
        return null;
      }
    
    public final String addAid()
      {
        
        return null;
      }  
 
  
  
  
  
  
  
  }
