package data;

import common.ICitizen;
import java.sql.Date;

/**
 *
 * @author Morten Skovgaard
 */

public class SQLSet {

    public static  String addCitizen(ICitizen c) {

        return "Insert into Citizen (ssn, firstname, lastname, address, postalnumber, city, phonenumber, contactperson)\n"
                + "values('" + c.getSSN() + "','" + c.getFirstName() + "','" + c.getLastName() + "','" 
                + c.getAddress() + "','" + c.getPostalNumber() + "','" + c.getCity() + "','" 
                + c.getPhoneNumber() + "','Mett From Accounting');";
    }
    public static  String saveCitizen(ICitizen c) {
        return "update citizen "
                + "set firstname = '"+c.getFirstName()+"', lastname= '"+c.getLastName()+"', "
                + "address = '"+c.getAddress()+"', postalnumber= "+c.getPostalNumber()+", "
                + "city = '"+c.getCity()+"', phonenumber= '"+c.getPhoneNumber()+"', "
                + "contactperson = 'Mett From Accounting' " 
                + "WHERE ssn = "+c.getSSN(); 
    }

    public static  String addJournal(int journalnumber, int status, String journallocation, Date date) {
        return "Insert into journal \n"
                + "values('" + journalnumber + "', '" + status + "', '" + journallocation + "', '" + date + "');";
    }
    public static  String saveJournal(int journalnumber, int status, String journallocation, Date date) {
        return "update journal "
                + "set Status = '"+status+"', Journallocation= '"+journallocation+"', "
                + "Date= '"+date+"' "
                + "WHERE JournalNumber = "+journalnumber; 
    }

    public static  String addAid(int aidnumber, String name, String description) {

        return "Insert into aid \n"
                + "values('" + aidnumber + "','" + name + "','" + description + "');";
    }
    public static  String addCitizenJournalRelation(int ssn,int jid) {

        return "Insert into Citizenhas \n"
                + "values('" + ssn + "','" + jid +"');";
    }
    
    public static String addAidtoJournal(int aidnumber, int jid){
        
        return "insert into appliesFor \n" 
                +"values(' " + aidnumber + "','" + jid + "');";
    }
}
