package data;

import java.sql.Date;

/**
 *
 * @author Morten Skovgaard
 */

public class SQLSet {

    public static  String addCitizen(int ssn, String firstname, String lastname, String address, int postalnumber, String city, int phonenumber, String contactperson) {

        return "Insert into citizen (ssn, firstname,lastname, address, postalnumber, city, phonenumber, contactperson)\n"
                + "values('" + ssn + "','" + firstname + "','" + lastname + "','" + address + "','" + postalnumber + "','" + city + "','" + phonenumber + "','" + contactperson + "');";
    }

    public static  String addJournal(int journalnumber, boolean status, String journallocation, Date date) {
        return "Insert into journal \n"
                + "values('" + journalnumber + "','" + status + "','" + journallocation + "','" + date + "');";
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
