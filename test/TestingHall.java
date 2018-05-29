/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.SQLGet;
import data.SQLHandler;
import data.SQLSet;
import data.postgreSQLCom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Stephanie
 */
public class TestingHall {

    public static void main(String[] args) {
        testSQL();
    }

    public static void testSQL() {
        postgreSQLCom com = new postgreSQLCom();
        if (com.Connect() != null) {
            System.out.println("Connection test successful");
        } else {
            System.out.println("Connection test Failed");
        }
    }
}
