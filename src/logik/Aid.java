package logik;

import common.IAid;
import common.IDBCom;
import data.SQLGet;
import data.postgreSQLCom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morten Skovgaard
 */
<<<<<<< HEAD

public class Aid
{
    private int aidID;
    private String aidName;
    private String aidDescription;
    
    public Aid()
    {
        
    }
    
    public List<Aid> aids()
    {
        List<Aid> aids = new ArrayList<>();
        
        return aids;
    }
    
    public String getAidName(aidID)
    {
        
        return aidName;
    }
    
    public String getAidDescription(aidID)
    {
        
        return aidDescription;
=======
public class Aid implements IDBCom, IAid
{
 private int aidID;
 private String aidName;
 private String aidDescribsion;
 IDBCom comhandler;  
  
  
    public Aid(int aInt, String string, String string1){
        comhandler = new postgreSQLCom();
    }  
    @Override
    public Connection Connect(){
        try {
            Connection db = comhandler.Connect();            
            db.close();
        } catch (Exception e) {
            System.out.println(e);
        } 
     return null;
    }
    @Override
    public List<Aid>aids() throws ClassNotFoundException, SQLException{
        Statement stm;
        stm = Connect().createStatement();
        String sql = "Select * From Aid";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        List<Aid> aids = new ArrayList<>();
        while (rst.next()) {
            Aid aid = new Aid(rst.getInt("id"), rst.getString("name"), rst.getString("describsion"));
            aids.add(aid);
        }    
        aids.toString();
        return aids;
    }
    @Override
    public String getAidName(){        
        return aidName;
    }
    
    @Override
    public String getAidDescribsion(){
        return aidDescribsion;
>>>>>>> UI
    }
}
