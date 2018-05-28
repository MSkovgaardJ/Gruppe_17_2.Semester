/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starter;

import common.IJournal;
import data.SQLGet;
import data.SQLHandler;
import data.SQLSet;
import data.postgreSQLCom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import logic.Journal;

/**
 *
 * @author Stephanie
 */
public class tester {
    public static void test ()
    {
        postgreSQLCom com = new postgreSQLCom();
        SQLHandler sql = new SQLHandler();
        
        try (Connection db = com.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("select * from appliesFor");
            while (rs.next()) {
                System.out.println("AID : "+ rs.getInt(1)+ " - JNO : "+ rs.getInt(2));
            }
            rs = st.executeQuery(SQLGet.getAllJournals);
            while (rs.next()) {
                System.out.println("JNO : "+ rs.getInt(1));
            }
            st.executeQuery(SQLSet.addAidtoJournal(3, 13));
            
            rs = st.executeQuery("select * from appliesFor");
            while (rs.next()) {
                System.out.println("AID : "+ rs.getInt(1)+ " - JNO : "+ rs.getInt(2));
            }
            
            rs.close();
            st.close();
            } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
