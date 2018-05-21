package data;

import common.IAid;
import common.ICitizen;
import common.IDBCom;
import common.IJournal;
import common.ISystemUser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author magnusm
 */
public class SQLHandler {

    private IDBCom comhandler;
    public SQLHandler() {
        comhandler = new postgreSQLCom();
    }
    public boolean checkLogin(String username, String password) {
        boolean fund = false;
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.checklogin(username, password));
            if (rs.next()) {
                if ((rs.getString(1).equalsIgnoreCase(username))
                        && (rs.getString(2).equalsIgnoreCase(password))) {
                    System.out.println("found user");
                    fund = true;
                }

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return fund;
        }
    }
    public void getCredentials(ISystemUser user) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getlogincredentials(user.getUserName(), user.getPassword()));
            if (rs.next()) {
                boolean isAdmin = rs.getBoolean(1);
                boolean isCaseHandler = rs.getBoolean(2);
                user.getClearance().setClearance(isAdmin, isCaseHandler);
                System.out.println("got credentials");
                //System.out.println("is Admin "+ isAdmin +"\nis Casehandler "+ isCaseHandler);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public Collection<IJournal> getAllJournalsFor(IJournal base, int ssn) {
        return null;
    }
    public void getJournal(IJournal journal) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getJournal(journal.getID()));
            if (rs.next()) {
                int ID = rs.getInt(0);
                //boolean status = rs.getBoolean(1);
                String journallocation = rs.getNString(2);
                Date date = rs.getDate(3);

                journal.setID(ID);
                journal.setDate(date);
                journal.setJournalLocation(journallocation);
                //journal.setStatus(status);
                System.out.println("found journal");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }
    public void getCitizen(ICitizen citizen) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getCitizen(citizen.getSSN()));
            if (rs.next()) {
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String phonenumber = rs.getString(7);
                int ssn = rs.getInt(1);
                String address = rs.getString(4);
                String city = rs.getString(6);
                int postalNumber = rs.getInt(5);

                citizen.setAddress(address);
                citizen.setCity(city);
                citizen.setFirstName(fname);
                citizen.setLastName(lname);
                citizen.setSSN(ssn);
                citizen.setPhoneNumber(phonenumber);
                citizen.setPostalNumber(postalNumber);
                System.out.println("got citizen");
            } else {
                citizen.setSSN(-1);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public Collection<ICitizen> getCitizens(ICitizen base) {
        Collection<ICitizen> list = new ArrayList<>();
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAllCitizens);
            while (rs.next()) {
                ICitizen citizen = base.clone();
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String phonenumber = rs.getString(7);
                int ssn = rs.getInt(1);
                String address = rs.getString(4);
                String city = rs.getString(6);
                int postalNumber = rs.getInt(5);

                citizen.setAddress(address);
                citizen.setCity(city);
                citizen.setFirstName(fname);
                citizen.setLastName(lname);
                citizen.setSSN(ssn);
                citizen.setPhoneNumber(phonenumber);
                citizen.setPostalNumber(postalNumber);

                list.add(citizen);
                //System.out.println("is Admin "+ isAdmin +"\nis Casehandler "+ isCaseHandler);
            }
            System.out.println("got Citizens");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public void getAid(IAid aid) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAid(aid.getAidNo()));
            if (rs.next()) {
                int aidNo = rs.getInt(1);
                String aname = rs.getNString(2);
                String describsion = rs.getNString(3);

                aid.setAidNo(aidNo);
                aid.setAidName(aname);
                aid.setAidDescribsion(describsion);

                System.out.println("got aid");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public Collection<IJournal> getJournals(IJournal base) {
        Collection<IJournal> list = new ArrayList();
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAllJournals);
            while (rs.next()) {
                IJournal journal = base.clone();
                int id = rs.getInt(1);
                String Status = rs.getString(2);
                String journallocation = rs.getString(3);
                Date date = rs.getDate(4);                
                
                journal.setID(id);
                journal.setDate(date);
                journal.setJournalLocation(journallocation);

                list.add(base);
            }
            System.out.println("got journals");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public Collection<IAid> getAids(IAid base) {
        Collection<IAid> list = new ArrayList();
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAllAids);
            while (rs.next()) {
                IAid aid = base.clone();
                int aidNo = rs.getInt(1);
                String aName = rs.getNString(2);
                String description = rs.getNString(3);

                aid.setAidNo(aidNo);
                aid.setAidName(aName);
                aid.setAidDescribsion(description);
                list.add(base);
            }
            System.out.println("got journal");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public boolean changeSystemUser(ISystemUser isu) {

        return false;
    }
}
