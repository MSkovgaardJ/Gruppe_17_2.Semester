package data;

import common.IAid;
import common.ICitizen;
import common.IDBCom;
import common.IJournal;
import common.ISystemUser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.rsa.RSACore;

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
            ResultSet rs = st.executeQuery(SQLGet.checkLogin(username, password));
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
            ResultSet rs = st.executeQuery(SQLGet.getLoginCredentials(user.getUserName(), user.getPassword()));
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

    public void changeSystemUser(ISystemUser isu) {

    }

    public Collection<IJournal> getAllJournalsFor(IJournal base, int ssn) {
        Collection<IJournal> list = new ArrayList<>();
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getJournalsForCitizen(ssn));
            while (rs.next()) {
                IJournal journal = base.clone();
                int journalNo = rs.getInt(2);
                int SSN = rs.getInt(1);

                journal.setID(journalNo);
                journal.setSSN(SSN);

                list.add(journal);

                System.out.println("Got citizen' journal's");

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void getJournal(IJournal journal, ICitizen citizen) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getJournal(journal.getID()));
            if (rs.next()) {
                int ID = rs.getInt(1);
                //boolean status = rs.getBoolean(2);
                String journallocation = rs.getString(3);
                Date date = rs.getDate(4);

                journal.setID(ID);
                journal.setDate(date);
                journal.setJournalLocation(journallocation);
                //journal.setStatus(status);
                System.out.println("found journal");
            }
            rs = st.executeQuery(SQLGet.getCitizenForJournal(journal.getID()));
            int ssn = -1;
            if (rs.next()) {
                ssn = rs.getInt(1);
            }
            rs = st.executeQuery(SQLGet.getCitizen(ssn));
            if (rs.next()) {
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                int phonenumber = rs.getInt(7);
                ssn = rs.getInt(1);
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
                System.out.println("found citizen");
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

                journal.setStatus(Status);
                journal.setID(id);
                journal.setDate(date);
                journal.setJournalLocation(journallocation);

                list.add(journal);
            }
            System.out.println("got journals");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void addJournal(IJournal j) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            String qj = SQLSet.addJournal(j.getID(), 0, j.getJournalLocation(), j.getDate());
            String qgc = SQLGet.getCitizen(j.getCitizen().getSSN());
            String qr = SQLSet.addCitizenJournalRelation(j.getCitizen().getSSN(), j.getID());
            
            PreparedStatement preparedStmt = db.prepareStatement(qj);            
            
            System.out.println("adding journal to Database");            
            preparedStmt.execute();
            System.out.println("Successful");
            ICitizen c = j.getCitizen();
            ResultSet rs = st.executeQuery(qgc);
            if (rs.next()) {
                System.out.println("Citizen exists, Updatas info");
                saveCitizen(j.getCitizen());
            }
            else
            {
                System.out.println("No Citizen");
                addCitizen(j.getCitizen());
            }      
            System.out.println("adding relation");
            preparedStmt = db.prepareStatement(qr);
            preparedStmt.execute();
            System.out.println("succesful");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void saveJournal(IJournal j) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            String q = SQLSet.saveJournal(j.getID(), 0, j.getJournalLocation(), j.getDate());
            PreparedStatement preparedStmt = db.prepareStatement(q);
            preparedStmt.executeUpdate();
            System.out.println("saved journal");
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
                int phonenumber = rs.getInt(7);
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
                int phonenumber = rs.getInt(7);
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

    public void addCitizen(ICitizen citizen) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            String q = SQLSet.addCitizen(citizen);
            PreparedStatement preparedStmt = db.prepareStatement(q);
            preparedStmt.execute();
            System.out.println("added Citizen");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void saveCitizen(ICitizen c) {
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            String q = SQLSet.saveCitizen(c);
            PreparedStatement preparedStmt = db.prepareStatement(q);
            preparedStmt.executeUpdate();
            System.out.println("saved citizen");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }  
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

    public Collection<IAid> getAids(IAid base) {
        Collection<IAid> list = new ArrayList();
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAllAids);
            while (rs.next()) {
                IAid aid = base.clone();
                int aidNo = rs.getInt(1);
                String aName = rs.getString(2);
                String description = rs.getString(3);

                aid.setAidNo(aidNo);
                aid.setAidName(aName);
                aid.setAidDescribsion(description);
                list.add(aid);
            }
            System.out.println("got aids hæhæ");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }


}
